package com.example.ecole.controller;

import com.example.ecole.entity.Category;
import com.example.ecole.entity.Cours;
import com.example.ecole.entity.Resource;
import com.example.ecole.services.CoursServices;
import com.example.ecole.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin("*") // Adjust to your frontend URL
public class ResourceController {

    private final ResourceService resourceService;
    private final CoursServices coursServices;

    @Autowired
    public ResourceController(ResourceService resourceService, CoursServices coursServices) {
        this.resourceService = resourceService;
        this.coursServices = coursServices;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> addResource(
            @RequestParam("title") String title,
            @RequestParam("type") String type,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "coursId", required = false) Long coursId) {

        try {
            // Save the file and get the file path
            String filePath = resourceService.saveFile(file);

            // Create and save the Resource object
            Resource resource = new Resource();
            resource.setTitle(title);
            resource.setType(Category.valueOf(type));  // Convert string to enum
            resource.setPath(filePath);

            if (coursId != null) {
                Cours cours = coursServices.getCoursById(coursId);
                if (cours != null) {
                    resource.setCours(cours);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Course with ID " + coursId + " not found.");
                }
            }

            Resource savedResource = resourceService.saveResource(resource);
            return ResponseEntity.ok(savedResource);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid category type: " + type);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("File upload failed: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable Long id) {
        try {
            Resource resource = resourceService.getResourceById(id);
            return ResponseEntity.ok(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Resource with ID " + id + " not found.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable Long id) {
        try {
            resourceService.deleteResource(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Resource with ID " + id + " not found.");
        }
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable Long id) {
        try {
            Resource resource = resourceService.getResourceById(id);
            if (resource == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            Path filePath = Paths.get(resource.getPath());
            FileSystemResource fileResource = new FileSystemResource(filePath);

            String filename = filePath.getFileName().toString();
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                    .body(fileResource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/stream/{id}")
    public ResponseEntity<FileSystemResource> streamVideo(@PathVariable Long id) {
        try {
            Resource resource = resourceService.getResourceById(id);
            if (resource == null || !resource.getType().equals(Category.VIDEO)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            Path filePath = Paths.get(resource.getPath());
            FileSystemResource fileResource = new FileSystemResource(filePath);

            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf("video/mp4")) // Adjust as needed for other video formats
                    .header("Content-Disposition", "inline; filename=\"" + filePath.getFileName().toString() + "\"")
                    .body(fileResource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}

