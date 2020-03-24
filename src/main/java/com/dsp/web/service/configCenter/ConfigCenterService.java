package com.dsp.web.service.configCenter;

import com.dsp.web.model.configCenter.BatchAuth;
import java.util.List;

public interface ConfigCenterService {

    List<BatchAuth> getUserConfigList(String userName, String IPAddr, String status, int currentPage, int pageSize);

    int getUserConfigCount(String userName, String IPAddr, String status);
}
