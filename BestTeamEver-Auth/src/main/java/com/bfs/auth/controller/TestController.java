package com.bfs.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin()
public class TestController {

    @PostMapping("/file")
    public String getFile(HttpServletRequest request
    ,@RequestParam("file") MultipartFile file) {
        System.out.println("getFile reach");
        System.out.println(file.getOriginalFilename()+">>>>>>>>>");
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();//z.png
        int size = (int) file.getSize();
        String path = System.getProperty("user.dir");
        System.out.println(path);
        File dest = new File(path+"/target/classes/static/file" + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "{\"img_path\":\"http://localhost:8080/file/"+fileName+"\"}";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    @PostMapping("/Test")
    public String Test() {
        return "got it";
    }
}
