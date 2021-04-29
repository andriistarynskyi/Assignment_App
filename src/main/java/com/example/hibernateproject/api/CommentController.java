package com.example.hibernateproject.api;

import com.example.hibernateproject.entity.Assignment;
import com.example.hibernateproject.entity.Comment;
import com.example.hibernateproject.entity.dto.AssignmentDTO;
import com.example.hibernateproject.entity.dto.CommentDTO;
import com.example.hibernateproject.service.IAssignmentService;
import com.example.hibernateproject.service.ICommentService;
import com.example.hibernateproject.service.IMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CommentController {
    private ICommentService commentService;
    private IAssignmentService assignmentService;
    private IMapService mapService;

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
        Assignment assignment = assignmentService.findById(assignmentId).orElseThrow(RuntimeException::new);
        AssignmentDTO assignmentDTO = mapService.getAssigmentDTO(assignment);
        model.addAttribute("assignmentDTO", assignmentDTO);
        List<Comment> comments = commentService.findAllByAssignmentId(assignmentId);
        List<CommentDTO> commentDTOs = comments.stream().
                map(x -> mapService.getCommentDTO(x)).
                collect(Collectors.toList());
        model.addAttribute("commentDTOs", commentDTOs);
        model.addAttribute("commentDTO", new CommentDTO());
        return "comment";
    }

    @PostMapping(value = "assignment/{id}")
    public String addComment(@ModelAttribute CommentDTO commentDTO, @PathVariable("id") String id, Model model) {
        int assignmentId = Integer.parseInt(id);
        Assignment assignment = assignmentService.findById(assignmentId).orElseThrow(RuntimeException::new);
        model.addAttribute("assignmentDTO", mapService.getAssigmentDTO(assignment));
        Comment comment = new Comment(commentDTO.getCommentText(), assignment.getStudent(), assignment);
        commentService.save(comment);
        return "comment";
    }
}