package com.china.test.sample.tsmain.基础知识.获取路径;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * 演示几种获取当前文件所在路径的写法
 */
@Slf4j
public class 获取路径 {
    @Test
    public void testGetPath() {
        File f = new File(this.getClass().getResource("/").getPath());
        log.info("file path is {}", f.getPath());

        URL xmlPath = this.getClass().getClassLoader().getResource(".");
        log.info("xml path is {}", xmlPath.getPath());

        log.info("system property user dir is {}", System.getProperty("user.dir"));
    }

    /**
     * 获取当前java类所在路径
     */
    @Test
    public void getCurrentJavaFilePath() {
        log.info("current java class file path is {}", 获取路径.class.getResource(""));
        log.info("current java class file root path is {}", 获取路径.class.getResource("/"));
        log.info("current java class file root path is {}", new File("").getAbsoluteFile().getPath());
    }
}
