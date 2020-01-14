package com.china.test.sample.tsmain.老婆的测试目录.对象拷贝;

import com.china.test.sample.TsMainApplication;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/weixin_38229356/article/details/81396572
 *
 * @author yandongjun
 */
@Slf4j
@SpringBootTest(classes = {TsMainApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestObjectCopy extends AbstractTestNGSpringContextTests {
    @Test
    public void testObjectCopy() {
        List<OriginalObject> originalObjects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OriginalObject originalObject = new OriginalObject();
            originalObject.setId(i);
            originalObject.setName("name is " + i);
            originalObject.setAddress("address is " + i);
            originalObjects.add(originalObject);
        }
        List<TargetObject> targetObjects = new ArrayList<>();
        for (int i = 0; i < originalObjects.size(); i++) {
            TargetObject targetObject = new TargetObject();
            BeanUtils.copyProperties(originalObjects.get(i), targetObject);
            targetObjects.add(targetObject);
        }

        log.info("targetObjects is {}", targetObjects);
    }
}

@Data
class OriginalObject {
    private int id;

    private String name;

    private String address;
}

@Data
class TargetObject {
    private String name;
}
