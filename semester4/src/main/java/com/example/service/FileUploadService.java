package com.example.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {
    public static final String UPLOAD_DIRECTORY = "D:\\upload-directory"; // 上传文件保存的目录

    public void uploadFiles(MultipartFile[] files) throws IOException {
        File directory = new File(UPLOAD_DIRECTORY);

        // 创建上传文件保存的目录（如果不存在）
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 遍历上传的文件列表，保存每个文件到指定目录
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                // 使用transferTo方法将文件保存到指定目录
                file.transferTo(new File(directory, fileName));
            }
        }
    }
}
