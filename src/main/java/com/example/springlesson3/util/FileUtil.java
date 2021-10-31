package com.example.springlesson3.util;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

////будем сохранять в localhost:8080/img/{id}123.jpg
public class FileUtil {
    private static final String IMG_FOLDER = "/Data/img/product";

    private FileUtil() {
    }

    public static Path uploadProductImg(MultipartFile fileImg) {
        Path path = null;
        if (!fileImg.isEmpty()) {

            String dir = System.getProperty("user.dir") + IMG_FOLDER;
            path = Paths.get(dir);
            //     System.out.println(path);


            createFolder(path);
            dir = dir + "/" + fileImg.getOriginalFilename();
            path = Paths.get(dir);
            //   System.out.println(path);
            saveAsFile(fileImg, path);


        } else {
            throw new IllegalArgumentException("file is null!!");
        }

        return path;

    }

    private static void createFolder(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException("i cannot create directory!! " + path);
            }
        }
    }

    private static void saveAsFile(MultipartFile file, Path path) {
        try {
            //  System.out.println(path);
            file.transferTo(path);
        } catch (IOException e) {
            throw new RuntimeException("cannot save image file " + path);
        }

    }

}
