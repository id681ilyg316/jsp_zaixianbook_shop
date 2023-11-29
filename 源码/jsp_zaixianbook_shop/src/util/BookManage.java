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
		//???????????????????????????????? nameָ����ʲô?
		String name=(String)session.getAttribute("name");
		if(name==null){
			 //��������·��������Դת��������������
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}
		else{
			String method=request.getParameter("method").trim();
			//����һ���鼮��Ϣ��ö���
			BookBean lb=new BookBean(); 
			//��ӷ�����Ϣ
			if(method.equals("add")){
				String fenlei=request.getParameter("fenlei").trim();
				int i=lb.addFenLei(fenlei);
				//�����Ϣ��ӳɹ�,����admin/fenlei.jspҳ
				if(i==1){
					request.setAttribute("message", "�����ɹ���");
					request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
				}
				//������Ϣ�ظ�,��ת��admin/addfenlei.jspҳ
				else if(i==3){
					request.setAttribute("message", "�Բ��𣬸��û����Ѿ����ڣ�");
					request.getRequestDispatcher("admin/addfenlei.jsp").forward(request, response);
				}
				//����ʧ��,����admin/addfenlei.jspҳ
				else if(i==2){
					request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
					request.getRequestDispatcher("admin/addfenlei.jsp").forward(request, response);
				}
			}
			//ɾ��������Ϣ
			else if(method.equals("del")){
				String str[]=request.getParameterValues("choose");
				if(str==null){
					request.setAttribute("message", "��ѡ���������");
					request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
				}
				else{
					int id[]=new int[str.length];
					for(int i=0;i<str.length;i++){
						int s=Integer.parseInt(str[i]);				
						id[i]=s;
					}
				
					int i=lb.delFenLei(id);
					//ɾ���ɹ�,����admin/fenlei.jspҳ
					if(i==1){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
					}
					//ɾ��ʧ��,����admin/fenlei.jspҳ
					else{
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/fenlei.jsp").forward(request, response);
					}
				}
			}
			//ɾ��ͼ����Ϣ
			else if(method.equals("delbook")){
				String str[]=request.getParameterValues("choose");
				String jsp=request.getParameter("jsp").trim();
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//���ɾ������,����admin/newbook.jspҳ
					else if(jsp.equals("new")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //���ɾ���ؼ�ͼ��,����admin/tejiabook.jspҳ
					else if(jsp.equals("te")){
						request.setAttribute("message", "��ѡ���������");
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
					//ɾ��ͼ����Ϣ�ɹ�
					if(i==1){
						//���ɾ����ͨͼ��,����admin/ptbook.jspҳ
						if(jsp.equals("pt")){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}
						//���ɾ������,����admin/newbook.jspҳ
						else if(jsp.equals("new")){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}
					    //���ɾ���ؼ�ͼ��,����admin/tejiabook.jspҳ
						else if(jsp.equals("te")){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
					else{	//ɾ��ʧ��
						//ɾ����ͨͼ��ʧ��,����admin/ptbook.jspҳ
						if(jsp.equals("pt")){
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}//ɾ������ʧ��,����admin/newbook.jspҳ
						else if(jsp.equals("new")){
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}//ɾ���ؼ�ͼ��ʧ��,����admin/tejiabook.jspҳ
						else if(jsp.equals("te")){
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
				}
			}//��������
			else if(method.equals("xin")){
				String jsp=request.getParameter("jsp").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//���ɾ������,����admin/newbook.jspҳ
					else if(jsp.equals("new")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //���ɾ���ؼ�ͼ��,����admin/tejiabook.jspҳ
					else if(jsp.equals("te")){
						request.setAttribute("message", "��ѡ���������");
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
					//��������ɹ�
					if(i==1){
						//����ͨͼ����Ϊ����
						if(jsp.equals("pt")){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}
						else if(jsp.equals("new")){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}//���ؼ�ͼ����Ϊ����
						else if(jsp.equals("te")){
							request.setAttribute("message", "�����ɹ���");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
					else{//����ʧ��
						if(jsp.equals("pt")){
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
						}//???????????????????????????????????????���鲻������Ϊ����
						else if(jsp.equals("new")){
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
						}
						else if(jsp.equals("te")){
							request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
							request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
						}
					}
				}
			}//�����ؼ�ͼ��
			else if(method.equals("tejia")){
				String jsp=request.getParameter("jsp").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//���ɾ������,����admin/newbook.jspҳ
					else if(jsp.equals("new")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //���ɾ���ؼ�ͼ��,����admin/tejiabook.jspҳ
					else if(jsp.equals("te")){
						request.setAttribute("message", "��ѡ���������");
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
				if(i==1){//���óɹ�ʱ
					//����ͨͼ����Ϊ�ؼ�
					if(jsp.equals("pt")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}//��������Ϊ�ؼ�
					else if(jsp.equals("new")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}//???????????????????????
					else if(jsp.equals("te")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{	//�����ؼ�ͼ��ʧ��				
					if(jsp.equals("pt")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}}
			}//������ͨͼ��
			else if(method.equals("pt")){
				String jsp=request.getParameter("jsp").trim();
				String str[]=request.getParameterValues("choose");
				if(str==null){					
					if(jsp.equals("pt")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					//���ɾ������,����admin/newbook.jspҳ
					else if(jsp.equals("new")){
						request.setAttribute("message", "��ѡ���������");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
				    //���ɾ���ؼ�ͼ��,����admin/tejiabook.jspҳ
					else if(jsp.equals("te")){
						request.setAttribute("message", "��ѡ���������");
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
				if(i==1){//���óɹ�ʱ
					//???????????????????
					if(jsp.equals("pt")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}//��������Ϊ��ͨͼ��
					else if(jsp.equals("new")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}//���ؼ�ͼ����Ϊ��ͨͼ��
					else if(jsp.equals("te")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{	//������ͨͼ��ʧ��				
					if(jsp.equals("pt")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
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
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "�����ɹ���");
						request.getRequestDispatcher("admin/tejiabook.jsp").forward(request, response);
					}
				}
				else{					
					if(jsp.equals("pt")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/ptbook.jsp").forward(request, response);
					}
					else if(jsp.equals("new")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
						request.getRequestDispatcher("admin/newbook.jsp").forward(request, response);
					}
					else if(jsp.equals("te")){
						request.setAttribute("message", "ϵͳά���У����Ժ����ԣ�");
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
