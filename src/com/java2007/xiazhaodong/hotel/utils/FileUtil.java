package com.java2007.xiazhaodong.hotel.utils;

import com.alibaba.druid.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;

/**
 * 文件上传类
 * @Author AzureSky_X
 * @Date 2021/1/25 17:30
 * @Version 1.0
 */
public class FileUtil {
    public static String upload(HttpServletRequest request){
        //文件上传
        try{

            Part part = request.getPart("image");

            String filename = part.getSubmittedFileName();

            if (StringUtils.isEmpty(filename)){
                filename = request.getParameter("img");
                return filename;
            }else {
                String suffixName = filename.substring(filename.lastIndexOf(".")); //.jpg

                //获取files目录在服务器中的真实路径【某个具体路径下的目录】
                String imagePath = request.getSession().getServletContext().getRealPath("/files/");

                String fileName = UUIDUtil.getFileName(suffixName);   //uuid.jpg
                File file = new File(imagePath, fileName);
                if(!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                part.write(file.getPath());
                fileName = "/files/" + fileName;
                return fileName;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;

    }
}
