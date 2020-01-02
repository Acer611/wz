package com.swtl.wz.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件处理工具类
 */
public class FileUtils {



    /**
     * 文件上传
     * @param file
     * @return
     */
    public static String fileUpload(MultipartFile file,String uploadPath){

        try{
            //获取原文件名
            String fileName = file.getOriginalFilename();
            fileName = System.currentTimeMillis()+"_"+fileName;

            File f = new File(uploadPath );
            //如果不存在该路径就创建
            if (!f.exists()) {
                f.mkdir();
            }
            File dir = new File(uploadPath + fileName);
            // 文件写入
            file.transferTo(dir);
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
            return "上传单个文件失败";
        }


    }
}
