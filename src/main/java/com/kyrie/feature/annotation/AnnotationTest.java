package com.kyrie.feature.annotation;


import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";
}


/**
 * Created by tend on 2020/9/22.
 */
class Person {

    /**
     * empty()方法同时被 "@Deprecated" 和 "@MyAnnotation(value={"a","b"})"所标注
     * (01) @Deprecated，意味着empty()方法，不再被建议使用
     * (02) @MyAnnotation, 意味着empty() 方法对应的MyAnnotation的value值是默认值"unknown"
     */
    @MyAnnotation
    @Deprecated
    public void empty(){
        System.out.println("\nempty");
    }

    /**
     * sombody() 被 @MyAnnotation(value={"girl","boy"}) 所标注，
     * @MyAnnotation(value={"girl","boy"}), 意味着MyAnnotation的value值是{"girl","boy"}
     */
    @MyAnnotation(value={"boy","girl"})
    public void somebody(String name,int age){
        System.out.println("\nsomebody: "+name+", "+age);
    }
}

public class AnnotationTest{

    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Class<Person> personClass = Person.class;
        //获取方法实例
        Method mSomebody = personClass.getMethod("somebody", new Class[]{String.class, int.class});

        //执行该方法
        mSomebody.invoke(person,new Object[]{"lili",20});

        //遍历注解
        iteratorAnotations(mSomebody);


        // 获取 empty() 方法的Method实例
        Method mEmpty = personClass.getMethod("empty", new Class[]{});
        // 执行该方法
        mEmpty.invoke(person, new Object[]{});
        iteratorAnotations(mEmpty);
    }

    public static void iteratorAnotations(Method method){
        //判断 somebody() 方法是否包含MyAnnotation注解
        if(method.isAnnotationPresent(MyAnnotation.class)){
            //获取注解实例
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            //获取注解的值
            String[] values = annotation.value();

            for(String str:values){
                System.out.printf(str+", ");
            }
            System.out.println();
        }
        //获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for(Annotation a: annotations){
            System.out.println(a);
        }

    }

}
