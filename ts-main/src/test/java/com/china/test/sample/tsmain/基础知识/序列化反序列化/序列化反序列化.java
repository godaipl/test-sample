package com.china.test.sample.tsmain.基础知识.序列化反序列化;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * https://www.cnblogs.com/xdp-gacl/p/3777987.html
 *
 * serialVersionUID的取值是Java运行时环境根据类的内部细节自动生成的。如果对类的源代码作了修改，再重新编译，新生成的类文件的serialVersionUID的取值有可能也会发生变化。
 * 类的serialVersionUID的默认值完全依赖于Java编译器的实现，对于同一个类，用不同的Java编译器编译，有可能会导致不同的 serialVersionUID，也有可能相同。为了提高serialVersionUID的独立性和确定性，强烈建议在一个可序列化类中显示的定义serialVersionUID，为它赋予明确的值。
 * 显式地定义serialVersionUID有两种用途：
 * 　　1、 在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
 * 　　2、 在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
 */
@Slf4j
public class 序列化反序列化 {
    private String currentPath = System.getProperty("user.dir") + "/src/test/java/com/china/test/sample/tsmain/基础知识/序列化反序列化/";

    /**
     * 序列化
     */
    @Test
    public void serializePerson() throws IOException {
        Person person = new Person();
        person.setUserName("yan");
        person.setAge(25);
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File(currentPath + "Person.txt")));
        oo.writeObject(person);
        log.info("Person对象序列化成功！");
        oo.close();
    }

    /**
     * 反序列化
     */
    @Test
    public void deserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(currentPath + "Person.txt")));
        Person person = (Person) ois.readObject();
        log.info("Person对象反序列化成功！{}", person);
        ois.close();
    }

    /**
     * 序列化
     */
    @Test
    public void serializePersonUID() throws IOException {
        PersonNoUID person = new PersonNoUID();
        person.setUserName("yan");
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File(currentPath + "PersonNoUID.txt")));
        oo.writeObject(person);
        log.info("Person对象序列化成功！");
        oo.close();
    }

    /**
     * 反序列化
     * <p>
     * 在上述序列化之后，如果不对类中的元素进行修改，以下代码不会抛异常，
     * 如果在PersonNoUID中添加元素，如private String sex; 以下代码则会出现异常
     */
    @Test
    public void deserializePersonUID() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(currentPath + "PersonNoUID.txt")));
        PersonNoUID personNoUID = (PersonNoUID) ois.readObject();
        log.info("PersonNoUID对象反序列化成功！{}", personNoUID);
        ois.close();
    }
}