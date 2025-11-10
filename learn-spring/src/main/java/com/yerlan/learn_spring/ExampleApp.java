package com.yerlan.learn_spring;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yerlan.learn_spring.example.HelloWorldConfiguration;

public class ExampleApp {
    public static void main(String[] args) {
        // 1. Launch a Spring Context 
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // 2. Congigure so Spring managed through Configuration 
        // so we didnt create object, just called the bean
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("address2"));

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out :: println);
        }
        
    }
}
