package com.example.components;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.File;

@Component
public class UploadDirectoryCleaner {
    @PreDestroy
    public void cleanUp() {
        // 执行清理操作，比如清空文件夹
        cleanUploadDirectory("D:\\upload-directory");
    }

    private void cleanUploadDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            return;
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Path is not a directory: " + directoryPath);
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }

    }

    public static void deleteDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        file.delete();
                    }
                }
            }
            directory.delete();
        }
    }
}