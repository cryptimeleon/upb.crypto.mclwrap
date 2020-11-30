package de.upb.crypto.math.pairings.mcl;

import com.herumi.mcl.G1;
import com.herumi.mcl.Mcl;
import com.herumi.mcl.MclConstants;
import de.upb.crypto.math.interfaces.structures.group.impl.GroupElementImpl;
import de.upb.crypto.math.random.interfaces.RandomGeneratorSupplier;
import de.upb.crypto.math.serialization.Representation;

public class MclGroup1Impl extends MclGroupImpl {
    protected MclGroup1ElementImpl generator = null;

    public MclGroup1Impl(int curveType) {
        super(curveType);
    }

    public MclGroup1Impl(Representation repr) {
        super(repr);
    }

    @Override
    public MclGroup1ElementImpl getElement(String string) {
        return createElement(getInternalObjectFromString(string));
    }
    
    public GroupElementImpl getElement(Representation repr) {
        return new MclGroup1ElementImpl(this, repr);
    }

    @Override
    protected G1 getInternalObjectFromString(String str) {
        G1 result = new G1();
        result.setStr(str);
        return result;
    }

    protected MclGroup1ElementImpl createElement(G1 g1) {
        return new MclGroup1ElementImpl(this, g1);
    }

    @Override
    public MclGroup1ElementImpl getNeutralElement() {
        return getElement("0");
    }

    @Override
    public MclGroup1ElementImpl getUniformlyRandomElement() throws UnsupportedOperationException {
        return getGenerator().pow(RandomGeneratorSupplier.getRnd().getRandomElement(size()));
    }

    @Override
    public MclGroup1ElementImpl getGenerator() throws UnsupportedOperationException {
        if (generator != null && curveType.equals(generatorCurveType))
            return generator;
        G1 res = new G1();
        if (curveType.equals(MclConstants.BN254)) {
            Mcl.hashAndMapToG1(res, "some arbitrary element".getBytes());
        } else {
            res = getInternalObjectFromString("1 " +
                    "368541675371338701678108831518307775796162079578254640989" +
                    "4578378688607592378376318836054947676345821548104185464507 " +
                    "1339506544944476473020471379941921221584933875938349620426" +
                    "543736416511423956333506472724655353366534992391756441569");
        }
        generatorCurveType = curveType;
        return generator = createElement(res);
    }

    @Override
    public double estimateCostInvPerOp() {
        return 1.875;
    }
}
