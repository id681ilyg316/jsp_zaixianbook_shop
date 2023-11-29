package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserLoginBean;

public class RegUtil extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public RegUtil() {
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
		UserLoginBean ub=new UserLoginBean();
		if(method.equals("reg")){
			String login=request.getParameter("login").trim();
			String password=request.getParameter("password").trim();
			String name=request.getParameter("name").trim();
			String sex=request.getParameter("sex").trim();
			String email=request.getParameter("email").trim();
			String tel=request.getParameter("tel").trim();
			System.out.println(login);
			System.out.println(password);
			System.out.println(name);
			System.out.println(sex);
			System.out.println(email);
			System.out.println(tel);
			if(login.equals("")||password.equals("")||name.equals("")||email.equals("")||tel.equals("")){
				request.setAttribute("login", login);
				request.setAttribute("password", password);
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("tel", tel);
				request.setAttribute("message", "������д������Ŀ��");
				request.getRequestDispatcher("reg.jsp").forward(request, response);
			}
			else{
				try{
//					int t=Integer.parseInt(tel);
					int i=ub.regUser(login, password, name, sex, email, tel);
					System.out.println(i);
					if(i==1){
						HttpSession session=request.getSession();
						session.setAttribute("name", login);
						request.setAttribute("message", "ע��ɹ���");
						request.getRequestDispatcher("center.jsp").forward(request, response);
					}
					else if(i==3){
						request.setAttribute("login", login);
						request.setAttribute("password", password);
						request.setAttribute("name", name);
						request.setAttribute("email", email);
						request.setAttribute("tel", tel);
						request.setAttribute("message", "���û����Ѿ����ڣ�������ѡ���û�����");
						request.getRequestDispatcher("reg.jsp").forward(request, response);
					}
					else{
						request.setAttribute("login", login);
						request.setAttribute("password", password);
						request.setAttribute("name", name);
						request.setAttribute("email", email);
						request.setAttribute("tel", tel);
						request.setAttribute("message", "��Ϣ�����д��ȷ�����Ժ����ԣ�");
						request.getRequestDispatcher("reg.jsp").forward(request, response);
					}
				}catch(Exception e){
					request.setAttribute("login", login);
					request.setAttribute("password", password);
					request.setAttribute("name", name);
					request.setAttribute("email", email);
					request.setAttribute("tel", tel);
					request.setAttribute("message", "�绰����ֻ��Ϊ���֣�");
					request.getRequestDispatcher("reg.jsp").forward(request, response);
				}		
			}
		}
		else if(method.equals("lost")){
			String login=request.getParameter("login").trim();
			String email=request.getParameter("email").trim();
			int i=ub.getMiMa(login, email);
			if(i==1){
				request.setAttribute("message", "����ɹ��һأ�����������Ϊ123456�����½�󾡿��޸ģ�");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else if(i==3){
				request.setAttribute("message", "��½�����������");
				request.getRequestDispatcher("lost.jsp").forward(request, response);
			}
			else if(i==2){
				request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
				request.getRequestDispatcher("lost.jsp").forward(request, response);
			}
		}
		else if(method.equals("up")){
			String login=request.getParameter("login").trim();
			String password=request.getParameter("password").trim();
			String name=request.getParameter("name").trim();
			String sex=request.getParameter("sex").trim();
			String email=request.getParameter("email").trim();
			String tel=request.getParameter("tel").trim();
			if(login.equals("")||password.equals("")||name.equals("")||email.equals("")||tel.equals("")){
				request.setAttribute("login", login);
				request.setAttribute("password", password);
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				request.setAttribute("tel", tel);
				request.setAttribute("message", "������д������Ŀ��");
				request.getRequestDispatcher("upuser.jsp").forward(request, response);
			}
			else{
				try{
//					int t=Integer.parseInt(tel);
					int i=ub.upUser(login, password, name, sex, email, tel);
					if(i==1){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("upuser.jsp").forward(request, response);
					}
					else{
						request.setAttribute("login", login);
						request.setAttribute("password", password);
						request.setAttribute("name", name);
						request.setAttribute("email", email);
						request.setAttribute("tel", tel);
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("upuser.jsp").forward(request, response);
					}
				}catch(Exception e){
					request.setAttribute("login", login);
					request.setAttribute("password", password);
					request.setAttribute("name", name);
					request.setAttribute("email", email);
					request.setAttribute("tel", tel);
					request.setAttribute("message", "�绰����ֻ��Ϊ���֣�");
					request.getRequestDispatcher("upuser.jsp").forward(request, response);
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
