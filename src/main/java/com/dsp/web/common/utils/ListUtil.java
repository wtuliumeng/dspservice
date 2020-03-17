package com.dsp.web.common.utils;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ListUtil {
    /**
     * 集合是否为空
     * @param list
     * @return
     */
    public static Boolean isEmpty(Collection list){
        if(list!=null&&list.size()>0){
            return false;
        }
        else{
            return true;
        }
    }
}
