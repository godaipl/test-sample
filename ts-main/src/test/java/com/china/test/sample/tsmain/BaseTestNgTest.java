package com.china.test.sample.tsmain;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = { TsMainApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTestNgTest extends AbstractTestNGSpringContextTests {
}
