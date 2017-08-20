<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码哥客户关系管理系统</title>
<link rel="stylesheet" href="/static/css/style.css">
<%@include file="common.jsp"%>
<script type="text/javascript">
    $(function(){
        $(".loginBtn").click(function(){
            $("#loginForm").form("submit",{
                url:'/login',
                success:function(data){
                    console.log(data);
                    data = $.parseJSON(data);
                    if(data.success){
                        //跳转到首页
                        window.location.href = "/main";
                    }else{
                        $.messager.alert("温馨提示",data.msg,"error");
                    }
                }
            });
        });
    })
</script>
</head>
<shiro:authenticated>
    <script type="text/javascript">
        window.location.href="/main"
    </script>
</shiro:authenticated>
<body>
  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form id="loginForm" method="post">
        <p><input type="text" name="username" value="" placeholder="账号"></p>
        <p><input type="password" name="password" value="" placeholder="密码"></p>
        <p class="submit">
        	<input type="button" class="loginBtn" value="登录">
        	<input type="button" value="重置">
        </p>
      </form>
    </div>
  </section>
<div style="text-align:center;" class="login-help">
	<p>Copyright ©2015 广州小码哥教育科技有限公司</p>
</div>
</html>