package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;

public class Order extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public Order() {
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
			//����һ��������Ķ���
			OrderBean ob=new OrderBean();
			//ɾ������
			if(method.equals("del")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "��ѡ���������");
					request.getRequestDispatcher("admin/newdingdan.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
				int i=ob.delOrder(id);
				//����ɾ���ɹ�,����admin/newdingdan.jspҳ
				if(i==1){
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/newdingdan.jsp").forward(request, response);
				}//����ɾ��ʧ��,����admin/newdingdan.jspҳ
				else{
					request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
					request.getRequestDispatcher("admin/newdingdan.jsp").forward(request, response);
				}
				}
			}//��������
			else if(method.equals("fa")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "��ѡ���������");
					request.getRequestDispatcher("admin/newdingdan.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
					int i=ob.faOrder(id);
					if(i==1){//���������ɹ�,����admin/newdingdan.jspҳ
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/newdingdan.jsp").forward(request, response);
					}
					else{//��������ʧ��,����admin/newdingdan.jspҳ
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/newdingdan.jsp").forward(request, response);
					}
				}
			}//ɾ���Է����Ķ���
			if(method.equals("del2")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "��ѡ���������");
					request.getRequestDispatcher("admin/findingdan.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
				int i=ob.delOrder(id);
				if(i==1){
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/findingdan.jsp").forward(request, response);
				}
				else{
					request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
					request.getRequestDispatcher("admin/findingdan.jsp").forward(request, response);
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
