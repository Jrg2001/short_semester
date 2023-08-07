package com.example.controller;

import com.example.service.FileSearchService;
import com.example.service.FileUploadService;
import com.example.uitl.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {
    private final FileUploadService fileUploadService;
    private final FileSearchService fileSearchService;

    public FileUploadController(FileUploadService fileUploadService, FileSearchService fileSearchService) {
        this.fileUploadService = fileUploadService;
        this.fileSearchService = fileSearchService;
    }

    @PostMapping("/upload")
    public R uploadFolder(@RequestParam("folder") MultipartFile[] files,
                          @RequestParam("keyword") String keyword) {
        try {
            fileUploadService.uploadFiles(files);
            String searchResult = fileSearchService.searchAndProcessFiles(keyword);
            return new R(searchResult);
        } catch (IOException e) {
            e.printStackTrace();
            return new R("上传失败");
        }
    }
}
