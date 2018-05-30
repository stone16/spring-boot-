package com.leileichen.sell.utils;

import com.leileichen.sell.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("success");
        resultVO.setCode(0);
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO success() {
        return ResultVOUtil.success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);

        return resultVO;
    }
}
