package com.addr.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.model.AddrDTO;
import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;

/**
 * Servlet implementation class addrServlet
 */
@WebServlet("/addr/insert.addr")
public class Insertcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher re = request.getRequestDispatcher("addr_insert.jsp"); //�ּҴ� �ȹٲ�� ���� �Ѱ���
		re.forward(request, response); // ����Ʈ���� �Ѿ �� get��������� 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddrDTO addr = new AddrDTO();
		addr.setAddr(request.getParameter("addr")); //addr_insert���� �����͸� �������
		addr.setName(request.getParameter("name")); // �׸��� addr �����ȿ� �����͸� �־���
		addr.setTel(request.getParameter("tel"));
		addr.setZipcode(request.getParameter("zipcode"));
		
		SAddrDAO dao = SAddrDAOImpl.getInstance(); //dao ������ ����
		dao.addrInsert(addr); // addr�����͸� insert �Լ��� ������Ѽ� �־���
		
		response.sendRedirect("list.addr"); //�����͸� �� �Է��� list.addr(��ü����)�� ��ȯ��
		
	}

}
