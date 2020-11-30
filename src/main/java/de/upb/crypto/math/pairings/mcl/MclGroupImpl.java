package de.upb.crypto.math.pairings.mcl;

import de.upb.crypto.math.interfaces.structures.group.impl.GroupElementImpl;
import de.upb.crypto.math.interfaces.structures.group.impl.GroupImpl;
import de.upb.crypto.math.serialization.Representation;
import de.upb.crypto.math.serialization.StringRepresentation;
import de.upb.crypto.math.serialization.annotations.v2.ReprUtil;
import de.upb.crypto.math.serialization.annotations.v2.Represented;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public abstract class MclGroupImpl implements GroupImpl {

    @Represented
    Integer curveType;
    @Represented
    Integer generatorCurveType = -1;

    public MclGroupImpl(int curveType) {
        this.curveType = curveType;
        MclBilinearGroupImpl.init(true, curveType);
    }

    public MclGroupImpl(Representation repr) {
        new ReprUtil(this).deserialize(repr);
    }

    @Override
    public BigInteger size() throws UnsupportedOperationException {
        return new BigInteger("16798108731015832284940804142231733909759579603404752749028378864165570215949");
    }

    @Override
    public boolean hasPrimeSize() throws UnsupportedOperationException {
        return true;
    }

    protected abstract MclGroupElementImpl getElement(String string);

    /**
     * Outputs an object of type mcl.G1, mcl.G2, or mcl.GT
     */
    protected abstract Object getInternalObjectFromString(String str);

    @Override
    public Optional<Integer> getUniqueByteLength() {
        return Optional.empty(); //TODO replace with actual value for better performance
    }

    @Override
    public boolean isCommutative() {
        return true;
    }

    @Override
    public Representation getRepresentation() {
        return ReprUtil.serialize(this);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || this.getClass() != other.getClass())
            return false;
        MclGroupImpl obj = (MclGroupImpl) other;
        return Objects.equals(curveType, obj.curveType);
    }

    @Override
    public int hashCode() {
        return curveType.hashCode();
    }
}
