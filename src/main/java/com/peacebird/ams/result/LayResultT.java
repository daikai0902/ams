package com.peacebird.ams.result;

import com.baomidou.mybatisplus.activerecord.Model;

import java.util.List;

/**
 *
 * 前端渲染返回数据结构
 * @autor kevin.dai
 * @Date 2018/1/26
 */
public class LayResultT {

    public Integer code;

    public String msg;

    public Integer count;

    public List<? extends BaseVO> data;



    public LayResultT(){

    }


    public LayResultT(List<? extends BaseVO> data,Integer count){
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = data;
    }












}
