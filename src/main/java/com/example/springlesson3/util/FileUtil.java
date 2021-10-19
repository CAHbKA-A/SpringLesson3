package com.example.springlesson3.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


//будем сохранять в localhost:8080/img/{id}123.jpg
public class FileUtil {
    public static Path saveImgOfProduct(MultipartFile imgFile){
      //todo check size of file

        try {
            imgFile.transferTo(new File(String.valueOf("img")));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            Path path = imgFile.getResource();
//            File fileA = new File(String.valueOf("SERVER_FOLDER/" + imgFile.getName()));
//            FileOutputStream fos = new FileOutputStream(fileA);
//            fos.write(imgFile.getBytes());//записали
//           fos.close();
//       } catch (IOException | NullPointerException e) {
//            e.printStackTrace();
//        }
return Paths.get("imgFile.get");
    }
}
