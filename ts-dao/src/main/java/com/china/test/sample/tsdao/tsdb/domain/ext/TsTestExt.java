package com.china.test.sample.tsdao.tsdb.domain.ext;

import java.io.Serializable;

/**
 * 作为演示用，我们只查询id和userName
 *
 * @author yandongjun
 */
public class TsTestExt implements Serializable {
    private Integer id;
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}