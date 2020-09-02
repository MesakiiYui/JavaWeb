package com.mesakiiyui.test.com.mesakiiyui.springdatamysql.JUnitTest.annotation;
import com.mesakiiyui.springdatamysql.common.entity.common.annotation.ClassInfo;
import com.mesakiiyui.springdatamysql.common.entity.common.annotation.FieldInfo;
import com.mesakiiyui.springdatamysql.common.entity.common.annotation.MethodInfo;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 测试运行时注解
 * @Author: jintienan
 * @Date: 2020/7/31 16:01
 */
@ClassInfo("Test Class")
public class RuntimeAnnotationTest {
    @FieldInfo(value = {1, 2})
    public String fieldInfo = "FiledInfo";

    @FieldInfo(value = {10086})
    public int i = 100;

    @MethodInfo(name = "BlueBird", data = "Big")
    public static String getMethodInfo() {
        return RuntimeAnnotationTest.class.getSimpleName();
    }

    /**
     * 测试运行时注解
     */
    private void _testRuntimeAnnotation() {
        StringBuffer sb = new StringBuffer();
        Class<?> cls = RuntimeAnnotationTest.class;
        Constructor<?>[] constructors = cls.getConstructors();
        // 获取指定类型的注解
        sb.append("Class注解：").append("\n");
        ClassInfo classInfo = cls.getAnnotation(ClassInfo.class);
        if (classInfo != null) {
            sb.append(Modifier.toString(cls.getModifiers())).append(" ")
                    .append(cls.getSimpleName()).append("\n");
            sb.append("注解值: ").append(classInfo.value()).append("\n\n");
        }

        sb.append("Field注解：").append("\n");
        Field[] fields = cls.getDeclaredFields();// 再来获取此类中的所有字段
        for (Field field : fields) {
            FieldInfo fieldInfo = field.getAnnotation(FieldInfo.class);
            if (fieldInfo != null) {
                sb.append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ")
                        .append(field.getName()).append("\n");
                sb.append("注解值: ").append(Arrays.toString(fieldInfo.value())).append("\n\n");
            }
        }

        sb.append("Method注解：").append("\n");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            if (methodInfo != null) {
                sb.append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("\n");
                sb.append("注解值: ").append("\n");
                sb.append("name: ").append(methodInfo.name()).append("\n");
                sb.append("data: ").append(methodInfo.data()).append("\n");
                sb.append("age: ").append(methodInfo.age()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    @Test
    public void RuntimeAnnotationMainTest(){
        this._testRuntimeAnnotation();
    }

}