<%@ page language="java" import="java.util.*,bean.*,java.text.*" contentType="text/html;charset=UTF-8"%>

<!-- saved from url=(0034)http://www.huachu.com.cn/index.asp -->
<HTML><HEAD><TITLE>图书销售系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK 
href=/zaixianbook_shop/img/ys1.css type=text/css rel=stylesheet>
<SCRIPT language=javascript>
function newpage(strUrl)
<!--
{
	window.open(strUrl , 'MyBook','menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=0,resizable=0,width=300,top=200,left=350,height=380')
}
//-->
function AddToMyCart(strUrl)
<!--
{
	window.open(strUrl , 'MyCart','menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=1,resizable=0,width=690,top=5,left=205,height=320')
}
//-->
</SCRIPT>

<SCRIPT language=vbscript id=clientEventHandlersVBS>
<!--
Dim mySt(4)
mySt(0)=mySt(1)=mySt(2)=mySt(3)=mySt(4)=0

Sub myd1_onmouseover
	myd1.style.color="white"	
	CALL changeimg(0)
End Sub

Sub myd2_onmouseover
	myd2.style.color="white"	
	CALL changeimg(1)
End Sub

Sub myd3_onmouseover
	myd3.style.color="white"	
	CALL changeimg(2)
End Sub

Sub myd4_onmouseover
	myd4.style.color="white"	
	CALL changeimg(3)
End Sub

Sub myd5_onmouseover
	myd5.style.color="white"	
	CALL changeimg(4)
End Sub

//Sub myd6_onmouseover
	//myd6.style.color="white"	
	//CALL changeimg(5)
//End Sub
-->
</SCRIPT>

<SCRIPT language=javascript>
<!--
var cpAD=new Array(); 
var cpADlink=new Array(); 
var adNum=4; 
var coll=0;


//cpAD[5]="../images/itbook/logo/rk2007_logo.jpg;
//cpADlink[5]="../2007/rk2007b.htm";


var preloadedimages=new Array(); 
for (i=1;i<cpAD.length;i++){ 
preloadedimages[i]=new Image(); 
preloadedimages[i].src=cpAD[i]; 
} 

function jump2url()
{ 
jumpUrl=cpADlink[adNum]; 
jumpTarget='_blank'; 
if (jumpUrl != '')
{ 
	if (jumpTarget != '')
		window.open(jumpUrl,jumpTarget); 
	else location.href=jumpUrl; 
	} 
}
function changeimg(n)
{
	adNum=n;
	window.clearInterval(theTimer);
	adNum=adNum-1;
	nextAd();	
}


coll++;

if(adNum<cpAD.length-1)
{
 adNum++ ; 
}
else
{
 adNum=0; 
}



function setTransition(){ 
if (document.all){ 
cpADrush.filters.revealTrans.Transition=23; 
cpADrush.filters.revealTrans.apply(); 
} 

} 
function playTransition(){ 
if (document.all) 
cpADrush.filters.revealTrans.play() 
} 

//结束
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);


function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

//-->
	</SCRIPT>

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
    <TD vAlign=top width=1200>
	
	<table cellspacing=0 cellpadding=3 width="100%" border=0>
                  <tbody>
                <tr>
                      <td width="85%">
                      <table cellspacing=0 cellpadding=0 width="100%" 
border=0>
<%
String type=request.getParameter("type").trim();
                           /*  type=new String(type.getBytes("UTF-8")); */                  
                            
 %>
                          <tbody>
                       <tr>
                       <td colspan=4 align=center><h3><%=type %></h3></td>
                       </tr>     
                              <%
                            
				List listt3=new OrderBean().getTypeTBook(type);
                    NumberFormat   format   =   NumberFormat.getNumberInstance();   
           			 format.setMaximumFractionDigits(2); 
				for(int i=0;i<listt3.size();i++){
					List list2=(List)listt3.get(i);
					
			%>
			<tr>
				<td width="100%">	  
					  <table  align=center  cellspacing=0 cellpadding=2 width="100%" border=0>
                          <tbody>                         
                            <tr>
                              <td width=25% align=center ><a href="/zaixianbook_shop/admin/bookinfo.jsp?id=<%=list2.get(3).toString()%>" target=_blank><font color=#ff6600><%=list2.get(0).toString() %></font></a></td>                          
                              <td  width=25%   align=center >定价：<%=list2.get(2).toString() %>￥</td>                          
                              <td  width=25%   align=center >白金价：<font color=#ff0000><%=format.format(Float.parseFloat(list2.get(2).toString())*0.8) %>￥</font></td>                           
                              <td  width=25%   align=center >黄金价：<font color=#ff0000><%=format.format(Float.parseFloat(list2.get(2).toString())*0.7) %>￥</font></td>
                            </tr>
                          </tbody>
                      </table>
				</td>
			</tr>
			<%
				}
			%>
			
                    
	</tbody>
	</table>
	</TD>
    
  </TR></TBODY></TABLE>

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
