<%@ page language="java" import="java.util.*,bean.*"  contentType="text/html;charset=UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



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

function del()
{
		
			document.form1.method.value="delmember";
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
<script  language="javascript" >
function top(){
   	form3.action="/zaixianbook_shop/admin/member.jsp?page=1";
    form3.submit();
}
function last(){
    if(form3.pageCount.value==0){//如果总页数为0，那么最后一页为1，也就是第一页，而不是第0页
    form3.action="/zaixianbook_shop/admin/member.jsp?page=1";
    form3.submit();
	}else{
	form3.action="/zaixianbook_shop/admin/member.jsp?page="+form3.pageCount.value;
    	form3.submit();
	}
}
function pre(){
  var page=parseInt(form3.page.value);
  if(page<=1){
    alert("已至第一页");
  }else{
    form3.action="/zaixianbook_shop/admin/member.jsp?page="+(page-1);
    form3.submit();
  }
}

function next(){
  var page=parseInt(form3.page.value);
  var pageCount=parseInt(form3.pageCount.value);
  if(page>=pageCount){
    alert("已至最后一页");
  }else{
    form3.action="/zaixianbook_shop/admin/member.jsp?page="+(page+1);
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
	  form3.action="/zaixianbook_shop/admin/member.jsp?page=1";
	  form3.submit();
	}
	else{
		form3.action="/zaixianbook_shop/admin/member.jsp?page="+pageCount;
		form3.submit();
	}
}
else if(form3.busjump.value<=pageCount){
var page=parseInt(form3.busjump.value);
   if(page==0){
      page=1;//如果你输入的是0，那么就让它等于1
      form3.action="/zaixianbook_shop/admin/member.jsp?page="+page;
      form3.submit();
   }else{
      form3.action="/zaixianbook_shop/admin/member.jsp?page="+page;
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
            <span class="black14">　<strong>当前位置:</strong>会员管理</span><br>
    </div>
        <table width="98%" cellpadding="0" cellspacing="0">
          
          <TR bgcolor="#cccccc">
            <TD align="center" bgColor=#ffffff><br>
              <br>
              
                  <table width="731" cellspacing="0" cellpadding="0" border="1"  >
                  <tr>
                    <td width="65" height="30"  align="center" bordercolor="#669999" bgcolor="#99CCCC"  >序号</td>
                    <td width="97" height="30" align="center" bordercolor="#669999" bgcolor="#99CCCC" >登陆名</td>
                    <td width="128" height="30" align="center"  bordercolor="#669999" bgcolor="#99CCCC" >真实姓名</td>
                    <td width="65" height="30" align="center"  bordercolor="#669999" bgcolor="#99CCCC" >性别</td>
                    <td width="65" height="30" align="center"  bordercolor="#669999" bgcolor="#99CCCC" >邮箱</td>
                    <td width="65" height="30" align="center"  bordercolor="#669999" bgcolor="#99CCCC" >电话</td>
                    <td width="128" height="30" align="center"  bordercolor="#669999" bgcolor="#99CCCC" >当前积分</td>
                    <td width="82" height="30" align="center"  bordercolor="#669999" bgcolor="#99CCCC" >选择</td>
                  </tr>
                  
                  <%   
                  	String sql="select count(*) from commonmember ";
                  	String sql2="select member_id,member_loginname,member_truename,member_sex,member_email,member_tel,member_level from commonmember order by member_id desc";
			 		MemberPageBean pageutil = new MemberPageBean(); 
			 		pageutil.setEVERYPAGENUM(15);
			        int cou = pageutil.getMessageCount(sql); System.out.println("cou="+cou);	        
			        String page1=request.getParameter("page");System.out.println("page="+page);
			        if(page1==null){
			        	page1="1";
			        }
			        session.setAttribute("busMessageCount", cou + "");
			        System.out.println("BusxlAction faf.getPage=" + page1);
			        session.setAttribute("busPage", page1);
			        List list = pageutil.getMessage(Integer.parseInt(page1),sql2); 
			        session.setAttribute("qqq", list);
			        int pageCount = pageutil.getPageCount(); 
			        session.setAttribute("busPageCount", pageCount + ""); 
				    List list3=(ArrayList)session.getAttribute("qqq");
				    if(!list3.isEmpty()){
				  %>
				  
				<form name=form1 action="/zaixianbook_shop/AddManager.jsp" method=post>
						 <input type="hidden" name="hidden3" value="haha"><input type="hidden" name="method" value="aa">
				  <%
					    for(int i=0;i<list3.size();i++){
					        List list2 =(ArrayList)list3.get(i);						       		     
					%>   
        				 <tr>
		                    <td height="30"  align="center" bgcolor="#FFFFFF"  bordercolor="#669999"><%=i+1 %></td>
		                    <td height="30" align="center" bgcolor="#FFFFFF"  bordercolor="#669999"><%=list2.get(1).toString() %></td>
		                  	<td height="30" align="center" bgcolor="#FFFFFF"  bordercolor="#669999"><%=list2.get(2).toString() %></td>
		                  	<td height="30" align="center" bgcolor="#FFFFFF"  bordercolor="#669999"><%=list2.get(3).toString() %></td>
		                  	<td height="30" align="center" bgcolor="#FFFFFF" bordercolor="#669999"><%=list2.get(4).toString() %></td>
		                  	<td height="30" align="center" bgcolor="#FFFFFF"  bordercolor="#669999"><%=list2.get(5).toString() %></td>
		                  	<td height="30" align="center" bgcolor="#FFFFFF"  bordercolor="#669999" ><%=list2.get(6).toString() %></td>
		                  	<td height="30" align="center" bgcolor="#FFFFFF" bordercolor="#669999" ><input type=checkbox name=choose   value=<%=list2.get(0).toString() %>></td>
                  </tr>
		                  
		   			 <%}%>
					 
		  </form>
		  </table>
  		
            <tr>
				<td height="2" colspan="8" align="center" bordercolor="#5D8191" >
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
                    <td align="center" height="8" colspan="8" bordercolor="#5D8191" class="12txt18"><br>
                        <table align="center" width="550" cellpadding="0" cellspacing="0">
                          <tr>
                            <td></td>
                            <td align="center"></td>
                            <td></td>
                            <td align="center"><input type="button" name="button3" value="删除" onClick="del()"></td>
                            <td></td>
                          </tr>
                      </table>
                      </td>
                  </tr>
      <%}else{%>
		   			 <tr>
		                    <td colspan=8 align=center>当前没有信息！</td>
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
