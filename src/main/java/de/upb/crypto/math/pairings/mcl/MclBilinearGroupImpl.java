package de.upb.crypto.math.pairings.mcl;

import com.herumi.mcl.Mcl;
import com.herumi.mcl.MclConstants;
import de.upb.crypto.math.factory.BilinearGroupImpl;
import de.upb.crypto.math.interfaces.mappings.impl.BilinearMapImpl;
import de.upb.crypto.math.interfaces.mappings.impl.GroupHomomorphismImpl;
import de.upb.crypto.math.interfaces.mappings.impl.HashIntoGroupImpl;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.StringRepresentation;

public class MclBilinearGroupImpl implements BilinearGroupImpl {
    protected static boolean isInitialized = false;
    protected static int curveType = -1;
    protected static MclGroup1Impl g1;
    protected static MclGroup2Impl g2;
    protected static MclGroupTImpl gt;

    protected static MclHashIntoG1Impl hashIntoG1 = new MclHashIntoG1Impl(g1);
    protected static MclHashIntoG2Impl hashIntoG2 = new MclHashIntoG2Impl(g2);

    public MclBilinearGroupImpl(int curveType) {
        init(false, curveType);
    }

    public static void init(boolean printError, int curveType) {
        if (curveType != MclBilinearGroupImpl.curveType) {
            String lib = "mcljava";
            if (!isInitialized) {
                try {
                    System.loadLibrary(lib);
                } catch (UnsatisfiedLinkError le) {
                    if (printError) {
                        le.printStackTrace();
                        String libName = System.mapLibraryName(lib);
                        System.err.println("If you get this error, you need to put the file " + libName + " into one of the lib directories:");
                        System.err.println(System.getProperty("java.library.path"));
                    }
                    return;
                }
            }
            try {
                Mcl.SystemInit(curveType);
            } catch (UnsatisfiedLinkError le) {
                if (printError) {
                    le.printStackTrace();
                    System.err.println("mcl library was found, but its functions cannot be called properly");
                }
                return;
            }
            isInitialized = true;
            MclBilinearGroupImpl.curveType = curveType;
            g1 = new MclGroup1Impl(curveType);
            g2 = new MclGroup2Impl(curveType);
            gt = new MclGroupTImpl(curveType);
        }
    }

    public static boolean isAvailable() {
        //init(false, curveType);
        return isInitialized;
    }

    @Override
    public MclGroup1Impl getG1() {
        return g1;
    }

    @Override
    public MclGroup2Impl getG2() {
        return g2;
    }

    @Override
    public MclGroupTImpl getGT() {
        return gt;
    }

    @Override
    public BilinearMapImpl getBilinearMap() {
        return new MclPairing(this);
    }

    @Override
    public GroupHomomorphismImpl getHomomorphismG2toG1() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("No homomorphism (type 3)");
    }

    @Override
    public HashIntoGroupImpl getHashIntoG1() throws UnsupportedOperationException {
        return hashIntoG1;
    }

    @Override
    public HashIntoGroupImpl getHashIntoG2() throws UnsupportedOperationException {
        return hashIntoG2;
    }

    @Override
    public HashIntoGroupImpl getHashIntoGT() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("No hash available.");
    }

    @Override
    public Representation getRepresentation() {
        switch (curveType) {
            case MclConstants.BN254:
                return new StringRepresentation("bn254");
            case MclConstants.BLS12_381:
                return new StringRepresentation("bls12_381");
            default:
                throw new IllegalStateException("Unsupported curve type " + curveType);
        }
    }
}
