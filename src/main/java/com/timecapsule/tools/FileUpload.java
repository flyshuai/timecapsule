package com.timecapsule.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;

public class FileUpload {
    /**
     * @function 多文件上传
     * @return
     */
    public static String fileMany(MultipartFile[] files , String saveUrl, String fileType,int userId){
        List<String> picUrl = new LinkedList<>();
        String newUrl = saveUrl +"/"+userId+ "/"+new Date()+"/";
        File saveDir = new File(newUrl);
        if(!saveDir.exists()){
            saveDir.mkdirs();
        }
        String newFileUrl = "";
        for(MultipartFile file : files){
            if(file != null){
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//                System.out.println(file.getOriginalFilename());
                String fileName = file.getOriginalFilename();
                newFileUrl = newUrl+fileName;
                File saveFile = new File(newFileUrl);
                System.out.println(saveFile);
                try {
                    file.transferTo(saveFile);
//                    picUrl.add(newFileUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("上传失败");
                }
            }
        }
        return newFileUrl;
    }
}
