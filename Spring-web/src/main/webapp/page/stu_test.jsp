<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.onlinetest.domainc.*"%>
<%@ page import="com.onlinetest.Service.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.lang.*"%>

<% List<Subject> subjects = (List<Subject>)request.getAttribute("subjects"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>试题</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layuimini/lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
	<style>
	    span{ font-size:20px;font-family:"Microsoft YaHei","Simsun",Arial; font-weight:normal; line-height:1; padding:0; margin:0;}
	</style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>试卷生成</legend>
        </fieldset>

        <form class="layui-form">
            <span>一、单选题</span>
			<div id="single">
			</div>

            <span>二、多选题</span>
            <div id="multiple">
            </div>

			<span>三、判断题</span>
			<div id="judge">
			</div>

			<div class="layui-form-item">
			    <div class="layui-input-block">
			        <button type="button" class="layui-btn layui-btn-normal" lay-submit lay-filter="choiceBtn">确认提交</button>
			    </div>
			</div>

        </form>
    </div>
</div>

<script src="layuimini/lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var $ = layui.$;

    $(function(){
        var singleNum = 1;
        var multipleNum = 1;
        var judgeleNum = 1;
        console.log("aaa");

    <%
    for(Subject s : subjects){
    %>
        if( <%= "\""+s.getType() +"\"" %>=== '单选题'){
            var stem = '、'+<%= "\""+s.getStem()+"\"" %>;
            var optionA = '选项A';
            var optionB = '选项B';
            var optionC = '选项C';
            var optionD = '选项D';
            var listHtml = `
                <div class="layui-form-item">
                    <div>${singleNum}${stem}</div>
                    <br>
                    <div class="layui-input-block">
                        <input type="radio" name="option" value="A" title="选项A"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>${optionA}</div></div>
                        <input type="radio" name="option" value="B" title="选项B"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>${optionB}</div></div>
                        <input type="radio" name="option" value="C" title="选项C"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>${optionC}</div></div>
                        <input type="radio" name="option" value="D" title="选项D"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>${optionD}</div></div>
                    </div>
                </div>
            `
            document.getElementById('single').innerHTML += listHtml;
            singleNum ++;
        }
        else if( <%= "\""+s.getType() +"\"" %> === '多选题'){
            var stem = '、'+<%= "\""+s.getStem()+"\"" %>;
            var optionA = '选项A';
            var optionB = '选项B';
            var optionC = '选项C';
            var optionD = '选项D';
            var listHtml = `
                <div class="layui-form-item">
                    <div>${multipleNum}${stem}</div>
                    <br>
                    <div class="layui-input-block">
                        <input type="checkbox" name="checkbox-option" lay-skin="primary" value="A" title="选项A"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>${optionA}</span><i class="layui-icon layui-icon-ok"></i></div>
                        <input type="checkbox" name="checkbox-option" lay-skin="primary" value="B" title="选项B"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>${optionB}</span><i class="layui-icon layui-icon-ok"></i></div>
                        <input type="checkbox" name="checkbox-option" lay-skin="primary" value="C" title="选项C"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>${optionC}</span><i class="layui-icon layui-icon-ok"></i></div>
                        <input type="checkbox" name="checkbox-option" lay-skin="primary" value="D" title="选项D"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>${optionD}</span><i class="layui-icon layui-icon-ok"></i></div>
                    </div>
                </div>
            `
            document.getElementById('multiple').innerHTML += listHtml;
            multipleNum ++;
        }
        else if( <%= "\""+s.getType() +"\"" %> === '判断题'){
            var stem = '、'+<%= "\""+s.getStem()+"\"" %>;
            var listHtml = `
                <div class="layui-form-item">
                    <div>${judgeNum}${stem}</div>
                    <br>
                    <div class="layui-input-block">
                        <input type="radio" name="option" value="right" title="对"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>对</div></div>
                        <input type="radio" name="option" value="false" title="错"><div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><div>错</div></div>
                    </div>
                </div>
            `
            document.getElementById('judge').innerHTML += listHtml;
            judgeNum ++;
        }

    <% } %>
    })

</script>

</body>
</html>