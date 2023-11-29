package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;

public class GouWu extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public GouWu() {
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
		String id=request.getParameter("id").trim();
		OrderBean ob=new OrderBean();
		if(name==null){
			if(method.equals("book")){
				request.setAttribute("message", "请先登陆后在进行购物！");
				request.setAttribute("id", id);
				request.getRequestDispatcher("admin/bookinfo.jsp").forward(request, response);
			}
			else if(method.equals("search")){
				request.setAttribute("message", "请先登陆后在进行购物！");
				request.setAttribute("id", id);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}
		}
		else{			
			if(method.equals("book")){
				int i=ob.addGouWuChe(Integer.parseInt(id), name);
				if(i==1){
						request.setAttribute("message", "操作成功！");
						request.setAttribute("id", id);
						request.getRequestDispatcher("admin/bookinfo.jsp").forward(request, response);
					
				}
				else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.setAttribute("id", id);
						request.getRequestDispatcher("admin/bookinfo.jsp").forward(request, response);
					
				}
			}
			else if(method.equals("search")){
				int i=ob.addGouWuChe(Integer.parseInt(id), name);
				if(i==1){
						request.setAttribute("message", "操作成功！");
						request.setAttribute("id", id);
						request.getRequestDispatcher("search.jsp").forward(request, response);
					
				}
				else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.setAttribute("id", id);
						request.getRequestDispatcher("search.jsp").forward(request, response);
					
				}
			}
			else if(method.equals("delgw")){
				int i=ob.delGouWu(Integer.parseInt(id));
				if(i==1){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
					
				}
				else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
					
				}
			}
			else if(method.equals("sendorder")){
				long number=new java.util.Date().getTime();
				String fukuanfangshi=request.getParameter("fukuanfangshi").trim();
				int i=ob.addOrder(number, name,fukuanfangshi);
				if(i==1){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
					
				}
				else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
					
				}
			}
			else if(method.equals("deldd")){
				int i=ob.delDD(Integer.parseInt(id));
				if(i==1){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("dingdan.jsp").forward(request, response);
					
				}
				else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("dingdan.jsp").forward(request, response);
					
				}
			}
			else if(method.equals("upgouwu")){
				String shuliang=request.getParameter("shuliang").trim();
				int i=ob.upGouWuChe(Integer.parseInt(id), Integer.parseInt(shuliang), name);
				if(i==1){
						request.setAttribute("message", "操作成功！");
						request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
					
				}
				else{
						request.setAttribute("message", "系统维护中，请稍后再试！");
						request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
					
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
