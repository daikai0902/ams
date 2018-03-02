/**
 * Created by daikai on 2017/9/18.
 */



layui.use(['element','layer','jquery','form'], function(){
    var element = layui.element;
    var $ = layui.jquery,layer = layui.layer,form = layui.form;

    $(function(){

        var tips = function(ele,msg){
            layer.tips(msg, ele, {
                tips: [3, 'red']
            });
        }


        $(".js-add-pro").on("click",function(){
            layer.open({
                type:1,
                title:'新增项目',
                area:['466px', '355px'],
                content:'<div class="toper-form">' +
                            '<div class="form-group">' +
                                '<label class="lab">项目名称</label>' +
                                '<div class="inb">' +
                                     '<input type="text" class="cont ipt" id="name">'+
                                '</div> ' +
                            '</div>'+
                            '<div class="form-group">' +
                                '<label class="lab">项目描述</label>' +
                                '<div class="inb">' +
                                    '<textarea class="cont tarea" id="describe"></textarea>'+
                                '</div> ' +
                            '</div>'+
                            '<div class="form-group">' +
                                '<label class="lab">状态</label>' +
                                '<div class="inb">' +
                                    '<select class="cont sel" style="height: 30px" id="status">' +
                                        '<option value="1">开启</option>'+
                                        '<option value="0">关闭</option>'+
                                    '</select>'+
                                '</div> ' +
                            '</div>'+
                        '</div>',
                btn:['确定','取消'],
                btnAlign:'c',
                yes:function(index){
                    var name = $("#name").val().trim(),
                        describe = $("#describe").val().trim(),
                        status = $("#status option:selected").val();
                    if(name == ""){
                        tips("#name","项目名称不能为空！");
                        return;
                    }

                    $.post("/project/add",{name:name,describe:describe,status:status},function(json){
                        if(json.status){
                           window.location.reload();
                        }
                    })
                }


            })
        })


        $(".js-add-authority").on("click",function(){
            layer.open({
                type:1,
                title:'新增权限',
                area:['856px', '375px'],
                content:'<div style="margin-top: 10px;margin-right: 30px"><form class="layui-form">' +
                            '<div class="layui-form-item">' +
                                '<label class="layui-form-label">权限名称</label>'+
                                '<div class="layui-input-block">'+
                                    '<input type="text" id="authName"   lay-verify="required"  autocomplete="off" class="layui-input" >'+
                                '</div>'+
                            '</div>'+
                            '<div class="layui-form-item">' +
                                '<label class="layui-form-label">权限路径</label>'+
                                '<div class="layui-input-block">'+
                                    '<input type="text" id="authPath"   lay-verify="required"  autocomplete="off" class="layui-input" >'+
                                '</div>'+
                            '</div>'+

                            '<div class="layui-form-item">'+
                                '<label class="layui-form-label">开关</label>'+
                                '<div class="layui-input-block">'+
                                    '<input type="checkbox" id="authStatus" lay-skin="switch" lay-text="开启|关闭" >'+
                                '</div>'+
                            '</div>'+
                            '<div class="layui-form-item layui-form-text">'+
                                '<label class="layui-form-label">备注</label>'+
                                '<div class="layui-input-block">'+
                                    '<textarea id="authRemark" placeholder="请输入内容" class="layui-textarea"></textarea>'+
                                '</div>'+
                            '</div>' +
                        '</form></div>',


                btn:['确定','取消'],
                btnAlign:'c',
                yes:function(index){


                    $.post("/authpro/add",{name:'1',remark:'2222',status:1,url:"222222",projectId:1},function(json){
                        if(json.status){
                            window.location.reload();
                        }
                    })
                }


            })


        })















    })

});

