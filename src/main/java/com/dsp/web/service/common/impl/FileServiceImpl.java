package com.dsp.web.service.common.impl;

import com.dsp.web.model.vo.SelectModelVo;
import com.dsp.web.service.common.FileService;
import com.dsp.web.service.common.SelectService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public void downloadFile(String path, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            if(path==null){
                throw new Exception("路径为空！");
            }
            //System.out.println("path7: "+path);
            File file = new File(path);
            //如果文件不存在
            if (!file.exists()){
                String msg = "文件不存在!";
                System.out.println(msg);
                PrintWriter out = response.getWriter();
                out.write(msg);
                out.flush();
                out.close();
                return;
            }
            String simpleName = file.getName().substring(file.getName().lastIndexOf(File.separator) + 1);
            //System.out.println("simpleName: "+ simpleName);
            String newFileName = new String(simpleName.getBytes(), "utf-8");
            //System.out.println("newFileName: "+ newFileName);
            String encodeFileName = URLEncoder.encode(newFileName, "UTF-8");
            //System.out.println("encodeFileName: "+ encodeFileName);
            response.addHeader("fileName",encodeFileName);
            response.setHeader("Content-disposition", "attachment;filename=" + encodeFileName);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
            //System.out.println("path7: "+path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
