<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>


<HTML><HEAD><TITLE>计算机图书网上专营店</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK 
href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3059" name=GENERATOR>
</HEAD>
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
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=0>
<STYLE type=text/css>.style1 {
	COLOR: #ffff00
}
</STYLE>

<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD width=1200 >
     <img src="/zaixianbook_shop/img/top.jpg" width="1200">
	 </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD class=k bgColor=#66cccc height=30>
       <DIV align=center><A 
      href="/zaixianbook_shop/index.jsp"><FONT 
      color=#ffffff>首页</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/moregood.jsp"><FONT 
      color=#ffffff>最新图书</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/fenlei.jsp"><FONT 
      color=#ffffff>图书分类</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/moretuijian.jsp"><FONT 
      color=#ffffff>特价图书</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/news.jsp"><FONT 
      color=#ffffff>图书新闻</FONT></A><FONT color=#ffffff> │ </FONT><A 
      href="/zaixianbook_shop/admin/login.jsp" 
      target=_blank><FONT color=#ffffff>管理入口</FONT></A></DIV></TD></TR></TBODY></TABLE>


<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center bgColor=#ffffff 
border=0>
 <TBODY>
  <TR>
    <TD width=1200 height="329" vAlign=top>
<%
	String id=null;
	id=request.getParameter("id").trim();
	if(id.equals("")){
	id=(String)request.getAttribute("id");
	}
	List list=new OrderBean().getBookInfo(Integer.parseInt(id));
%>	
	<table border="0" align="center" width="70%">
	<tr>
	<td align="center" colspan="2"><br><h2>图书详细信息</h2></td>
	</tr>
	</table>
	
	<table width="65%" height="271" border="1" align="center">
	<tr>
	<td width="35%" height="256" border="0">
	<table width="98%" height="242" border="0" align="center" bordercolor="#66CCCC">
	<tr>
	<td width="26%" align="center" ><%=list.get(1).toString() %></td>
	</tr>
	<tr>
	<td width="26%" height="214" align="center"><img src=<%=list.get(2).toString() %> width=150 height=200></td>
	</tr>
	</table>	
	</td>
	<td width="65%" height="256" border="0">
	<table width="100%" height="257" border="1" align="left">
      <tr>
        <td width="39%" height="40" align="center">作者:</td>
        <td align="center" ><%=list.get(4).toString() %></td>
      </tr>
      <tr>
        <td width="39%" height="34" align="center">出版社:</td>
        <td align="center" ><%=list.get(4).toString() %></td>
      </tr>
      <tr>
        <td width="39%" height="26" align="center">价格:</td>
        <td align="center" ><%=list.get(5).toString() %></td>
      </tr>
      <tr>
        <td width="39%" height="31" align="center">类别:</td>
        <td align="center" ><%=list.get(6).toString() %></td>
      </tr>
      <tr>
        <td width="39%" height="32" align="center">光盘:</td>
        <td align="center" ><%=list.get(7).toString() %></td>
      </tr>
	 
      <tr>
        <td width="39%" height="41" align="center">折率:</td>
        <td align="center" ><%=list.get(8).toString() %></td>
      </tr>
      <tr>
        <td width="39%" height="35" align="center">推荐程度:</td>
        <td align="center" ><%=list.get(9).toString() %></td>
      </tr>
	
 </table>
	  </td> 
	  
	  </tr> 
		
	 
    </table>
	<table border="0" align="center" width="65%">
	 <tr>
                <td width="78%" height="35" align="right" ><a href="/zaixianbook_shop/commont.jsp?id=<%=list.get(0).toString() %>"><strong>查看评论</strong></a></td>
                <td width="22%" align="center" ><a href="/zaixianbook_shop/GouWu.jsp?method=book&id=<%=list.get(0).toString() %>"><strong>放入购物车</strong></a></td>
          </tr>
	</table>
	
    </TABLE>
	
	

<br><br>



<TABLE height=5 cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD bgColor=#66CCCC height=20></TD>
  </TR>
      <TR>
  <TD bgColor=#66CCCC height=13  align=center ><a  href="/zaixianbook_shop/admin/login.jsp" target=_blank>管理员登录</a> </TD>
    
  </TR>
   <TR>
    <TD bgColor=#66CCCC height=20></TD>
  </TR>
  </TBODY></TABLE></BODY></HTML>
