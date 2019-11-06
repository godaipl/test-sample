package com.china.test.sample.tsmain;

import com.china.test.sample.TsMainApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TsMainApplication.class)
public class BaseJunitTest {
    @Test
    public void baseTest() {
        System.out.printf("baseTest");
    }
}
