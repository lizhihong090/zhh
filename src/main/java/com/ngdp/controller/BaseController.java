package com.ngdp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.alibaba.fastjson.JSONObject;
import com.ngdp.bean.ResultObj;
import com.ngdp.exception.ErrorCode;
import com.ngdp.util.ThreadLocalUtil;

/**
 * controller返回值包装 只会返回200或者500
 *
 * @author 
 */
public abstract class BaseController {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回成功
     *
     * @return
     */
    protected ResultObj successReturn() {
        return successReturn(null);
    }

    /**
     * 返回成功
     *
     * @param data 返回的数据
     * @return
     */
    protected ResultObj successReturn(Object data) {
        return successReturn(data, "");
    }

    /**
     * 返回成功
     *
     * @param data 返回的数据
     * @param msg  返回的信息
     * @return
     */
    protected ResultObj successReturn(Object data, String msg) {
        // 如果对象为空，则默认初始化为Json对象
        if (null == data) {
            data = new JSONObject();
        }

        ResultObj resultObj = new ResultObj(ErrorCode.OK.getCode(), data, msg, "");
        if (!HttpMethod.GET.matches(ThreadLocalUtil.getRequestMethod())) {
            LOG.debug("resultObj:{}", JSONObject.toJSONString(resultObj));
        }
        return resultObj; 
    }

    /**
     * 返回失败
     *
     * @param msg 返回的信息
     * @return
     */
    protected ResultObj errorReturn(ErrorCode code, String msg) {
        return errorReturn(code, msg, "");
    }

    /**
     * 返回失败
     *
     * @param msg      返回的信息
     * @param msgDebug 返回的错误堆栈信息
     * @return
     */
    protected ResultObj errorReturn(ErrorCode code, String msg, Exception msgDebug) {
        return new ResultObj(code.getCode(), new JSONObject(), msg, msgDebug);
    }

    /**
     * 返回失败
     *
     * @param msg      返回的信息
     * @param msgDebug 返回的错误堆栈信息
     * @return
     */
    protected ResultObj errorReturn(ErrorCode code, String msg, String msgDebug) {
        return new ResultObj(code.getCode(), new JSONObject(), msg, msgDebug);
    }

}
