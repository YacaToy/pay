package com.chutang.pay.pay;

import java.util.Map;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/2
 * @time: 22:57
 */
public interface PayUnifiedorder {

    /**
     * 下单完成
     */
    public void unifiedorderReturn(Map<String, String> returnMap) ;

}
