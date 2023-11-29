package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CommontBean;

public class CommonUtil extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public CommonUtil() {
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
		String method=request.getParameter("method").trim();	
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		CommontBean cb=new CommontBean();
		if(method.equals("add")){
			String content=request.getParameter("content").trim();
			String bookid=request.getParameter("id").trim();
			if(content.equals("")){
				request.setAttribute("message","请填写评论内容！");
				request.getRequestDispatcher("commont.jsp").forward(request, response);
			}else{
				int flag=cb.addCommon(content, name, Integer.parseInt(bookid));
				if(flag==1){
					request.setAttribute("message","操作成功！");
					request.getRequestDispatcher("commont.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message","系统维护中，请稍后再试！");
					request.getRequestDispatcher("commont.jsp").forward(request, response);
				}
			}
			
		}
		else if(method.equals("del")){
			
			if(!name.equals("")){
				String id[]=request.getParameterValues("id");
				if(id==null){
					request.setAttribute("message","请选择要操作的对象！");
					request.getRequestDispatcher("admin/delcommont.jsp").forward(request, response);
				}
				else{
					int id2[]=new int[id.length];
					for(int i=0;i<id.length;i++){
						int s=Integer.parseInt(id[i]);				
						id2[i]=s;
					}
					int flag=cb.delCommon(id2);
					if(flag==1){
						request.setAttribute("message","操作成功！");
						request.getRequestDispatcher("admin/delcommont.jsp").forward(request, response);
					}
					else{
						request.setAttribute("message","系统维护中，请稍后再试！");
						request.getRequestDispatcher("admin/delcommont.jsp").forward(request, response);
					}
				}
			}
			else{
				request.setAttribute("message","请先登陆后再操作！");
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);
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
