package com.china.test.sample.tsmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 需要说明的是主启动类，要在所有的包的上一层，比如在com.china.test.sample目录下，其它类，都需要在这个目录下，才能被启动类扫描到
 *
 * @author yandongjun
 */
@SpringBootApplication
public class TsMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsMainApplication.class, args);
    }

}
