package com.shoping.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Perkins
 * @Date 2018/12/20 9:53
 */
public interface IFileService {
    /**
     * 文件上传
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file, String path);
}
