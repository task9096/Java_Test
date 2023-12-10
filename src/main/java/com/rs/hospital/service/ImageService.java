package com.rs.hospital.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public String handleFileUpload(MultipartFile file,String module) throws IOException;
    public byte[] downloadImage(String fileName) throws IOException;
    public byte[] downloadImage1(String module,String fileName) throws IOException;
}
