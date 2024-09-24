package com.example.ecole.services;

import com.example.ecole.entity.Category;
import com.example.ecole.entity.Resource;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface ResourceService {
    Resource saveResource(Resource resource);

    Resource getResourceById(Long id);

    List<Resource> getAllResources();

    void deleteResource(Long id);

    // Additional method to handle file uploads
    String saveFile(MultipartFile file) throws IOException;


}