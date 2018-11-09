package com.springcloud.order.utils;

import com.springcloud.order.VO.ResultVO;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:57
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
