package com.example.ecole.controller;

import com.example.ecole.entity.Role;
import com.example.ecole.services.ClassServices;
import com.example.ecole.services.CoursServices;
import com.example.ecole.services.GradeLevelService;
import com.example.ecole.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin("*")

public class StatisticsController {

    @Autowired
    private UserService userService;  // Your service to handle user-related logic

    @Autowired
    private ClassServices classService;  // Your service to handle class-related logic

    @Autowired
    private GradeLevelService gradeLevelService;
    @Autowired
    private CoursServices courseService;  // Your service to handle course-related logic

    @GetMapping("/counts")
    public ResponseEntity<Map<String, Long>> getCounts() {
        Map<String, Long> counts = new HashMap<>();

        counts.put("students", userService.countByRole(Role.STUDENT));
        counts.put("parents", userService.countByRole(Role.PARENT));
        counts.put("tutors", userService.countByRole(Role.TUTOR));
        counts.put("teachers", userService.countByRole(Role.TEACHER));
        counts.put("administrators", userService.countByRole(Role.ADMINISTRATOR));
        counts.put("gradeLevels", gradeLevelService.countGradeLevels());
        counts.put("classes", classService.countClasses());
        counts.put("courses", courseService.countCourses());

        return ResponseEntity.ok(counts);
    }
}