/**
 * Created by daikai on 2017/9/18.
 */



layui.use(['element','layer','jquery','form'], function(){
    var element = layui.element;
    var $ = layui.jquery,layer = layui.layer;

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














    })

});

