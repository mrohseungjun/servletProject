package com.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/wright")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher re = request.getRequestDispatcher("boardWright.jsp");
		re.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDTO dto = new BoardDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setSubject(request.getParameter("subject"));
		dto.setEmail(request.getParameter("email"));
		dto.setContent(request.getParameter("content"));
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		dao.boardInsert(dto);
		
		response.sendRedirect("boardlist");
	}

}
