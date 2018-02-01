/**
 * Created by daikai on 2017/9/19.
 */
layui.use(['jquery','layer'], function(){
    var $ = layui.jquery,
        layer = layui.layer;

    $(function(){

        var tips = function(ele,msg){
            layer.tips(msg, ele, {
                tips: [3, 'red']
            });
        }


        var isPoneAvailable = function(str) {
            var mobilereg=/^[1][3,4,5,7,8][0-9]{9}$/;
            if (!mobilereg.test(str)) {
                return false;
            } else {
                return true;
            }
        }


        var emailAvailable = function(str){
            var emailreg =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            if (!emailreg.test(str)) {
                return false;
            } else {
                return true;
            }
        }

        //注册
        $("#bb-nav-prev").on("click",function(){
            var index = layer.open({
                title:"注册",
                type: 1,
                closeBtn:1,
                area: ['420px', '400px'], //宽高
                content:"<div>" +
                            "<div class='lay-input'>" +
                                "<input type='text' placeholder='注册用户名' id='r-username'>" +
                            "</div>" +
                            "<div class='lay-input'>" +
                                "<input type='text' placeholder='手机号' id='r-mobile'>" +
                            "</div>" +
                            "<div class='lay-input'>" +
                                "<input type='text' placeholder='邮箱' id='r-email'>" +
                            "</div>" +
                            "<div class='lay-input'>" +
                                "<input type='password' placeholder='6-16位密码,区分大小写' id='r-password'>" +
                            "</div>" +
                            "<div class='btn-cont'>" +
                                " <button class='layui-btn layui-btn-danger' id='r-submit'>注册</button>" +
                            "</div>" +
                        "</div>"
            })

            $("#r-submit").on("click",function(){
                var username = $("#r-username").val().trim(),
                    mobile = $("#r-mobile").val().trim(),
                    email = $("#r-email").val().trim(),
                    password = $("#r-password").val().trim();
                if(username == ""){
                    tips("#r-username","用户名不能为空！");
                    return;
                }
                if(password == ""){
                    tips("#r-password","密码不能为空！");
                    return;
                }
                if(mobile != ""){
                    if(!isPoneAvailable(mobile)){
                        tips("#r-mobile","手机号格式不对！");
                        return;
                    }
                }
                if(email != ""){
                    if(!emailAvailable(email)){
                        tips("#r-email","邮箱格式不对！");
                        return;
                    }
                }

                $.post("/user/register",{username:username,mobile:mobile,email:email,password:password},function(json){
                    if(json.status == "succ"){
                        layer.close(index);
                        layer.msg('注册成功！', {icon: 1});
                    }else {
                        layer.msg(json.msg, {icon: 2});
                        return;
                    }
                })
            })

        })





        //超管
        $("#superlogin").on("click",function(){
            var index = layer.open({
                title:"超级管理员登录",
                type: 1,
                closeBtn:1,
                area: ['420px', '250px'], //宽高
                content:"<div>" +
                            "<div class='lay-input'>" +
                                 "<input type='text' placeholder='用户名' id='r-username'>" +
                            "</div>" +
                            "<div class='lay-input'>" +
                                "<input type='password' placeholder='密码' id='r-password'>" +
                            "</div>" +
                            "<div class='btn-cont'>" +
                                " <button class='layui-btn' id='r-submit'>登录</button>" +
                            "</div>" +
                        "</div>"
            })


            $("#r-submit").on("click",function(){
                var username = $("#r-username").val().trim(),
                    password = $("#r-password").val().trim();
                if(username == ""){
                    tips("#r-username","用户名不能为空！");
                    return;
                }
                if(password == ""){
                    tips("#r-password","密码不能为空！");
                    return;
                }

                $.post("/user/adminLogin",{username:username,password:password},function(json){
                    if(json.status == "succ"){
                        window.location.href = "/";
                    }else {
                        layer.msg(json.msg, {icon: 2});
                        return;
                    }
                })
            })


        })


        //三方
        $("#thirdlogin").on("click",function(){
            layer.msg('暂未开放', {icon: 2});
            return;
        })






       $(".j-login").on("click",function(){
           $(".notice").text("");
           var username = $(".u-input-username").val().trim(),
               password = $(".u-input-password").val().trim();

           $.post("/user/login",{username:username,password:password},function(json){
               if(json.status == "succ"){
                    window.location.href = "/";
               }else {
                   $(".notice").text(json.msg);
                   $(".notice").css("display","block");
               }
           })
       })






    })

});