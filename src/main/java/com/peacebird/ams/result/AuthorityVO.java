package com.peacebird.ams.result;

import com.peacebird.ams.entity.Authority;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor kevin.dai
 * @Date 2018/2/28
 */
public class AuthorityVO  extends BaseVO{


    public Integer id;

    public String name;

    public String status;

    public String url;

    public String remark;

    public Integer projectId;


    public AuthorityVO(){


    }


    public AuthorityVO(Authority authority){
        this.id = authority.getId();
        this.name = authority.getName();
        this.status = authority.getStatus() == 0?"关闭":"开启";
        this.remark = authority.getRemark();
        this.url  = authority.getUrl();
        this.projectId = authority.getProjectId();
    }



    public static List<AuthorityVO> toVOs(List<Authority> authorities){
        if(authorities ==null ||authorities.size()<1){
            return Collections.emptyList();
        }
        return authorities.stream().map(p -> new AuthorityVO(p)).collect(Collectors.toList());
    }



















}
