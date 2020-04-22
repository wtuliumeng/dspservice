package com.dsp.web.service.common;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhouyang on 2020/3/31.
 * Edit by wangsixian   on 2020/4/15
 */
public interface FileService {
    void downloadFile(String path, HttpServletResponse response);
}
