package com.classluv2code.jobportal.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {

    private Path foundFile;

    public Resource getFileAsResource(String downloadDir, String fileName) throws IOException {

        Path path = Paths.get(downloadDir);
        Files.list(path).forEach(file -> {
            if(file.getFileName().toString().startsWith(fileName)) {
                this.foundFile = file;
            }
        });

        if(this.foundFile != null) {
            return new UrlResource(this.foundFile.toUri());
        }
        return null;
    }
}
