package com.china.test.sample.tsweb.views;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author yandongjun
 * @date 2019/11/12
 * 
 *       理论上我们可以直接将数据库的类直接传递给前端， 我们推荐前端展示使用新类，解耦，具体的好处我们看下面
 */
public class TsTestVO implements Serializable {
    /**
     * 序列化id
     */
    private static final long serialVersionUID = -7049433696937121921L;

    /**
     * 前端展示用户名称
     */
    private String name;

    /**
     * 前端展示的额外信息，数据库中不存在
     */
    private String extraInfo;


    public TsTestVO() {
    }

    public TsTestVO(String name, String extraInfo) {
        this.name = name;
        this.extraInfo = extraInfo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public TsTestVO name(String name) {
        this.name = name;
        return this;
    }

    public TsTestVO extraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TsTestVO)) {
            return false;
        }
        TsTestVO tsTestVO = (TsTestVO) o;
        return Objects.equals(name, tsTestVO.name) && Objects.equals(extraInfo, tsTestVO.extraInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, extraInfo);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", extraInfo='" + getExtraInfo() + "'" +
            "}";
    }
    
}