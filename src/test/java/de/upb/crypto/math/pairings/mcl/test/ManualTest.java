package de.upb.crypto.math.pairings.mcl.test;

import com.herumi.mcl.MclConstants;
import de.upb.crypto.math.factory.BilinearGroupImpl;
import de.upb.crypto.math.interfaces.structures.group.impl.GroupElementImpl;
import de.upb.crypto.math.pairings.mcl.MclBilinearGroupImpl;

public class ManualTest {
    public static void main(String args[]) {
        MclBilinearGroupImpl bilinearGroup = new MclBilinearGroupImpl(MclConstants.BN254);
        GroupElementImpl g = bilinearGroup.getG1().getUniformlyRandomElement();
        System.out.println(g);
        MclBilinearGroupImpl.init(false, MclConstants.BLS12_381);
        System.out.println(g);
        MclBilinearGroupImpl.init(false, MclConstants.BN254);
        System.out.println(g);

    }
}
