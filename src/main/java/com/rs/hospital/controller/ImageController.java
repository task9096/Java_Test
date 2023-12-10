package com.rs.hospital.controller;

import com.rs.hospital.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {


    @Autowired
    private ImageServiceImpl imageServiceImpl;

    @PostMapping("/upload/{moduleName}")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file, @PathVariable("moduleName") String moduleName) {
        try {
            String imageUrl = imageServiceImpl.handleFileUpload(file,moduleName);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);

            return new ResponseEntity<>(imageUrl, headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading the file.");
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
        byte[] image = imageServiceImpl.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @GetMapping("/download/moduleName/{moduleName}/fileName/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable("moduleName") String moduleName,@PathVariable("fileName") String fileName) throws IOException {
        byte[] image = imageServiceImpl.downloadImage1(moduleName,fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}

