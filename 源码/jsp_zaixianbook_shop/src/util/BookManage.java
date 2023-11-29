package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;

public class BookManage extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public BookManage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(this.CHARACTERENCODING);
		response.setContentType(this.CONTENTTYPE);
		HttpSession session=request.getSession();
		//???????????????????????????????? name指得是什么?
		String name=(String)session.getAttribute("name");
		if(name==null){
			 //按给定的路径生成资源转向处理适配器对象
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
		else{
			String method=request.getParameter("method").trim();
			//定义一个书籍信息类得对象
			BookBean lb=new BookBean(); 
			//添加分类信息
			if(method.equals("add")){
				String fenlei=request.getParameter("fenlei").trim();
				int i=lb.addFenLei(fenlei);
				//类别信息添加成功,返回admin/fenlei.jsp页
				if(i==1){
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
				}
				//分类信息重复,跳转到admin/addfenlei.jsp页
				else if(i==3){
					request.setAttribute("message", "对不起，该用户名已经存在！");
					request.getRequestDispatcher("admin/addfenlei.jsp").forward(request, response);
				}
				//操作失败,跳到admin/addfenlei.jsp页
				else if(i==2){
					request.setAttribute("message", "系统维护中，请稍后再试！");
					request.getRequestDispatcher("admin/addfenlei.jsp").forward(request, response);
				}
			}
			//删除分类信息
			else if(method.equals("del")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "请选择操作对象！");
					request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
				
					int i=lb.delFenLei(id);
					//删除成功,返回admin/fenlei.jsp页
					if(i==1){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
					}
					//删除失败,跳到admin/fenlei.jsp页
					else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
					}
				}
			}
			//删除图书信息
			else if(method.equals("delbook")){
				String str[]=request.getParameterValues("choose");
				String jsp=request.getParameter("jsp").trim();
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//如果删除新书,返回admin/newbook.jsp页
					else if(jsp.equals("new")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //如果删除特价图书,返回admin/tejiabook.jsp页
					else if(jsp.equals("te")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}					
					int i=lb.delBook(id);
					//删除图书信息成功
					if(i==1){
						//如果删除普通图书,返回admin/ptbook.jsp页
						if(jsp.equals("pt")){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}
						//如果删除新书,返回admin/newbook.jsp页
						else if(jsp.equals("new")){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}
					    //如果删除特价图书,返回admin/tejiabook.jsp页
						else if(jsp.equals("te")){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
					else{	//删除失败
						//删除普通图书失败,跳到admin/ptbook.jsp页
						if(jsp.equals("pt")){
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}//删除新书失败,跳到admin/newbook.jsp页
						else if(jsp.equals("new")){
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}//删除特价图书失败,跳到admin/tejiabook.jsp页
						else if(jsp.equals("te")){
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
				}
			}//设置新书
			else if(method.equals("xin")){
				String jsp=request.getParameter("jsp").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//如果删除新书,返回admin/newbook.jsp页
					else if(jsp.equals("new")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //如果删除特价图书,返回admin/tejiabook.jsp页
					else if(jsp.equals("te")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}			
					int i=lb.setNew(id);
					//设置新书成功
					if(i==1){
						//把普通图书设为新书
						if(jsp.equals("pt")){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}
						else if(jsp.equals("new")){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}//把特价图书设为新书
						else if(jsp.equals("te")){
							request.setAttribute("message", "操作成功！");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
					else{//设置失败
						if(jsp.equals("pt")){
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}//???????????????????????????????????????新书不能再设为新书
						else if(jsp.equals("new")){
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}
						else if(jsp.equals("te")){
							request.setAttribute("message", "系统维护中，请稍后再试！");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
				}
			}//设置特价图书
			else if(method.equals("tejia")){
				String jsp=request.getParameter("jsp").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//如果删除新书,返回admin/newbook.jsp页
					else if(jsp.equals("new")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //如果删除特价图书,返回admin/tejiabook.jsp页
					else if(jsp.equals("te")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}			
				int i=lb.setTeJia(id);
				if(i==1){//设置成功时
					//把普通图书设为特价
					if(jsp.equals("pt")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}//把新书设为特价
					else if(jsp.equals("new")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}//???????????????????????
					else if(jsp.equals("te")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{	//设置特价图书失败				
					if(jsp.equals("pt")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}}
			}//设置普通图书
			else if(method.equals("pt")){
				String jsp=request.getParameter("jsp").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//如果删除新书,返回admin/newbook.jsp页
					else if(jsp.equals("new")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //如果删除特价图书,返回admin/tejiabook.jsp页
					else if(jsp.equals("te")){
						request.setAttribute("message", "请选择操作对象！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}			
				int i=lb.setPT(id);
				if(i==1){//设置成功时
					//???????????????????
					if(jsp.equals("pt")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}//把新书设为普通图书
					else if(jsp.equals("new")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}//把特价图书设为普通图书
					else if(jsp.equals("te")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{	//设置普通图书失败				
					if(jsp.equals("pt")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}}
			}//???????????????????????????????????????????
			else if(method.equals("up")){
				String jsp=request.getParameter("jsp").trim();
				String id=request.getParameter("choose").trim();
				request.setAttribute("id", id);
				request.setAttribute("jsp", jsp);
				request.getRequestDispatcher("admin/upbook.jsp").forward(request, response);
			}
			else if(method.equals("upbook")){
				String jsp=request.getParameter("jsp").trim();
				String id=request.getParameter("id").trim();
				String name2 = request.getParameter("name").trim();
				String author = request.getParameter("author").trim();
				String chubanshe = request.getParameter("chubanshe").trim();
				String jiage = request.getParameter("jiage").trim();
				String type=request.getParameter("leibie").trim();
				String disc=request.getParameter("disc").trim();
				String dazhe = request.getParameter("dazhe").trim();
				String  tuijian= request.getParameter("tuijian").trim();
				String shuliang= request.getParameter("shuliang").trim();
				int i=lb.upBook(Integer.parseInt(id), name2, author, chubanshe, jiage, type, disc, dazhe, tuijian, shuliang);
				if(i==1){
					if(jsp.equals("pt")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{					
					if(jsp.equals("pt")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
