package com.example.hibernateproject;

import com.example.hibernateproject.entity.User;
import com.example.hibernateproject.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        IUserService userService = ctx.getBean(IUserService.class);

        User user = userService.findById(1);
        System.out.println(user);
        user.setsName("Karambol");
        userService.save(user);
        userService.findAll().forEach(u -> System.out.println(u));
    }
}
