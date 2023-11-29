<%@ page language="java" import="java.util.*,bean.*" contentType="text/html;charset=UTF-8"%>

<!-- saved from url=(0034)http://www.huachu.com.cn/index.asp -->
<HTML><HEAD><TITLE>图书销售系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK 
href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>


 
<STYLE type=text/css>.STYLE2 {
	COLOR: #ff0000
}
</STYLE>

<META content="MSHTML 6.00.2900.3059" name=GENERATOR></HEAD>
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
     <img src="/zaixianbook_shop/img/top2.jpg" width="1200">
	 </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD class=k bgColor=#637ee4 height=30>
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
<script language="javascript">
function check()
{
	if(document.form1.shuliang.value=="")
	{
		alert("必须填写所有项目！");
		return false;
	}
}
</script>
  <TBODY>
  <TR>
    <TD align=center vAlign=top width=1200 height=400>
	
	<table bgcolor=#d2d4db align=left width=100 border=0 height=400>
	<tr>
	<td align=center><a href="upuser.jsp">个人信息</a></td>
	</tr>
	<tr>
	<td align=center><a href="gouwuche.jsp">我的购物车</a></td> 
	</tr>
	<tr>
	<td align=center><a href="dingdan.jsp">我的订单</a></td>
	</tr>
	<tr>
	<td align=center><a href="/zaixianbook_shop/LoginOut.jsp?method=center">退出登陆</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	<tr>
	<td><a href="">&nbsp;</a></td>
	</tr>
	</table>


	<form action="/zaixianbook_shop/GouWu.jsp" name="form1" onSubmit="return check()">
	<table border="0" align="center" width="">
	<tr><input type=hidden name=method value=upgw>
	<td align="center" colspan="5">
	</tr>
	<%
	String id=request.getParameter("id").trim();
	String shuming=request.getParameter("shuming").trim();
	shuming=new String(shuming.getBytes("UTF-8"));
	String shuliang=request.getParameter("shuliang").trim();
	String danjia=request.getParameter("danjia").trim();


%>
<tr><input type=hidden name=id value=<%=id %>>
	<td align="center" height="30">书名</td><td align="center" height="30"><%=shuming %></td>
</tr>
<tr>
	<td align="center" height="30">数量</td><td align="center" height="30"><input type=text name=shuliang value=<%=shuliang %>></td>
</tr>
<tr>
	<td align="center" height="30">单价</td><td align="center" height="30"><%=danjia %></td>
	</tr>

<tr>
	<td align="center" colspan="6"><input type="submit" value="提交"></td>
	</tr>
	
	
	</table>
	
	</form>
	
	</TD>
    
  </TR></TBODY></TABLE>

<TABLE height=5 cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
    <TR>
    <TD bgColor=#ffffff>
      <DIV align=center><IMG height=21 
      src=/zaixianbook_shop/img/015.gif></DIV></TD></TR>
  <TR>
    <TD bgColor=#ffffff height=13><IMG height=45 
      src=/zaixianbook_shop/img/016.gif 
      width=1200></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center border=0>
  <TBODY>
  <TR>
    <TD bgColor=#ffffff colSpan=3 height=5></TD></TR>
  <TR bgColor=#637ee4>
    <TD colSpan=3 height=30>
      <DIV align=center></DIV></TD></TR>
  <TR>
    <TD bgColor=#000000 colSpan=3 height=1></TD></TR>
  <TR>
    <TD bgColor=#999999 colSpan=3 height=1></TD></TR>
  <TR>
    <TD width=53 
    background=/zaixianbook_shop/img/index3.gif 
    bgColor=#d2d4db>&nbsp;</TD>
    <TD width=673 bgColor=#d2d4db>
      <TABLE height=4 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD></TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=5 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD vAlign=center align=middle width=80 rowSpan=2>
            <P align=center><FONT color=#cc0000><B>友情</B></FONT></P>
            <P align=center><FONT color=#cc0000><B>链接</B></FONT></P></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.sanhaostreet.com/" 
            target=_blank><IMG height=31 alt=华储网 
            src=/zaixianbook_shop/img/sanhaologo.gif 
            width=88 border=0></A></DIV></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.enet.com.cn/eschool/" 
            target=_blank><IMG height=31 
            src=/zaixianbook_shop/img/88x31.gif 
            width=88 border=0></A></DIV></TD>
          <TD vAlign=center align=middle width=88><A 
            href="http://www.ips.com.cn/" target=_blank><IMG 
            src=/zaixianbook_shop/img/ips-logo.gif 
            border=0></A></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.tomtop.com/" 
            target=_blank><IMG height=31 
            src=/zaixianbook_shop/img/tomtop.gif 
            width=88 border=0></A></DIV></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.bookonline.com.cn/" 
            target=_blank><IMG height=31 
            src=/zaixianbook_shop/img/bookonline_logo.gif 
            width=88 border=0></A></DIV></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.bfidc.com/" target=_blank><IMG 
            height=31 
            src=/zaixianbook_shop/img/bfidc.gif 
            width=88 border=0></A></DIV></TD>
          <TD vAlign=center align=middle width=88>&nbsp;</TD></TR>
        <TR>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://ln.pconline.com.cn/" 
            target=_blank>PConline辽宁站</A></DIV></TD>
          <TD vAlign=center align=middle width=88><A 
            href="http://sy.yesky.com/" target=_blank>天极网沈阳站</A></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.sanhaostreet.com/" 
            target=_blank>网上三好街</A></DIV></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.esoushu.com/" 
            target=_blank>搜书网</A></DIV></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A href="http://www.edusoft.com.cn/" 
            target=_blank>北京育碟苑</A></DIV></TD>
          <TD vAlign=center align=middle width=88 height=20>
            <DIV align=center><A 
            href="http://www.huachu.com.cn/index/link.asp"></A><A 
            href="http://www.edusoft.com.cn/" target=_blank><BR>
            </A></DIV></TD>
          <TD vAlign=center align=middle width=88>
            <DIV align=center></DIV></TD></TR></TBODY></TABLE></TD>
    <TD width=53 
    background=/zaixianbook_shop/img/index4.gif 
    bgColor=#d2d4db>&nbsp;</TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=1200 align=center bgColor=#f0f0f0 
border=0>
  <TBODY>
  <TR>
    <TD width=180>
     </TD>
    <TD bgColor=#f0f0f0>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
        <TD bgColor=#66CCCC height=13  align=center ><a  href="/zaixianbook_shop/admin/login.jsp" target=_blank>管理员登录</a> </TD>
    <TD width=180>
      <DIV align=center>  <BR>
        </DIV></TD></TR></TBODY></TABLE><MAP 
name=Map>
        
      </MAP></BODY>
      
      </HTML>
