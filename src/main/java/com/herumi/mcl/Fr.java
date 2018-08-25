/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.herumi.mcl;

public class Fr {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;

    protected Fr(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected static long getCPtr(Fr obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                Bn256JNI.delete_Fr(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public Fr() {
        this(Bn256JNI.new_Fr__SWIG_0(), true);
    }

    public Fr(Fr rhs) {
        this(Bn256JNI.new_Fr__SWIG_1(Fr.getCPtr(rhs), rhs), true);
    }

    public Fr(int x) {
        this(Bn256JNI.new_Fr__SWIG_2(x), true);
    }

    public Fr(String str) {
        this(Bn256JNI.new_Fr__SWIG_3(str), true);
    }

    public boolean equals(Fr rhs) {
        return Bn256JNI.Fr_equals(swigCPtr, this, Fr.getCPtr(rhs), rhs);
    }

    public void setStr(String str) {
        Bn256JNI.Fr_setStr(swigCPtr, this, str);
    }

    public void setInt(int x) {
        Bn256JNI.Fr_setInt(swigCPtr, this, x);
    }

    public void clear() {
        Bn256JNI.Fr_clear(swigCPtr, this);
    }

    public void setRand() {
        Bn256JNI.Fr_setRand(swigCPtr, this);
    }

    public String toString() {
        return Bn256JNI.Fr_toString(swigCPtr, this);
    }

}
