package com.example.hibernateproject;

import com.example.hibernateproject.entity.*;
import com.example.hibernateproject.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        IAssignmentService assignmentService = ctx.getBean(IAssignmentService.class);
        ICommentService commentService = ctx.getBean(ICommentService.class);
        IProfessorService professorService = ctx.getBean(IProfessorService.class);
        IStudentService studentService = ctx.getBean(IStudentService.class);
        IUniversityService universityService = ctx.getBean(IUniversityService.class);

//        universityService.save(new University("KNEU"));
        professorService.save(new Professor("Mr. Jenkins", universityService.findById(1)));

//
//        Student student = new Student("Mr Bob");
//        studentService.save(student);
//
//        Assignment assignment = new Assignment("askjdhkajsh", professorService.findById(1),
//                studentService.findById(1));
//        assignmentService.save(assignment);
//
//        commentService.save(new Comment("slkdjfklsdj",
//                studentService.findById(1),
//                assignmentService.findById(1)));
//
    }
}