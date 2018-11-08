package com.springcloud.common.utils;

import com.springcloud.common.enums.ResultEnum;
import com.springcloud.common.vo.ResultVO;

/**
 * @Author XuWeiZhi
 * @Description
 * @Date 2018/10/9 23:57
 **/
public class ResultVOUtil {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }
}
