<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"  pageEncoding="GB2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<META content=map,it2288,pic,pc,com,computer name=Keywords>
<title></title>

<link href="/zaixianbook_shop/css/local.css" rel="stylesheet" type="text/css">
<link href="/zaixianbook_shop/css/text.css" rel="stylesheet" type="text/css">
</head>
<SCRIPT language="JavaScript" type="text/JavaScript">
<!--
var array = new Array();
array[0]=1;array[1]=2;array[2]=3;array[3]=4;array[4]=5;array[5]=6;array[6]=7;array[7]=8;

function expand(id_value){
  var tmp;
  eval("tmp=document.getElementById('id_"+id_value+"').style.display");
  if(tmp==''){
    eval("document.getElementById('id_"+id_value+"').style.display='none'");
  }else{
   for(i=0;i<array.length;i++){
      eval("document.getElementById('id_"+array[i]+"').style.display='none'");
  }
    eval("document.getElementById('id_"+id_value+"').style.display=''");
  }  
 }
 
//-->
</SCRIPT>
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

<%
String name=(String)session.getAttribute("name");
	if(name==null){
		response.sendRedirect("/zaixianbook_shop/admin/login.jsp");
	}
	else{
 %>
<body >
<table width="141" cellpadding="0" cellspacing="0"  background="/zaixianbook_shop/img/houtai.jpg">
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(1)>
      <tr>
        <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">�ʻ�����</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_1 style="display:none">
        <tr>
       <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/zhmanage.jsp" target="mainFrame" class="12txt18">����Ա�ʻ�</a>		</td>
  	  </tr>
	</table>
	</td>
  </tr>
   <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(2)>
       <tr>
    <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">��Ա����</td>
   </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_2 style="display:none">
       <tr>
    <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/member.jsp" target="mainFrame" class="12txt18">��Ա��Ϣ</a></td>
  </tr>
	</table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(3)>
      <tr>
         <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">�������</td>
     </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_3 style="display:none">
    <tr>
    <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/fenlei.jsp" target="mainFrame" class="12txt18">������Ϣ</a></td>
  </tr>
  </table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(4)>
      <tr>
         <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">ͼ�����</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_4 style="display:none">
     <tr>
    
    <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/ptbook.jsp" target="mainFrame">��ͨͼ��</a></td>
  </tr>
   <tr>
    <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/newbook.jsp" target="mainFrame">����ͼ��</a></td>
  </tr>
   
  <tr>
   <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/tejiabook.jsp" target="mainFrame">�ؼ�ͼ��</a></td>
  </tr>
  <tr>
   <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/addbook.jsp" target="mainFrame">����ͼ��</a></td>
  </tr>
	</table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(5)>
      <tr>
         <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">��������</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_5 style="display:none">
     <tr>
        <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/newdingdan.jsp" target="mainFrame">δ��������</a></td>
     </tr>
  <tr>
     <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/findingdan.jsp" target="mainFrame">�Ѵ�������</a></td>
  </tr>
	</table>
	</td>
  </tr>
  
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(6)>
      <tr>
        <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">���Ź���</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_6 style="display:none">
     <tr>
       <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/news.jsp" target="mainFrame">���Ź���</a></td>
     </tr>
  <tr>
    <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/addnews.jsp" target="mainFrame">��������</a></td>
  </tr>
	</table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(7)>
      <tr>
        <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">���۹���</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_7 style="display:none">
     <tr>
         <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/admin/commont.jsp" target="mainFrame">���۹���</a></td>
    </tr>
 </table>
	</td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" align="center"style="cursor:hand" onclick=javascript:expand(8)>
    <tr>
      <td width="" height="31" bgcolor="#99CCCC"  align="center" class="black14">�˳���½</td>
    </tr>
    </table>
      <table width="100%" border="0" align="center" id=id_8 style="display:none">
           <tr>
               <td  width="" height="31" align="center" bgcolor="#FFFFFF" class="12txt18"><a href="/zaixianbook_shop/LoginOut.jsp?method=admin" target="_parent">�˳���½</a></td>
           </tr>
	</table>
	</td>
  </tr>
</table>
</body>
<%} %>
</html>
