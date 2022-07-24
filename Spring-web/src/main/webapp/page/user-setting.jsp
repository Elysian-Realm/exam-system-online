<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String accountnumber = (String)request.getSession().getAttribute("accountnumber");
String name = (String)request.getSession().getAttribute("name");
String _class = (String)request.getSession().getAttribute("_class");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>基本资料</title>
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

        <form id="setting-form" class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">学工号</label>
                <div class="layui-input-block">
                    <input type="text" value=<%=accountnumber%> name="accountnumber" lay-verify="required" lay-reqtext="学工号不能为空" placeholder="请输入您的学工号" class="layui-input">
                    <tip>填写自己管理的学工号。</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">姓名</label>
                <div class="layui-input-block">
                    <input type="text" value=<%=name%> name="name" lay-verify="required" lay-reqtext="熊姓名不能为空" placeholder="请输入您的姓名" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">班级</label>
                <div class="layui-input-block">
                    <input type="text" value=<%=_class%> name="_class" lay-verify="required" placeholder="请输入您的班级" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button id="setBtn" class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
                </div>
            </div>
        </form>
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
        $('#setBtn').click(function(){
            $.ajax({
        		url:'/Spring-web/UpdateInfo',
        		type:'post',
        		dataType:'text',
        		data:$('#setting-form').serialize(),
        		async:false,
        		success:function(data){
        			if(data === 'success'){
        				layer.alert('修改成功');
        			}
        			else {
        				layer.alert('修改失败');
        			}
        		},
        		error:function(data){
        			layer.alert('数据请求失败，请稍后再试');
        		}
        	});
        })


    });
</script>
</body>
</html>