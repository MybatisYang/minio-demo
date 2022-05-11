package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Test {
    @Autowired
    MinIoUtil minIoUtil;

    @PostMapping("/upload")
    public String upload(MultipartFile file, @RequestParam(value = "bucketName") String bucketName) {
        if (StringUtils.isEmpty(bucketName)) {
            System.out.println("存储bucket名称为空，无法上传");
            return "存储bucket名称为空，无法上传";
        }
        if (!minIoUtil.upload(file, bucketName)) {
            System.out.println("文件上传异常");
            return "文件上传异常";
        }
        return "文件上传成功";
    }
}
