package com.springcloud.product.utils;

import com.springcloud.product.vo.ResultVO;

/**
 *@Author XuWeiZhi
 *@Description
 *@Date 2018/10/9 23:41
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
