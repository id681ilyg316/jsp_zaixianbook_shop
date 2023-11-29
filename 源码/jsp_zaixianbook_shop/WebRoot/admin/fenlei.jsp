<%@ page language="java" import="java.util.*,bean.*"  contentType="text/html;charset=UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function ra()
{
	document.form1.hidden3.value="ok";
}
function sub()
{
	
		window.location.href="/zaixianbook_shop/admin/addfenlei.jsp";

}
function sub2()
{	
	
		if(document.form1.hidden3.value!="ok")
		{
			window.alert("请选择要操作的帐号！");
			return false;
		}
		else{//alert("update");
			document.form1.method.value="update";
			form1.submit();
		}

}
function sub4()
{
	
		
		
			document.form1.method.value="del";
			form1.submit();
		

}
//-->
</script>
<link href="/zaixianbook_shop/css/local.css" rel="stylesheet" type="text/css">
<link href="/zaixianbook_shop/css/text.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE19 {border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: none; border-left-style: none; border-top-color: #9f9f9f; border-right-color: #9f9f9f; border-bottom-color: #9f9f9f; border-left-color: #9f9f9f; font-family: "宋体"; font-size: 12px; color: #FF0000; padding-top: 5px; text-align: center; }
#Layer1 {	position:absolute;
	left:61px;
	top:34px;
	width:98px;
	height:189px;
	z-index:1;
}
.STYLE20 {color: #66CC33}
-->
</style>
</head>
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

%>

<%String name=(String)session.getAttribute("name");
	if(name==null){
		response.sendRedirect("/zaixianbook_shop/admin/login.jsp");
	}
	else{
 %>
<body >
<form action="/zaixianbook_shop/BookManage.jsp" name="form1">
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF"><div align="left"><br>
            <span class="black14">　<strong>当前位置:</strong>图书分类管理</span><br>
    </div>
        <table width="98%" cellpadding="0" cellspacing="0">
          
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
              
               <table width="700" cellspacing="0" cellpadding="0" border="1">
                  <tr><input type="hidden" name="hidden3" value="haha">
                    <td height="30"  align="center" bordercolor="#669999" bgcolor="#99CCCC" ><p>序号</p></td>
                    <td height="30"  align="center" bordercolor="#669999" bgcolor="#99CCCC" >分类列表</td>
                    <td height="30"  align="center" bordercolor="#669999" bgcolor="#99CCCC" >建立时间</td>
                    <td height="30"  align="center" bordercolor="#669999" bgcolor="#99CCCC" >选择</td>
                  </tr>
                  <%	
                  BookBean bb=new BookBean(); 
					List list=bb.getFenLei();
					for(int j=0;j<list.size();j++){
						List list2=(List)list.get(j);
				  %>
				  <tr>
				  <td height="30" align="center" bordercolor="#669999" bgcolor="#FFFFFF"><%=j+1 %></td>
				  <td height="30" align="center" bordercolor="#669999" bgcolor="#FFFFFF"><%=list2.get(1).toString() %></td>
				  <td height="30" align="center" bordercolor="#669999" bgcolor="#FFFFFF"><%=list2.get(2).toString() %></td>
				  <td height="30" align="center" bordercolor="#669999" bgcolor="#FFFFFF"><input type="checkbox" name="choose"  value="<%=list2.get(0).toString().trim() %>"></td>
				  </tr>	
				  <%}%>
				  </table>
                
                  <tr>
                    <td height="7" colspan="4" align="right" bordercolor="#5D8191" class="12txt18"><br></td>
                  </tr>
                  <tr>
                    <td align="center" height="8" colspan="4" bordercolor="#5D8191" class="12txt18"><br>
                        <table align="center" width="550" cellpadding="0" cellspacing="0">
                          <tr><input type="hidden" name="method" value="update">
                            <td align="center"><input type="button" name="button" value="增加" onClick="sub()"></td>
                          
                            <td align="center"><input type="button" name="button3" value="删除" onClick="sub4()"></td>
                            
                          </tr>
                      </table>
                      </td>
                  </tr>
                </table>
                <br>
                <br></TD>
          </TR>
      </table></td>
  </tr>
</table>
</form>
</body>
<%} %>
</html>
