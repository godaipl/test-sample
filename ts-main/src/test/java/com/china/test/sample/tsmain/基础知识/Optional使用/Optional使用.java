package com.china.test.sample.tsmain.基础知识.Optional使用;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * Optional使用说明
 * <p>
 * 可以这样总结Optional的使用：
 * <p>
 * 当使用值为空的情况，并非源于错误时，可以使用Optional!
 * Optional不要用于集合操作!
 * 不要滥用Optional,比如在java bean的getter中!
 */
@Slf4j
public class Optional使用 {
    @Test
    public void testOptional() {
        Optional<OptionalPOJO> optionalPOJOOptional = getOptionalPOJOById(1);
        if (optionalPOJOOptional.isPresent()) {
            log.info("optionalPOJOOptional is {}", optionalPOJOOptional);
        } else {
            log.info("optionalPOJOOptional is empty");
        }

        Optional.ofNullable(getOptionalPOJO()).ifPresent(optionalPOJO -> {
            log.info("optionalPOJO's name is {}", optionalPOJO.getName());
            log.info("optionalPOJO's age is {}", optionalPOJO.getAge());
        });

        List<OptionalPOJO> optionalPOJOs1 = listOptionalPOs1();
        List<OptionalPOJO> optionalPOJOs2 = listOptionalPOs2();
    }

    /**
     * 通过id获取对象
     *
     * @param id
     * @return
     */
    public Optional<OptionalPOJO> getOptionalPOJOById(Integer id) {
        OptionalPOJO optionalPOJO = null;
        return Optional.ofNullable(optionalPOJO);
    }

    private OptionalPOJO getOptionalPOJO() {
        return getOptionalPOs().get(0);
    }

    /**
     * 通常写法,空的话返回null
     *
     * @return
     */
    public List<OptionalPOJO> listOptionalPOs1() {
        List<OptionalPOJO> optionalPOJOs = getOptionalPOs();
        if (CollectionUtils.isEmpty(optionalPOJOs)) {
            return null;
        }

        return optionalPOJOs;
    }

    /**
     * 推荐如果为空，就返回一个空的集合
     * <p>
     * 我们要约定，对于List这种集合返回值，如果集合真的是null的，请返回空集合(Lists.newArrayList);
     *
     * @return
     */
    public List<OptionalPOJO> listOptionalPOs2() {
        List<OptionalPOJO> optionalPOJOs = getOptionalPOs();
        if (CollectionUtils.isEmpty(optionalPOJOs)) {
            return Lists.newArrayList();
        }

        return optionalPOJOs;
    }

    private List<OptionalPOJO> getOptionalPOs() {
        List<OptionalPOJO> optionalPOJOs = Lists.newArrayList();
        OptionalPOJO optionalPOJO = new OptionalPOJO();
        optionalPOJO.setName("test");
        optionalPOJO.setAge(10);

        optionalPOJOs.add(optionalPOJO);

        return optionalPOJOs;
    }

}
