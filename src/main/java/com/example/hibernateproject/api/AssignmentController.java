package com.example.hibernateproject.api;

import com.example.hibernateproject.entity.dto.AssignmentDTO;
import com.example.hibernateproject.service.IAssignmentService;
import com.example.hibernateproject.service.IMapService;
import com.example.hibernateproject.service.IProfessorService;
import com.example.hibernateproject.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AssignmentController {

    private final IAssignmentService assignmentService;
    private final IStudentService studentService;
    private final IProfessorService professorService;
    private final IMapService mapService;


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
        model.addAttribute("assignmentDTO", new AssignmentDTO());
        return "add_assignment";
    }

    @PostMapping("/add_assignment")
    public String submitForm(@ModelAttribute AssignmentDTO assignmentDTO, Model model) {
        model.addAttribute("assignmentDTO", assignmentDTO);
        assignmentService.save(mapService.getAssignment(assignmentDTO));
        return "redirect:/";
    }
}