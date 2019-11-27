package com.china.test.sample.tsmain;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试类
 */
@Slf4j
public class TestSomeThing {
    public static void main(String[] args) {
        log.info("isNumeric result is {}", isNumeric("a"));
    }

    private static boolean isNumeric(String numberStr) {
        if (StringUtils.isNotEmpty(numberStr)) {
            try {
                new BigDecimal(numberStr);
                return true;
            } catch (Exception e) {
                log.error("isNumeric error", e);
            }
        }

        return false;
    }
}