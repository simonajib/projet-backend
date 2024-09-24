package com.example.ecole.services.Impl;

import com.example.ecole.entity.Resource;
import com.example.ecole.repositories.ResourceRepository;
import com.example.ecole.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);
    }


    @Override
    public Resource getResourceById(Long id) {
        Optional<Resource> resourceOptional = resourceRepository.findById(id);
        return resourceOptional.orElse(null);

    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public void deleteResource(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
        }
    }

    @Override
    public String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Cannot save empty file");
        }

        // Define the directory to save files
        Path uploadDir = Paths.get("src\\main\\resources\\asset");
        // Ensure the directory exists
        if (Files.notExists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // Create a unique filename to prevent conflicts
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) {
            throw new IllegalArgumentException("File name is null");
        }
        Path filePath = uploadDir.resolve(originalFilename);

        // Copy the file to the destination
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();  // Return the path to the saved file
    }

}
