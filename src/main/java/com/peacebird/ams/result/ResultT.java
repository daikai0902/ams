package com.peacebird.ams.result;

/**
 * @autor kevin.dai
 * @Date 2018/1/24
 */
public class ResultT {

    public Integer code;


    public String status;//"succ":表示成功，"fail":表示失败

    public String msg;

    public BaseVO data;



    public static ResultT succed(){
        ResultT resultT  = new ResultT();
        resultT.status = "succ";
        resultT.code = (Integer)StatusCode.succed[0];
        resultT.msg = (String) StatusCode.succed[1];
        return  resultT;
    }


    public static ResultT succed(String msg){
        ResultT resultT  = new ResultT();
        resultT.status = "succ";
        resultT.code = (Integer)StatusCode.succed[0];
        resultT.msg =msg;
        return  resultT;
    }


    public static ResultT succed(BaseVO vo,String msg){
        ResultT resultT  = new ResultT();
        resultT.status = "succ";
        resultT.code = (Integer)StatusCode.succed[0];
        resultT.msg =msg;
        resultT.data = vo;
        return  resultT;
    }


    public static ResultT failed(String msg){
        ResultT resultT  = new ResultT();
        resultT.status = "fail";
        resultT.msg = msg;
        return  resultT;
    }


    public static ResultT failed(Object[] codemsg){
        ResultT resultT  = new ResultT();
        resultT.status = "fail";
        resultT.code = (Integer)codemsg[0];
        resultT.msg = (String)codemsg[1];
        return  resultT;
    }


    public static ResultT failed(Object[] codemsg,BaseVO vo){
        ResultT resultT  = new ResultT();
        resultT.status = "fail";
        resultT.code = (Integer)codemsg[0];
        resultT.msg = (String)codemsg[1];
        resultT.data = vo;
        return  resultT;
    }





}
