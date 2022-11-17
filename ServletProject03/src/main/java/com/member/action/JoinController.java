package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDTO;
import com.member.model.SMemberImpl;
import com.util.SHA256;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/member/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SMemberDAO dao = SMemberImpl.getInstance();
		SMemberDTO dto = new SMemberDTO();
		dto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		dto.setEmail(request.getParameter("email"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
//		dto.setPwd(request.getParameter("pwd"));
		
		dto.setUserid(request.getParameter("userid"));
		String userid = request.getParameter("userid");
		String encPwd = SHA256.getEncrypt(request.getParameter("pwd"), userid);
		dto.setPwd(encPwd);
		
		dao.memberjoin(dto);
		response.sendRedirect("login.jsp");
	}

}
