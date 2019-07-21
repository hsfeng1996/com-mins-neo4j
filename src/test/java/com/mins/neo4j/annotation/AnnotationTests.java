package com.mins.neo4j.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AnnotationTests {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Person person = new Person();
        Field value = person.getClass().getDeclaredField("name");
        value.setAccessible(true);
        //APIParam 是一个自定义的注解
        ApiParam apiParam = person.getClass().getAnnotation(ApiParam.class);
        java.lang.reflect.InvocationHandler invocationHandler = Proxy.getInvocationHandler(apiParam);
        Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
        //通过反射获取memberValues  这个属性是Map类型 存放着所有的属性。
        memberValues.setAccessible(true);
        Map<String, Object> values = (Map<String, Object>) memberValues.get(invocationHandler);
        String val = (String) values.get("access");
        System.out.println("------改之前:"+val);
        values.put("access", "fafa");//修改属性
        System.out.println("-----------------");
        //Field value1 = person.getClass().getDeclaredField("name");
        value.setAccessible(true);
        ApiParam apiParam1 = person.getClass().getAnnotation(ApiParam.class);

        System.out.println("------改之后:"+apiParam1.access());
        //动态代理的方式不会改变原先class文件的内容
    }

}
