package com.rs.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService{

    private static final String DIR = "C:";
    private static final String UPLOAD_DIR = "/Users/Ranjit/OneDrive/Desktop/project/CRM/crm_ui/image";

    @Override
    public String handleFileUpload(MultipartFile file, String module) throws IOException {
        byte[] bytes = file.getBytes();
        String folderPath= UPLOAD_DIR+"/"+module;
        File folder = new File(DIR+folderPath);

        // Check if the folder already exists
        if (!folder.exists()) {
            // If not, create the folder
            boolean success = folder.mkdirs();
        }
        Path path = Paths.get(DIR+folderPath +"/"+ file.getOriginalFilename());
        Files.write(path, bytes);
        //String imageUrl = DIR+folderPath + "/"+ file.getOriginalFilename();
        return file.getOriginalFilename();
    }

    @Override
    public byte[] downloadImage(String fileName) throws IOException{

        String fullPath = DIR+fileName;
        return Files.readAllBytes(new File(fullPath).toPath());
    }

    @Override
    public byte[] downloadImage1(String module,String fileName) throws IOException{

        String fullPath = DIR+UPLOAD_DIR +"/"+ module +"/"+ fileName;
        return Files.readAllBytes(new File(fullPath).toPath());
    }
}
