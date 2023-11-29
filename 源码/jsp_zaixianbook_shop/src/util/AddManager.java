package util;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserLoginBean;

public class AddManager extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public AddManager() {
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
		//��ȡsession
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		if(name==null){//�������Ա��½��Ϊ��,���ص�½ҳ
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
		else{
			String method=request.getParameter("method").trim();
			//����һ��UserLoginBean�Ķ���
			UserLoginBean lb=new UserLoginBean();
			//�����Ϊ��ִ����ӹ���Ա����
			if(method.equals("add")){
				String admin_name=request.getParameter("admin_name").trim();
				String admin_password=request.getParameter("admin_password").trim();
				int i=lb.addManager(admin_name, admin_password);
				if(i==1){
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
				}
				else if(i==3){
					request.setAttribute("message", "�Բ��𣬸��û����Ѿ����ڣ�");
					request.getRequestDispatcher("admin/adManager.jsp").forward(request, response);
				}
				else if(i==2){
					request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
				    //��������·��������Դת��������������
					request.getRequestDispatcher("admin/adManager.jsp").forward(request, response);
				}
			}//ִ��ɾ����ϵͳ����Ա�Ĳ���
			else if(method.equals("del")){
				String id=request.getParameter("choose").trim();
				if(Integer.parseInt(id)==1){
					request.setAttribute("message", "����ɾ��ϵͳ����Ա��");
					request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
				}
				else{
					int i=lb.delManager(Integer.parseInt(id));
					if(i==1){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
					}
					else{
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
					}
				}
			}//ִ���޸Ĺ���Ա�������
			else if(method.equals("update")){
				String id=request.getParameter("choose").trim();
				request.setAttribute("id", id);
				request.getRequestDispatcher("admin/upManager.jsp").forward(request, response);
			}
			else if(method.equals("up2")){
				String id=request.getParameter("id").trim();
				String new_password=request.getParameter("new_password").trim();
				int i=lb.upManager(Integer.parseInt(id), new_password);
				if(i==1){
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/zhmanage.jsp").forward(request, response);
				}
				else{
					request.setAttribute("id", id);
					request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
					request.getRequestDispatcher("admin/upManager.jsp").forward(request, response);
				}
			}
			
            //ɾ����Ա��Ϣ
			else if(method.equals("delmember")){
				//String id=request.getParameter("choose").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "��ѡ���������");
					request.getRequestDispatcher("admin/member.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
					int i=lb.delUser(id);
					if(i==1){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/member.jsp").forward(request, response);
					}
					else{
						
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/member.jsp").forward(request, response);
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
