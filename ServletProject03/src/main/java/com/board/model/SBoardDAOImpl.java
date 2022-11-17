package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class SBoardDAOImpl implements SBoardDAO{
	private static SBoardDAO instance = new SBoardDAOImpl();
	public static SBoardDAO getInstance() {
		return instance;
	}

	@Override
	public void boardInsert(BoardDTO board) {
		Connection con=null;
		PreparedStatement ps = null;
		
		try {
			con = DBConnection.getConnection();
			String sql = "insert into simpleboard"
					+" values(simpleboard_seq.nextval,?,?,?,0,?,sysdate)";
			ps= con.prepareStatement(sql);
			ps.setString(1,board.getUserid());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps, ps, null);

		}
			
	}

	@Override
	public void boardUpdate(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}
	//전체보기
	@Override
	public ArrayList<BoardDTO> boardList() {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		
		try {
			con=DBConnection.getConnection();
			st=con.createStatement();
			String sql= "select* from simpleboard";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSubject(rs.getString("subject"));
				dto.setUserid(rs.getString("userid"));
				arr.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<BoardDTO> boardList(int starRow, int endRow, String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardDelete(int num) {
		
	}

	@Override
	public int boardCount(String field, String word) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//상세보기
	@Override
	public BoardDTO findByNum(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		BoardDTO brd = null;
		
		try {
			con=DBConnection.getConnection();
			st= con.createStatement();
			String sql= "select * from simpleboard where num="+num;
			rs=st.executeQuery(sql);
			if(rs.next()) {
				brd= new BoardDTO();
				brd.setNum(rs.getInt("num"));
				brd.setContent(rs.getString("content"));
				brd.setReadcount(rs.getInt("readcount"));
				brd.setRegdate(rs.getNString("regdate"));
				brd.setUserid(rs.getString("userid"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return brd;
	}

	@Override
	public void commentInser(CommentDTO comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CommentDTO> findAllComment(int bnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int commentCount(int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}
	// 닫기
	private void closeConnection(Connection con, PreparedStatement ps,
			Statement st, ResultSet rs) {
			try {
				if(con !=null) 			con.close();
				if(ps !=null) 				ps.close();
				if(st !=null) 				st.close();
				if(rs !=null) 				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
