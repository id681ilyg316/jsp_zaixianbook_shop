package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminLoginBean;
import bean.UserLoginBean;

public class UserLogin extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public UserLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(this.CHARACTERENCODING);
		response.setContentType(this.CONTENTTYPE);
		String method=request.getParameter("method").trim();
		//定义一个普通用户登陆通用类的对象
		UserLoginBean ul=new UserLoginBean();
		//系统管理员登陆
		if(method.equals("admin")){
			String name=request.getParameter("name").trim();
			String password=request.getParameter("pwd").trim();
			//判断系统管理员的登陆名和密码是否为空
			if(name.equals("")||password.equals("")){
				request.setAttribute("message", "请填写登陆名和密码！");
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}
			else{//系统管理员登陆
				AdminLoginBean ab=new AdminLoginBean();
				int i=ab.userLogin(name, password);
				if(i==1){//系统管理员登陆成功,跳到admin/index.jsp页
					HttpSession session=request.getSession();
					//获取系统管理员登陆名的session植
					session.setAttribute("name", name);
					request.setAttribute("message", "");
					request.getRequestDispatcher("admin/index.jsp").forward(request, response);
				}
				else{//系统管理员登陆失败,跳到admin/login.jsp页
					request.setAttribute("message", "用户名或密码错误！");
					request.getRequestDispatcher("admin/login.jsp").forward(request, response);
				}
			}
		}//管理员登陆
		else if(method.equals("user")){
			String name=request.getParameter("username").trim();
			String password=request.getParameter("password").trim();
			int i=ul.userLogin(name, password);
			if(i==1){//登陆成功，跳转到对应的页面
				System.out.println("跳转到2登录");
				HttpSession session=request.getSession();
				session.setAttribute("name", name);				
					//request.setAttribute("message", "欢迎"+name+"登陆！");
					request.getRequestDispatcher("login2.jsp").forward(request, response);
			}
			else{//登陆失败，跳转到对应的页面
				System.out.println("跳转到1登录");
					request.setAttribute("message", "用户名或密码错误！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
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
