package de.upb.crypto.math.pairings.mcl;

import de.upb.crypto.math.factory.BilinearGroup;
import de.upb.crypto.math.factory.BilinearGroupImpl;
import de.upb.crypto.math.factory.BilinearGroupProvider;
import de.upb.crypto.math.factory.BilinearGroupRequirement;
import de.upb.crypto.math.interfaces.mappings.BilinearMap;
import de.upb.crypto.math.structures.groups.lazy.LazyBilinearGroup;

import static de.upb.crypto.math.factory.BilinearGroup.Type.TYPE_3;

public class MclBN254BilinearGroupProvider implements BilinearGroupProvider {

    @Override
    public BilinearGroup provideBilinearGroup(int securityParameter, BilinearGroupRequirement requirements) {
        if (!checkRequirements(securityParameter, requirements)) {
            throw new IllegalArgumentException("The requirements are not fulfilled by this bilinear group");
        }
        return new LazyBilinearGroup(new MclBN254BilinearGroupImpl());
    }

    /**
     * Constructor without unnecessary parameters.
     */
    public BilinearGroup provideBilinearGroup() {
        return new LazyBilinearGroup(new MclBN254BilinearGroupImpl());
    }

    @Override
    public BilinearGroupImpl provideBilinearGroupImpl(int securityParameter, BilinearGroupRequirement requirements) {
        return new MclBN254BilinearGroupImpl();
    }

    @Override
    public boolean checkRequirements(int securityParameter, BilinearGroupRequirement requirements) {
        return MclBN254BilinearGroupImpl.isAvailable()
                && requirements.getNumPrimeFactorsOfSize() == 1
                && requirements.getType() == TYPE_3
                && securityParameter <= 100
                && !requirements.isHashIntoGTNeeded();
    }
}
