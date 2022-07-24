<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%
String accountnumber = (String)request.getSession().getAttribute("accountnumber");
String password = (String)request.getSession().getAttribute("password");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="../layuimini/css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {width: auto;padding-right: 10px;line-height: 38px;}
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">旧的密码</label>
                <div class="layui-input-block">
                    <input type="password" id="old_password" name="old_password" lay-verify="required" lay-reqtext="旧的密码不能为空" placeholder="请输入旧的密码"  value="" class="layui-input">
                    <tip>填写自己账号的旧的密码。</tip>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label required">新的密码</label>
                <div class="layui-input-block">
                    <input type="password" id="new_password" name="new_password" lay-verify="required" lay-reqtext="新的密码不能为空" placeholder="请输入新的密码"  value="" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">确认新密码</label>
                <div class="layui-input-block">
                    <input type="password" id="again_password" name="again_password" lay-verify="required" lay-reqtext="确认密码不能为空" placeholder="确认新的密码"  value="" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button id="setpwd-button" class="layui-btn layui-btn-normal" lay-submit lay-filter="pwdBtn">确认保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script src="../layuimini/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form','miniTab'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$,
            miniTab = layui.miniTab;

        //监听提交
        form.on('submit(pwdBtn)', function (data) {
            var old = document.getElementById('old_password').value;
			var news = document.getElementById('new_password').value;
			var again = document.getElementById('again_password').value;
			if(old != '<%= password %>'){
			    layer.alert('旧密码不正确');
			    return false;
			}
			if(news != again){
			    layer.alert('两次密码不一致');
			    return false;
			}
			layer.alert('成功');
			$.ajax({
                url:'/Spring-web/UpdatePassword',
                type:'post',
                dataType:'text',
                async:true,
                data:{'new_password':news}
            })
		    return false;
        });

    });
</script>
</body>
</html>