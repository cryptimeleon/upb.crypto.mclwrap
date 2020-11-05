package de.upb.crypto.math.pairings.mcl;

import com.herumi.mcl.MclConstants;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.StringRepresentation;

public class MclBN254BilinearGroupImpl extends MclBilinearGroupImpl {

    public MclBN254BilinearGroupImpl() {
        init(true, MclConstants.BN254);
    }

    public MclBN254BilinearGroupImpl(Representation repr) {
        this();
        if (!repr.str().get().equals("bn254")) {
            throw new IllegalArgumentException("Invalid representation");
        }
    }

    public static boolean isAvailable() {
        init(false, MclConstants.BN254);
        return isInitialized;
    }


    @Override
    public Representation getRepresentation() {
        return new StringRepresentation("bn256");
    }
}
