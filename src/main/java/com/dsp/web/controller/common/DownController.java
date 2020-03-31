package com.dsp.web.controller.common;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.FileInputStream;
import org.springframework.core.io.Resource;



/**
 * Created by zhouyang on 2020/3/31.
 */
@RestController
@RequestMapping(value="/common-api")
public class DownController {


    @RequestMapping(value = "/getdown",method = RequestMethod.POST)
    public void getDown(@RequestBody String strId,
                        HttpServletResponse response){
        try {
            Resource resource = new ClassPathResource("采集服务监控详情.xlsx");
            File file = resource.getFile();
            String filename = resource.getFilename();
            InputStream inputStream = new FileInputStream(file);
            //强制下载不打开
            response.setContentType("application/force-download");
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "UTF-8"));
            int b = 0;
            byte[] buffer = new byte[1000000];
            while (b != -1) {
                b = inputStream.read(buffer);
                if(b!=-1) out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
