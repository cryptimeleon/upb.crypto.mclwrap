package de.upb.crypto.math.pairings.mcl;

import com.herumi.mcl.MclConstants;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.StringRepresentation;

public class MclBLS12381BilinearGroupImpl extends MclBilinearGroupImpl {

    public MclBLS12381BilinearGroupImpl() {
        init(true, MclConstants.BLS12_381);
    }

    public MclBLS12381BilinearGroupImpl(Representation repr) {
        this();
        if (!repr.str().get().equals("bl12_381")) {
            throw new IllegalArgumentException("Invalid representation");
        }
    }

    public static boolean isAvailable() {
        init(false, MclConstants.BLS12_381);
        return isInitialized;
    }


    @Override
    public Representation getRepresentation() {
        return new StringRepresentation("bl12_381");
    }
}
