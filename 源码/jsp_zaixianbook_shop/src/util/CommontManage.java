package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CommontBean;

public class CommontManage extends HttpServlet {

	public final static String CONTENTTYPE="text/html;charset=UTF-8";
	public final static String CHARACTERENCODING="UTF-8";
	/**
	 * Constructor of the object.
	 */
	public CommontManage() {
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
			//����һ��������Ϣ��Ķ���
			CommontBean cb=new CommontBean();
			//ɾ������
			if(method.equals("delcommont")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "��ѡ���������");
					request.getRequestDispatcher("admin/commont.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
					int i=cb.delCommon(id);
					if(i==1){//����ɾ���ɹ�,����admin/commont.jspҳ
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/commont.jsp").forward(request, response);
					}
					else{//����ɾ��ʧ��,����admin/commont.jspҳ
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/commont.jsp").forward(request, response);
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
