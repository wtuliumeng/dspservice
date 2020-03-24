package com.dsp.web.service.configCenter.impl;

import com.dsp.web.model.configCenter.BatchAuth;
import com.dsp.web.service.configCenter.ConfigCenterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigCenterServiceImpl implements ConfigCenterService {

    @Override
    public List<BatchAuth> getUserConfigList(String userName, String IPAddr, String status, int currentPage, int pageSize) {
        List<BatchAuth> batchAuthList = new ArrayList<>();

        /* 造假数据 */
        //假设造假数据总共16条
        //分页
        int start = (currentPage - 1) * pageSize + 1;
        for (int i = 0; i < pageSize; i++) {
            if ((start + i) > 16)
                break;
            BatchAuth batchAuth = new BatchAuth();
            batchAuth.setAuthTime("" + (start + i));
            batchAuth.setCreateTime("" + (start + i));
            batchAuth.setExpireTime("" + (start + i));
            batchAuth.setIPAddr("ip" + (start + i));
            batchAuth.setIssuer("" + (start + i));
            batchAuth.setPassword("" + (start + i));
            batchAuth.setSalt("" + (start + i));
            batchAuth.setService("" + (start + i));
            batchAuth.setStatus(""+i%2);
            batchAuth.setTimeout("" + (start + i));
            batchAuth.setToken("" + (start + i));
            batchAuth.setUpdateTime("" + (start + i));
            batchAuth.setUserName("后台测试" + (start + i));
            batchAuthList.add(batchAuth);
        }
        return batchAuthList;
    }

    @Override
    public int getUserConfigCount(String userName, String IPAddr, String status) {
        /*造假数据*/
        return 16;
    }
}
