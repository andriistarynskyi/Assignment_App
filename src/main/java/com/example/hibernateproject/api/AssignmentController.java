package com.example.hibernateproject.api;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.Professor;
import com.example.hibernateproject.entity.Student;
import com.example.hibernateproject.service.IAssignmentService;
import com.example.hibernateproject.service.IProfessorService;
import com.example.hibernateproject.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AssignmentController {

    private final IAssignmentService assignmentService;
    private final IStudentService studentService;
    private final IProfessorService professorService;


    public AssignmentController(IAssignmentService assignmentService,
                                IStudentService studentService,
                                IProfessorService professorService) {
        this.assignmentService = assignmentService;
        this.studentService = studentService;
        this.professorService = professorService;
    }

    @GetMapping(value = "/")
    public String findAll(Model model) {
        List<Assignment> assignments = assignmentService.findAll();
        model.addAttribute("assignments", assignments);
        return "index";
    }

    @GetMapping(value = "/addAssignment")
    public String addAssignment(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        List<Professor> professors = professorService.findAll();
        model.addAttribute("professors", professors);
        model.addAttribute("assignment", new Assignment());
        return "addAssignment";
    }

    @PostMapping(value = "/addAssignment")
    public String addAssignment(@ModelAttribute Assignment assignment, Model model) {
        model.addAttribute("assignment", assignment);
        assignmentService.save(assignment);
        return "index";
    }
}

