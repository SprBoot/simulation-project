/**
 * Copyright (C), 2015-2019
 * FileName: FileUtil
 * Author:   A
 * Date:     2019/5/28 10:55
 * Description: 文件工具类
 */
package cn.xuxiaonan.util;

import cn.xuxiaonan.enums.Character;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 〈文件工具类〉
 * @author dinggc
 * @create 2019/5/28
 * @since 1.0.0
 */
public class FileUtil {
    /**
     * @Author dinggc
     * @Description //文件上传
     * @Date 10:56 2019/5/28
     * @Param [file, path, session, request]
     * @return net.sf.json.JSONObject
     **/
    public JSONObject uploadFile(MultipartFile file, String path, HttpServletRequest request) {
        // 生成一个文件名16位数字+字母
        String fileRandomNameId = RandomNumberUtil.getUUID();
        String fileRandomName = RandomNumberUtil.getUUID();
        String realName = file.getOriginalFilename();
        String suffixName = realName.substring(realName.lastIndexOf(Character.DOT.getSymbolName()));
        fileRandomName += suffixName;
        File tempFile = new File(path, fileRandomName);
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        if (tempFile.exists()) {
            tempFile.delete();
        }
        try{
            tempFile.createNewFile();
            file.transferTo(tempFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        //分布式session共享问题
        // 封装文件的信息
        JSONObject fileInfo = new JSONObject();
        fileInfo.put("fileId", fileRandomNameId);
        fileInfo.put("fileRandName", fileRandomName);
        fileInfo.put("fileType", suffixName);
        fileInfo.put("filePath", tempFile.getAbsolutePath());
        return fileInfo;
    }
}
