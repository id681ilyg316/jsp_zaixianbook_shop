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
		//����һ����ͨ�û���½ͨ����Ķ���
		UserLoginBean ul=new UserLoginBean();
		//ϵͳ����Ա��½
		if(method.equals("admin")){
			String name=request.getParameter("name").trim();
			String password=request.getParameter("pwd").trim();
			//�ж�ϵͳ����Ա�ĵ�½���������Ƿ�Ϊ��
			if(name.equals("")||password.equals("")){
				request.setAttribute("message", "����д��½�������룡");
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}
			else{//ϵͳ����Ա��½
				AdminLoginBean ab=new AdminLoginBean();
				int i=ab.userLogin(name, password);
				if(i==1){//ϵͳ����Ա��½�ɹ�,����admin/index.jspҳ
					HttpSession session=request.getSession();
					//��ȡϵͳ����Ա��½����sessionֲ
					session.setAttribute("name", name);
					request.setAttribute("message", "");
					request.getRequestDispatcher("admin/index.jsp").forward(request, response);
				}
				else{//ϵͳ����Ա��½ʧ��,����admin/login.jspҳ
					request.setAttribute("message", "�û������������");
					request.getRequestDispatcher("admin/login.jsp").forward(request, response);
				}
			}
		}//����Ա��½
		else if(method.equals("user")){
			String name=request.getParameter("username").trim();
			String password=request.getParameter("password").trim();
			int i=ul.userLogin(name, password);
			if(i==1){//��½�ɹ�����ת����Ӧ��ҳ��
				System.out.println("��ת��2��¼");
				HttpSession session=request.getSession();
				session.setAttribute("name", name);				
					//request.setAttribute("message", "��ӭ"+name+"��½��");
					request.getRequestDispatcher("login2.jsp").forward(request, response);
			}
			else{//��½ʧ�ܣ���ת����Ӧ��ҳ��
				System.out.println("��ת��1��¼");
					request.setAttribute("message", "�û������������");
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
