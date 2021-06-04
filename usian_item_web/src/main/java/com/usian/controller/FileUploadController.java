package com.usian.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.usian.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 图片上传
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {


   /* @Autowired
    private FastFileStorageClient storageClient;*/

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif");

    /**
     * 图片上传
     */
    @RequestMapping("/upload")
    public Result fileUpload(MultipartFile file) {

/*
        String fileName =file.getOriginalFilename();
        String exFileName = fileName.substring(fileName.lastIndexOf("."));

        try {
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), exFileName,null);
            return Result.ok("http://www.usian.com/"+storePath.getFullPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.error("失败了");*/

            try {
                String originalFilename = file.getOriginalFilename();// 11.png  11.doc
                // 校验文件的类型
                String contentType = file.getContentType();
                if (!CONTENT_TYPES.contains(contentType)){
                    // 文件类型不合法，直接返回
                    return Result.error("文件类型不合法:"+originalFilename);
                }

                // 校验文件的内容
                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
                if (bufferedImage == null) {
                    return Result.error("文件内容不合法：" + originalFilename);
                }

                // 保存到服务器
                file.transferTo(new File("D:\\images\\" + originalFilename));

                // 生成url地址，返回
                return Result.ok("http://image.usian.com/" + originalFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Result.error("服务器内部错误");
        }
    }
