package com.peacebird.ams.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.peacebird.ams.entity.Authority;
import com.peacebird.ams.result.AuthorityVO;
import com.peacebird.ams.result.LayResultT;
import com.peacebird.ams.result.ResultT;
import com.peacebird.ams.service.IAuthorityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @autor kevin.dai
 * @Date 2018/2/28
 */

@RestController
@RequestMapping("/authpro/")
public class AuthProController {


    @Autowired
    private  IAuthorityService authorityService;


    @PostMapping("/add")
    public ResultT addAuth(@RequestParam String name, @RequestParam String remark,
                              @RequestParam  Integer status, @RequestParam String url){
        Authority authority = new Authority();
        authority.setName(name);
        authority.setStatus(status);
        authority.setRemark(remark);
        authority.setUrl(url);
        int result = authorityService.addAuthority(authority);
        if(result >0){
            return ResultT.succed();
        }
        return ResultT.failed("新增权限失败！");
    }



    @GetMapping("/list")
    public LayResultT authorityList(@RequestParam  int page, @RequestParam  int limit,
                                @RequestParam(required = false) String authorityName,@RequestParam Integer projectId){
        EntityWrapper<Authority> ew = new EntityWrapper<Authority>();
        ew.setEntity(new Authority());
        ew.where("projectId={0}",projectId);
        if(StringUtils.isNotBlank(authorityName)){
            ew.and().like(" name ",authorityName);
        }

        Page<Authority> prs = authorityService.selectPage(new Page<>(page,limit),ew);
        List<Authority> authorities = prs.getRecords();
        List<AuthorityVO> authorityVOS = AuthorityVO.toVOs(authorities);
        int count =  authorityService.selectCount(ew);
        return new LayResultT(authorityVOS,count);
    }













}
