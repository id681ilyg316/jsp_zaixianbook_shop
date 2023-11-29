package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.NewsBean;

public class News extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public News() {
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
		String name=(String)session.getAttribute("name");
		if(name==null){
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
		else{
			String method=request.getParameter("method").trim();
			//定义一个新闻信息类的对象
			NewsBean nb=new NewsBean();
			//添加新闻
			if(method.equals("add")){
				String title=request.getParameter("title").trim();
				String content=request.getParameter("content").trim();
				//新闻标题和内容都不能为空
				if(title.equals("")||content.equals("")){
					request.setAttribute("message", "必须填写完全！");
					request.getRequestDispatcher("admin/addnews.jsp").forward(request, response);
				}

				else{//执行添加新闻操作
					int i=nb.addNews(title, content, name);
					//新闻添加成功,返回admin/addnews.jsp页
					if(i==1){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/addnews.jsp").forward(request, response);
					}//新闻添加失败,跳到admin/addnews.jsp页
					else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/addnews.jsp").forward(request, response);
					}
				}
			}//删除新闻操作
			else if(method.equals("del")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "请选择操作对象！");
					request.getRequestDispatcher("admin/news.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
					int i=nb.delNews(id);
					
					if(i==1){//新闻删除成功,返回admin/news.jsp页
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/news.jsp").forward(request, response);
					}
					else{//新闻删除失败,跳到admin/news.jsp页
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/news.jsp").forward(request, response);
					}
				}
			}//修改新闻标题
			else if(method.equals("up")){
				String id=request.getParameter("choose").trim();
				request.setAttribute("id", id);
				request.getRequestDispatcher("admin/upnews.jsp").forward(request, response);
			}//修改新闻内容
			else if(method.equals("up2")){
				String title=request.getParameter("title").trim();
				String content=request.getParameter("content").trim();
				String id=request.getParameter("id").trim();
				//判断新闻的标题和内容是否为空
				if(title.equals("")||content.equals("")){
					request.setAttribute("message", "必须填写完全！");
					request.getRequestDispatcher("admin/upnews.jsp").forward(request, response);
				}
				else{//执行修改新闻内容操作
					int i=nb.upNews(Integer.parseInt(id),title, content);
					if(i==1){//新闻内容修改成功,返回admin/news.jsp页
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("admin/news.jsp").forward(request, response);
					}
					else{//新闻内容修改失败,跳到admin/upnews.jsp页
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/upnews.jsp").forward(request, response);
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
