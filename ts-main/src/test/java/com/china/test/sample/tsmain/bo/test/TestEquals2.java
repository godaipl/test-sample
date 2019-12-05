package com.china.test.sample.tsmain.bo.test;

import com.china.test.sample.tsmain.bo.TestEqualsSonBO;

import java.util.List;
import java.util.Objects;

public class TestEquals2 {
    private String A;

    private int B;

    private boolean C;

    List<TestEqualsSonBO> testsEqualsSonBOs;

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public boolean isC() {
        return C;
    }

    public void setC(boolean c) {
        C = c;
    }

    public List<TestEqualsSonBO> getTestsEqualsSonBOs() {
        return testsEqualsSonBOs;
    }

    public void setTestsEqualsSonBOs(List<TestEqualsSonBO> testsEqualsSonBOs) {
        this.testsEqualsSonBOs = testsEqualsSonBOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEquals2 that = (TestEquals2) o;
        return B == that.B &&
                C == that.C &&
                Objects.equals(A, that.A) &&
                Objects.equals(testsEqualsSonBOs, that.testsEqualsSonBOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C, testsEqualsSonBOs);
    }

    @Override
    public String toString() {
        return "TestEquals2{" +
                "A='" + A + '\'' +
                ", B=" + B +
                ", C=" + C +
                ", testsEqualsSonBOs=" + testsEqualsSonBOs +
                '}';
    }
}