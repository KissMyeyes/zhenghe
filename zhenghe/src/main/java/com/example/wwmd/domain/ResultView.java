/**
 * Yztz.com Inc.
 * Copyright (c) 2013-2015 All Rights Reserved.
 */
package com.example.wwmd.domain;

import com.example.wwmd.enums.ErrorCodeEnum;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Administrator
 * @version $Id: Result.java, v 0.1 2015-6-12 下午2:54:33 Administrator Exp $
 */
public class ResultView implements Serializable {

    /**  */
    private static final long serialVersionUID = 2534019658622578421L;

    private boolean success = true;

    private String errorCode;

    private String errorMsg;

    private Object data;

    private PageBean pageBean;

    private Object extraData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setError(ErrorCodeEnum errorCode) {
        if (null != errorCode) {
            setErrorCode(String.valueOf(errorCode.getCode()));
            setErrorMsg(errorCode.getName());
            setSuccess(false);
        }
    }

    public void setError(String msg) {
        setErrorMsg(msg);
        setSuccess(false);
    }

    public static ResultView newSucess(Object data, PageBean pageBean) {
        ResultView result = new ResultView();
        result.setData(data);
        result.setPageBean(pageBean);
        return result;
    }

    public static ResultView newSucess(Object data, Object extraData, PageBean pageBean) {
        ResultView result = new ResultView();
        result.setData(data);
        result.setExtraData(extraData);
        result.setPageBean(pageBean);
        return result;
    }

    public static ResultView newFailed(String errorCode, String errorMsg) {
        ResultView result = new ResultView();

        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        result.setSuccess(false);

        return result;

    }

    public static ResultView newFailed(ErrorCodeEnum errorCode) {
        ResultView result = new ResultView();

        if (null != errorCode) {
            result.setErrorCode(String.valueOf(errorCode.getCode()));
            result.setErrorMsg(errorCode.getName());
            result.setSuccess(false);
        }

        return result;

    }

    public static ResultView newFailed(Map<String, String> model) {
        ResultView result = new ResultView();

        result.setErrorMsg(model.get("resultMsg"));
        result.setSuccess(false);

        return result;

    }

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

}
