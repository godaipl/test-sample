package com.china.test.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 需要说明的是主启动类，要在所有的包的上一层，比如在com.china.test.sample目录下
 * 其它类，都需要在这个目录下，才能被启动类扫描到, 其它模块目录如
 * com.china.test.sample.tsweb
 * com.china.test.sample.tscontroller
 * com.china.test.sample.tservice
 * com.china.test.sample.tsdao
 *
 * @author yandongjun
 */
@SpringBootApplication
public class TsMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsMainApplication.class, args);
    }

}
