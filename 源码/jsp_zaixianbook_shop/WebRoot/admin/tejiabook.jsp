<%@ page language="java" import="java.util.*,bean.*"  contentType="text/html;charset=UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!-- saved from url=(0031)http://www.3haomap.com/inzx.asp -->
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
	background-image: url(/images/bg-0040.gif);
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

function del()
{
		document.form1.method.value="delbook";
			form1.submit();
	

}
function pt()
{
	document.form1.method.value="pt";
		form1.submit();

}
function xin()
{

		document.form1.method.value="xin";
		form1.submit();

}
function up()
{
	if(document.form1.hidden3.value!="ok")
	{
		window.alert("请选择要操作的对象！");
		return false;
	}
	else{//alert("del");
		document.form1.method.value="up";
		form1.submit();
	}
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
<script  language="javascript" >
function top(){
   	form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page=1";
    form3.submit();
}
function last(){
    if(form3.pageCount.value==0){//如果总页数为0，那么最后一页为1，也就是第一页，而不是第0页
    form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page=1";
    form3.submit();
	}else{
	form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page="+form3.pageCount.value;
    	form3.submit();
	}
}
function pre(){
  var page=parseInt(form3.page.value);
  if(page<=1){
    alert("已至第一页");
  }else{
    form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page="+(page-1);
    form3.submit();
  }
}

function next(){
  var page=parseInt(form3.page.value);
  var pageCount=parseInt(form3.pageCount.value);
  if(page>=pageCount){
    alert("已至最后一页");
  }else{
    form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page="+(page+1);
    form3.submit();
  }
}
function bjump(){
  	var pageCount=parseInt(form3.pageCount.value);
  	if( fIsNumber(form3.busjump.value,"1234567890")!=1 ){
		alert("跳转文本框中只能输入数字!");
		form3.busjump.select();
		form3.busjump.focus();
		return false;
	}
	if(form3.busjump.value>pageCount){//如果跳转文本框中输入的页数超过最后一页的数，则跳到最后一页
	  if(pageCount==0){	
	  form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page=1";
	  form3.submit();
	}
	else{
		form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page="+pageCount;
		form3.submit();
	}
}
else if(form3.busjump.value<=pageCount){
var page=parseInt(form3.busjump.value);
   if(page==0){
      page=1;//如果你输入的是0，那么就让它等于1
      form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page="+page;
      form3.submit();
   }else{
      form3.action="/zaixianbook_shop/admin/tejiabook.jsp?page="+page;
      form3.submit();
   }

}

}
//****判断是否是Number.
function fIsNumber (sV,sR){
var sTmp;
if(sV.length==0){ return (false);}
for (var i=0; i < sV.length; i++){
sTmp= sV.substring (i, i+1);
if (sR.indexOf (sTmp, 0)==-1) {return (false);}
}
return (true);
}
</script>
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
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td height="121" align="center" valign="top" bgcolor="#FFFFFF"><div align="left"><br>
            <span class="black14">　<strong>当前位置:</strong>图书管理</span><br>
    </div>
        <table width="100%" cellpadding="0" cellspacing="0">
        
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
              
                <table width="100%" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="30" align="center" bgcolor="#99CCCC" class="cd2"><p>序号</p></td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">书名</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">作者</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">出版社</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">价格</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">分类</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">光盘</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">折率</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">推荐程度</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">库存</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">类型</td>
                    <td align="center" bgcolor="#99CCCC" class="cd1">增加时间</td>  
                    <td align="center" bgcolor="#99CCCC" class="cd1">修改</td>                  
                    <td align="center" bgcolor="#99CCCC" class="cd1">选择</td>
                  </tr>
                  
                  <%   
                  	String sql="select count(*) from bookinformation  where book_type='特价'";
                  	String sql2="select * from bookinformation where book_type='特价' order by book_id desc";
			 		BookPageBean pageutil = new BookPageBean();  
			 		pageutil.setEVERYPAGENUM(15);
			        int cou = pageutil.getMessageCount(sql); System.out.println("cou="+cou);//得到信息总数			        
			        String page1=request.getParameter("page");System.out.println("page="+page);
			        if(page1==null){
			        	page1="1";
			        }
			        session.setAttribute("busMessageCount", cou + "");
			        System.out.println("BusxlAction faf.getPage=" + page1);
			        session.setAttribute("busPage", page1);
			        List list = pageutil.getMessage(Integer.parseInt(page1),sql2); //带进一个页数，并返回该页所要显示的信息
			        session.setAttribute("qqq", list);System.out.println("===== session.setAttribute(qqq, list)=======");
			        int pageCount = pageutil.getPageCount(); //得到页数
			        session.setAttribute("busPageCount", pageCount + ""); 
				    List list3=(ArrayList)session.getAttribute("qqq");
				    System.out.println("list3="+list3);
				    if(!list3.isEmpty()){
				  %>
				  
				<form name=form1 action="/zaixianbook_shop/BookManage.jsp" method=post>
						 <input type="hidden" name="jsp" value="te"><input type="hidden" name="hidden3" value="haha"><input type="hidden" name="method" value="delbook">
				  <%
					    for(int i=0;i<list3.size();i++){
					        List list2 =(ArrayList)list3.get(i);System.out.println("list2="+list2);						       		     
					%>   
        				 <tr>
		                    <td height="30"  align="center" bgcolor="#FFFFFF" class="cd2"><%=i+1 %></td>
		                    <td height="30" align="center" bgcolor="#FFFFFF" class="cd1"><a href="/zaixianbook_shop/admin/bookinfo.jsp?id=<%=list2.get(0).toString() %>" target="_blank"><%=list2.get(1).toString() %></a></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(2).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(3).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(4).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(5).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(6).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(7).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(8).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(9).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(10).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><%=list2.get(11).toString() %></td>
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><a href="/zaixianbook_shop/admin/upbook.jsp?id=<%=list2.get(0).toString()%>&jsp=te">修改</a></td>	                  	
		                  	<td align="center" bgcolor="#FFFFFF"  class="cd1"><input type=checkbox name=choose  value=<%=list2.get(0).toString() %>></td>
		                  </tr>
		                  
		   			 <%}%>
		  </form> 
  		<tr>
    	<td height="2" colspan="14" align="left" bordercolor="#5D8191" bgcolor="#5D8191"></td>
  		</tr>
  		
                <tr>
				<td height="2" colspan="14" align="right" bordercolor="#5D8191" >
				<form action="" name="form3">
				<table>  <tr><td> 
	<input type="hidden" name="pageCount" value="<%= session.getAttribute("busPageCount").toString()%>" /><!--//用于给上面javascript传值-->
    <input type="hidden" name="page" value="<%=session.getAttribute("busPage").toString()%>" /><!--//用于给上面javascript传值-->         
                    <a href="#" onClick="top()"><img src="/zaixianbook_shop/img/first.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
        <a href="#" onClick="pre()"><img src="/zaixianbook_shop/img/pre.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
         共<%=session.getAttribute("busMessageCount").toString()%>条记录,共计<%=session.getAttribute("busPageCount").toString()%>页,当前第<%=session.getAttribute("busPage").toString()%>页&nbsp;&nbsp;&nbsp;
        <a href="#" onClick="next()"><img src="/zaixianbook_shop/img/next.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
        <a href="#" onClick="last()"><img src="/zaixianbook_shop/img/last.gif" border="0" /></a>
     第<input name="busjump" type="text" size="3" />页<a href="#" onClick="bjump()"><img src="/zaixianbook_shop/img/jump.gif" border="0" /></a>&nbsp;&nbsp;&nbsp;
     </td></tr>
      </table>  
       </form>
      </td></tr>
      
       <tr>
                    <td align="center" height="14" colspan="8" bordercolor="#5D8191" class="12txt18"><br>
                        <table align="center" width="550" cellpadding="0" cellspacing="0">
                          <tr>
                            <td align="center">
                            <input type="button" name="button3" value="修改" onClick="up()">&nbsp;&nbsp;&nbsp;
                            <input type="button" name="button3" value="设为普通" onClick="pt()">&nbsp;&nbsp;&nbsp;
                            <input type="button" name="button3" value="设为最新" onClick="xin()">&nbsp;&nbsp;&nbsp;
                            <input type="button" name="button3" value="删除" onClick="del()">&nbsp;&nbsp;&nbsp;                           
                            </td>
                          </tr>
                      </table>
                      </td>
                  </tr>
      <%}else{%>
		   			 <tr>
		                    <td colspan=14 align=center>当前没有信息！</td>
		                  </tr>
		   			 <%} %>
                  
                </table>
                <br>
                <br></TD>
          </TR>
      </table></td>
  </tr>
</table>
</body>
<%} %>
</html>
