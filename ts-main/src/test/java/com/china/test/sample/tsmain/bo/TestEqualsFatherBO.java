package com.china.test.sample.tsmain.bo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 这是爸爸类
 */
public class TestEqualsFatherBO implements Serializable{
    /**
     * 序列号
     */
    private static final long serialVersionUID = -7893161093035946545L;

    private String A;

    private int B;

    private boolean C;

    private List<TestEqualsSonBO> testsEqualsSonBOs;


    public TestEqualsFatherBO() {
    }

    public TestEqualsFatherBO(String A, int B, boolean C, List<TestEqualsSonBO> testsEqualsSonBOs) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.testsEqualsSonBOs = testsEqualsSonBOs;
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

    public List<TestEqualsSonBO> getTestsEqualsSonBOs() {
        return this.testsEqualsSonBOs;
    }

    public void setTestsEqualsSonBOs(List<TestEqualsSonBO> testsEqualsSonBOs) {
        this.testsEqualsSonBOs = testsEqualsSonBOs;
    }

    public TestEqualsFatherBO A(String A) {
        this.A = A;
        return this;
    }

    public TestEqualsFatherBO B(int B) {
        this.B = B;
        return this;
    }

    public TestEqualsFatherBO C(boolean C) {
        this.C = C;
        return this;
    }

    public TestEqualsFatherBO testsEqualsSonBOs(List<TestEqualsSonBO> testsEqualsSonBOs) {
        this.testsEqualsSonBOs = testsEqualsSonBOs;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TestEqualsFatherBO)) {
            return false;
        }
        TestEqualsFatherBO testEqualsFatherBO = (TestEqualsFatherBO) o;
        return Objects.equals(A, testEqualsFatherBO.A) && B == testEqualsFatherBO.B && C == testEqualsFatherBO.C && Objects.equals(testsEqualsSonBOs, testEqualsFatherBO.testsEqualsSonBOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C, testsEqualsSonBOs);
    }

    @Override
    public String toString() {
        return "{" +
            " A='" + getA() + "'" +
            ", B='" + getB() + "'" +
            ", C='" + isC() + "'" +
            ", testsEqualsSonBOs='" + getTestsEqualsSonBOs() + "'" +
            "}";
    }

}