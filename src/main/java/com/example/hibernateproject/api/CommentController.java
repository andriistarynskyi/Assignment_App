package com.example.hibernateproject.api;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.dto.AssignmentDTO;
import com.example.hibernateproject.service.IAssignmentService;
import com.example.hibernateproject.service.ICommentService;
import com.example.hibernateproject.service.IMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CommentController {
    private final ICommentService commentService;
    private final IAssignmentService assignmentService;
    private final IMapService mapService;

    @Autowired
    public CommentController(ICommentService commentService,
                             IAssignmentService assignmentService,
                             IMapService mapService) {
        this.commentService = commentService;
        this.assignmentService = assignmentService;
        this.mapService = mapService;
    }

    @GetMapping("assignment/{id}")
    public String getAssignmentById(@PathVariable("id") String id, Model model) {
        int assignmentId = Integer.valueOf(id);
        Optional<Assignment> assignmentOptional = assignmentService.findById(assignmentId);
        if (assignmentOptional.isPresent()) {
            Assignment assignment = assignmentOptional.get();
            AssignmentDTO assignmentDTO = mapService.getAssigmentDTO(assignment);
            model.addAttribute("assignmentDTO", assignmentDTO);
        } else {
            model.addAttribute("assignmentDTO", "Assignment is not available");
        }
        return "comment";
    }
}