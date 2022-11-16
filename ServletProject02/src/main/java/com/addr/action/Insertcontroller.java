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
		RequestDispatcher re = request.getRequestDispatcher("addr_insert.jsp"); //주소는 안바뀌고 값만 넘겨줌
		re.forward(request, response); // 리스트에서 넘어갈 때 get방식임으로 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AddrDTO addr = new AddrDTO();
		addr.setAddr(request.getParameter("addr")); //addr_insert에서 데이터를 가지고옴
		addr.setName(request.getParameter("name")); // 그리고 addr 변수안에 데이터를 넣어줌
		addr.setTel(request.getParameter("tel"));
		addr.setZipcode(request.getParameter("zipcode"));
		
		SAddrDAO dao = SAddrDAOImpl.getInstance(); //dao 생성자 생성
		dao.addrInsert(addr); // addr데이터를 insert 함수를 실행시켜서 넣어줌
		
		response.sendRedirect("list.addr"); //데이터를 다 입력후 list.addr(전체보기)로 전환함
		
	}

}
