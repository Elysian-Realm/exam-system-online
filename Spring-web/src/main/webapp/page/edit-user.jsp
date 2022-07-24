<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<form id="edit-form" class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">学工号</label>
        <div class="layui-input-block">
            <input type="text" value=<%=request.getParameter("accountnumber") %> name="accountnumber" lay-verify="required" lay-reqtext="学工号不能为空" placeholder="请输入学工号" class="layui-input">
            <tip>填写自己管理的学工号。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">权限</label>
        <div class="layui-input-block">
            <input type="text" name="type" placeholder="请输入更改为的权限" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button id="edit" class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</form>
</div>
<script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            // var index = layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // }, function () {
            //     // 关闭弹出层
            //     layer.close(index);
            //     var iframeIndex = parent.layer.getFrameIndex(window.name);
            //     parent.layer.close(iframeIndex);
            // });

			$('#edit').click(function(){
            	$.ajax({
            		url:'/Spring-web/UpdateUser',
            		type:'post',
            		dataType:'text',
            		async:true,
            		data:$('#edit-form').serialize(),
            		success:function(data){
            			if(data === 'success'){
            				layer.alert('更改成功');
            			}
            			else{
            				layer.alert('更改失败');
            			}
            		},
            		error:function(data){
            			layer.alert('数据请求失败，请稍后再试');
            		}

            	})

            });

            return false;
        });

    });
</script>
</body>
</html>