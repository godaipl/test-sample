package com.china.test.sample.tsmain.bo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 这是儿子类
 */
public class TestEqualsSonBO implements Serializable {
    
    /**
     * 序列号
     */
    private static final long serialVersionUID = 2306565758190342833L;

    private String sonA;

    private int sonB;

    private boolean sonC;


    public TestEqualsSonBO() {
    }

    public TestEqualsSonBO(String sonA, int sonB, boolean sonC) {
        this.sonA = sonA;
        this.sonB = sonB;
        this.sonC = sonC;
    }

    public String getSonA() {
        return this.sonA;
    }

    public void setSonA(String sonA) {
        this.sonA = sonA;
    }

    public int getSonB() {
        return this.sonB;
    }

    public void setSonB(int sonB) {
        this.sonB = sonB;
    }

    public boolean isSonC() {
        return this.sonC;
    }

    public boolean getSonC() {
        return this.sonC;
    }

    public void setSonC(boolean sonC) {
        this.sonC = sonC;
    }

    public TestEqualsSonBO sonA(String sonA) {
        this.sonA = sonA;
        return this;
    }

    public TestEqualsSonBO sonB(int sonB) {
        this.sonB = sonB;
        return this;
    }

    public TestEqualsSonBO sonC(boolean sonC) {
        this.sonC = sonC;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TestEqualsSonBO)) {
            return false;
        }
        TestEqualsSonBO testEqualsSonBO = (TestEqualsSonBO) o;
        return Objects.equals(sonA, testEqualsSonBO.sonA) && sonB == testEqualsSonBO.sonB && sonC == testEqualsSonBO.sonC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sonA, sonB, sonC);
    }

    @Override
    public String toString() {
        return "{" +
            " sonA='" + getSonA() + "'" +
            ", sonB='" + getSonB() + "'" +
            ", sonC='" + isSonC() + "'" +
            "}";
    }

}