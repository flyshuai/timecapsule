package com.timecapsule.tools;

import com.timecapsule.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class FileTool {
    public static String uploadFile(MultipartFile file, User user) throws IOException {
        //file.getOriginalFilename()获取上传文件名
        String fileName = file.getOriginalFilename();
        //获取根目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());
        //如果上传目录为/upload/（与static同级），则可以如下获取：
        File upload = new File(path.getAbsolutePath(),"upload/"+user.getUserId()+"/"+System.currentTimeMillis()+"/");
        if(!upload.exists()) upload.mkdirs();
        file.transferTo(new File(upload,"/"+fileName));
        System.out.println("upload url:"+upload.getAbsolutePath());
        return upload+"/"+fileName;
    }
}
