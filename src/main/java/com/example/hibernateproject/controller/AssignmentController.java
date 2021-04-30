package com.example.hibernateproject.controller;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.Professor;
import com.example.hibernateproject.entity.Student;
import com.example.hibernateproject.entity.dto.AssignmentDTO;
import com.example.hibernateproject.service.IAssignmentService;
import com.example.hibernateproject.service.IMapService;
import com.example.hibernateproject.service.IProfessorService;
import com.example.hibernateproject.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AssignmentController {

    private final IAssignmentService assignmentService;
    private final IStudentService studentService;
    private final IProfessorService professorService;
    private final IMapService mapService;

    @Autowired
    public AssignmentController(IAssignmentService assignmentService,
                                IStudentService studentService,
                                IProfessorService professorService,
                                IMapService mapService) {
        this.assignmentService = assignmentService;
        this.studentService = studentService;
        this.professorService = professorService;
        this.mapService = mapService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<AssignmentDTO> assignmentDTOList = assignmentService.findAll().
                stream().
                map(a -> mapService.getAssigmentDTO(a)).
                collect(Collectors.toList());
        model.addAttribute("assignmentDTOList", assignmentDTOList);
        return "index";
    }

    @GetMapping("/add_assignment")
    public String addAssigment(Model model) {
        List<AssignmentDTO> assignmentDTOList = assignmentService.findAll().
                stream().
                map(a -> mapService.getAssigmentDTO(a)).
                collect(Collectors.toList());
        model.addAttribute("assignmentDTOList", assignmentDTOList);
        List<Professor> professors = professorService.findAll();
        model.addAttribute("professors", professors);
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        model.addAttribute("assignmentDTO", new AssignmentDTO());
        return "add_assignment";
    }

    @PostMapping("/add_assignment")
    public String submitForm(@ModelAttribute AssignmentDTO assignmentDTO, Model model) {
        model.addAttribute("assignmentDTO", assignmentDTO);
        assignmentService.save(mapService.getAssignment(assignmentDTO));
        return "redirect:/";
    }

    @GetMapping("assignment/{id}/delete")
    public String getAssignmentById(@PathVariable("id") String id, Model model) {
        int assignmentId = Integer.parseInt(id);
        Assignment assignment = assignmentService.findById(assignmentId).orElseThrow(RuntimeException::new);
        AssignmentDTO assignmentDTO = mapService.getAssigmentDTO(assignment);
        model.addAttribute("assignmentDTO", assignmentDTO);
        return "delete";
    }

    @PostMapping("assignment/{id}/delete")
    public String remove(@PathVariable("id") String id) {
        int assignmentId = Integer.parseInt(id);
        Assignment assignment = assignmentService.findById(assignmentId).orElseThrow(RuntimeException::new);
        assignmentService.delete(assignment);
        return "redirect:/";
    }
}