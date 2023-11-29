<%@ page language="java" import="java.util.*,bean.*,java.text.*" contentType="text/html;charset=UTF-8"%>


<HTML><HEAD><TITLE>图书销售系统 </TITLE>
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
    <TD vAlign=top width=1200><%
  String name=(String)session.getAttribute("name");
  if(name!=null){
  %>
      <table cellspacing=0 cellpadding=3 width="100%" border=0>
        <tbody>
          <tr>
          <tr>
            <td width="85%"><table cellspacing=0 cellpadding=2 width="100%" 
border=0>
                <tbody>
                  <tr>
                    <td width="100%"><table  align=center  cellspacing=0 cellpadding=2 width="100%" border=0>
                        <tbody>
                          <tr>
                            <td width=25% align=center >序号</td>
                            <td  width=25%   align=center >内容</td>
                            <td  width=25%   align=center >发布人</td>
                            <td  width=25%   align=center >发布时间</td>
                          </tr>
                        </tbody>
                      </table>
                        <%
                              String id=request.getParameter("id").trim();
				List listt3=new OrderBean().getCommont(Integer.parseInt(id));
                    NumberFormat   format   =   NumberFormat.getNumberInstance();   
           			 format.setMaximumFractionDigits(2); 
				for(int i=0;i<listt3.size();i++){
					List list2=(List)listt3.get(i);
				
			%>
                        <tr>
                          <td width="100%"><table  align=center  cellspacing=0 cellpadding=2 width="100%" border=0>
                              <tbody>
                                <tr>
                                  <td width=25% align=center ><%=i+1 %></td>
                                  <td  width=25%   align=center ><%=list2.get(0).toString() %></td>
                                  <td  width=25%   align=center ><%=list2.get(1).toString() %></td>
                                  <td  width=25%   align=center ><%=list2.get(2).toString() %></td>
                                </tr>
                              </tbody>
                          </table></td>
                        </tr>
                        <%
				}
			%>
                </tbody>
            </table></td>
          </tr>
        </tbody>
      </table>
      <form action="/zaixianbook_shop/CommonUtil.jsp" method=post>
<table align=center width=40%><input type=hidden name=id value=<%=id %>>
<tr><input type=hidden name=method value=add>
<td align=center><textarea name=content rows=5 cols=40></textarea><br><br><br>
<input type=submit value="发表评论"></td>
</tr>
</table>
</form>
<%}else{} %>
<br><br><br><br><br><br><br><br><br>



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
