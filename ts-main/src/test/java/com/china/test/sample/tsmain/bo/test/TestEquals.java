package com.china.test.sample.tsmain.bo.test;

import java.util.Objects;

public class TestEquals {
    private String A;

    private int B;

    private boolean C;


    public TestEquals() {
    }

    public TestEquals(String A, int B, boolean C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public String getA() {
        return this.A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public int getB() {
        return this.B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public boolean isC() {
        return this.C;
    }

    public boolean getC() {
        return this.C;
    }

    public void setC(boolean C) {
        this.C = C;
    }

    public TestEquals A(String A) {
        this.A = A;
        return this;
    }

    public TestEquals B(int B) {
        this.B = B;
        return this;
    }

    public TestEquals C(boolean C) {
        this.C = C;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TestEquals)) {
            return false;
        }
        TestEquals testEquals = (TestEquals) o;
        return Objects.equals(A, testEquals.A) && B == testEquals.B && C == testEquals.C;
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C);
    }

    @Override
    public String toString() {
        return "{" +
            " A='" + getA() + "'" +
            ", B='" + getB() + "'" +
            ", C='" + isC() + "'" +
            "}";
    }

}