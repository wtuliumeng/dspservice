package com.dsp.web.controller.common;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



/**
 * Created by zhouyang on 2020/3/31.
 */
@RestController
@RequestMapping(value="/common-api")
public class DownController {


//    @RequestMapping(value = "/getdown",method = RequestMethod.POST)
//    public void getDown(@RequestBody String strId,
//                        HttpServletResponse response){
//        try {
//            Resource resource = new ClassPathResource("/resources/wsxtest.txt");
//            File file = resource.getFile();
//            String filename = resource.getFilename();
//            InputStream inputStream = new FileInputStream(file);
//            //强制下载不打开
//            response.setContentType("application/force-download");
//            OutputStream out = response.getOutputStream();
//            //使用URLEncoder来防止文件名乱码或者读取错误
//            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "UTF-8"));
//            int b = 0;
//            byte[] buffer = new byte[1000000];
//            while (b != -1) {
//                b = inputStream.read(buffer);
//                if(b!=-1) out.write(buffer, 0, b);
//            }
//            inputStream.close();
//            out.close();
//            out.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @RequestMapping(value = "/getdown",method = RequestMethod.POST)
    public void getDown(String[] ids, HttpServletResponse response){
        try {
            response.setCharacterEncoding("UTF-8");
            String fileName = "wsxtest.txt";
            ClassLoader classLoader = getClass().getClassLoader();
            String path = classLoader.getResource(fileName).getPath();

            File file = new File(path);
            //如果文件不存在
            if (file == null || !file.exists()){
                String msg = "文件不存在!";
                System.out.println(msg);
                PrintWriter out = response.getWriter();
                out.write(msg);
                out.flush();
                out.close();
                return;
            }
            String simpleName = file.getName().substring(file.getName().lastIndexOf(File.separator) + 1);
            String newFileName = new String(simpleName.getBytes(), "utf-8");
            response.addHeader("fileName",newFileName);
            response.setHeader("Content-disposition", "attachment;filename=" + newFileName);
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

            URL url = classLoader.getResource(fileName);
            System.out.println("path7: "+path);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
