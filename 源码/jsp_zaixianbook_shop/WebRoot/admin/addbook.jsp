<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
<!--
.cd {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	text-align: center;
	padding-top: 5px;
}
.cd1 {
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: none;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	padding-top: 5px;
	text-align: center;
}
.cd2 {	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: none;
	border-left-style: solid;
	border-top-color: #9f9f9f;
	border-right-color: #9f9f9f;
	border-bottom-color: #9f9f9f;
	border-left-color: #9f9f9f;
	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	padding-top: 5px;
	text-align: center;
}
body {
	background-image: url(images/bg-0040.gif);
}
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: none;
	color: #000000;
}
a:active {
	text-decoration: none;
	color: #000000;
}
.h14 {
	font-family: "宋体";
	font-size: 14px;
	line-height: 20px;
	color: #999999;
}
-->
</style>

<link href="/zaixianbook_shop/css/local.css" rel="stylesheet" type="text/css">
<link href="/zaixianbook_shop/css/text.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE19 {border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: none; border-left-style: none; border-top-color: #9f9f9f; border-right-color: #9f9f9f; border-bottom-color: #9f9f9f; border-left-color: #9f9f9f; font-family: "宋体"; font-size: 12px; color: #FF0000; padding-top: 5px; text-align: center; }
-->
</style>
</head>

<%
String hidden = request.getParameter("hidden");
	if(hidden == null){
			hidden = "";
	}
	else if (hidden.trim().equals("ok")){
		out.println("<script language='javascript'>");
		out.println("alert('上传成功！');");
		out.println("</script>");
	}
	else if (hidden.trim().equals("no")){
		out.println("<script language='javascript'>");
		out.println("alert('上传失败，目前只能上传jpg、gif格式的图片，并且图片不能大于500K！');");
		out.println("</script>");
	}
	else if (hidden.trim().equals("error")){
		out.println("<script language='javascript'>");
		out.println("alert('上传失败，系统维护中，请稍后再试！');");
		out.println("</script>");
	}
	else if (hidden.trim().equals("kong")){
		out.println("<script language='javascript'>");
		out.println("alert('请选择图片！');");
		out.println("</script>");
	}
%>
<%
String message = (String)request.getAttribute("message");
	if(message == null){
			message = "";
	}
	if (!message.trim().equals("")){
		out.println("<script language='javascript'>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}
	request.removeAttribute("message");

	String name=(String)session.getAttribute("name");
	if(name==null){
		response.sendRedirect("/zaixianbook_shop/admin/login.jsp");
	}
	else{
 %>
<body >
<form action="/zaixianbook_shop/admin/upload.jsp" name="form1" enctype="multipart/form-data" >
	 <input type="hidden" name="method" value="addbook">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF"><div align="left"><br>
            <span class="black14">　<strong>当前位置:</strong>图书管理</span><br>
    </div>
        <table width="98%" cellpadding="0" cellspacing="0">
         
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
                    <table width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="100%" height="20" colspan="2" bgcolor="#009999"><p class="w14">增加图书</p></td>
                        </tr>
                        <tr>
                          <td width="100%" height="100" align="center" bgColor=#ffffff><span class="hb"> <br>
                            </span>
                              <table width="59%" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td align="right"  height="30">书名:</td>
                                  <td width=""><INPUT  type="text" maxLength=20 size=30 name="name" ></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">图片:</td>
                                  <td><INPUT  type=file name="pic"  maxLength=20 size=30 ></td>
                                </tr>
                                <tr>
                                  <td align="right"  height="30">作者:</td>
                                  <td><INPUT  type=text name=author   maxLength=20 size=30></td>
                                </tr>  
                                <tr>
                                  <td align="right"  height="30">出版社:</td>
                                  <td><INPUT  type=text name=chubanshe   maxLength=20 size=30></td>
                                </tr>  
                                <tr>
                                  <td align="right"  height="30">价格:</td>
                                  <td><INPUT  type=text name=jiage   maxLength=20 size=30  ></td>
                                </tr> 
                                <tr>
                                  <td align="right"  height="30">类别:</td>            
                                  <td>
                                  		<select name=leibie>
                                <%
             						List list=new BookBean().getAllType();
             						for(int i=0;i<list.size();i++){
            					 %>  		
                                  		<option value=<%=list.get(i).toString() %>><%=list.get(i).toString() %></option>
                                 <%} %>	
                                  	  </select>
                                  </td>
                                </tr> 
                                <tr>
                                  <td align="right"  height="30">是否带光盘:</td>
                                  <td><select name=disc>
                                  		<option value="是">是</option>
                                  		<option value="否">否</option>
                                  	  </select>
                                  </td>
                                </tr> 
                                <tr>
                                  <td align="right"  height="30">折率:</td>
                                  <td><INPUT  type=text name=dazhe   maxLength=20 size=30 >（1为不打折，0.8为8折）</td>
                                </tr> 
                                <tr>
                                  <td align="right"  height="30">推荐程度:</td>
                                  <td>
                                  	<select name=tuijian>
                                  		<option value="★">  ★  </option>
                                  		<option value="★★"> ★ ★</option>
                                  		<option value="★★★">★★★</option>
                                  	  </select>
                                  </td>
                                </tr> 
                                <tr>
                                  <td align="right"  height="30">数量:</td>
                                  <td><INPUT  type=text name=shuliang   maxLength=20 size=30  onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" 
                              onkeyup="value=value.replace(/[\W]/g,'')"></td>
                                </tr>                      
                            </table></td>
                        </tr>
                        <tr>
                          <td height="30" colspan="2" align="center" bgColor=#ffffff><br>
                              <table width="200" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td><input name="Submit32" type="button" class="black12" value="确认" onClick="check()"></td>
                                  <td><input name="Submit3" type="reset" class="black12" value="重填"></td>
                                </tr>
                              </table>
                            <br></td>
                        </tr>
                      </table>
                        <br>
                    </td>
                  </tr>
                  <tr>
                    <td height="4" align="center" bordercolor="#5D8191" class="12txt18">&nbsp;</td>
                  </tr>
                </table>
                <br>
                <br></TD>
          </TR>
      </table>
</form>
</body>
<%} %>
</html>
