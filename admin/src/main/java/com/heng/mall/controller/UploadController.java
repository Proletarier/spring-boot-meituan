package com.heng.mall.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.heng.mall.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Value("${spring.servlet.multipart.location}")
    private String fileTempPath;

    @Value("${server.file_url}")
    private String file_url;

    /**
     * 上传图片
     */
    @PostMapping("/uploadImage")
    public CommonResult<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        if (file.isEmpty()) {
            return CommonResult.failed("上传文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        String fileType = StrUtil.subAfter(fileName, ".", true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String localFilePath = StrUtil.appendIfMissing(fileTempPath, "/") + name + "/" + sdf.format(new Date());
        String newFileName = DateUtil.current(false) + "." + fileType;

        File uploadDir = new File(localFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            file.transferTo(new File(localFilePath + "/" + newFileName));
            return CommonResult.success(file_url + "/" + name + "/" + sdf.format(new Date()) + "/" + newFileName);
        } catch (IOException e) {
           log.info("上传失败："+e.getMessage());
            return CommonResult.failed();
        }
    }
}
