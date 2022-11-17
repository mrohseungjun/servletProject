package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;


public class SMemberImpl implements SMemberDAO {
	private static SMemberDAO instance= new SMemberImpl();
	public static SMemberDAO getInstance() {
		return instance;
	}
	//회원가입
	@Override
	public void memberjoin(SMemberDTO member) {
		Connection con=null;
		PreparedStatement ps=null;
	try {
		con=DBConnection.getConnection();
		String sql ="insert into memberdb values(?,?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, member.getName());
		ps.setString(2, member.getUserid());
		ps.setString(3, member.getPwd());
		ps.setString(4, member.getEmail());
		ps.setString(5, member.getPhone());
		ps.setInt(6, member.getAdmin());
		ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		closeConnection(con, ps, ps, null);
	}
		
	}

	@Override
	public ArrayList<SMemberDTO> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberDelete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(SMemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SMemberDTO findById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int membercount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String memeberIdCheek(String userid) {
		return null;
	
	}

	@Override
	public SMemberDTO memberLoginCheek(String userid, String pwd) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		SMemberDTO member = new SMemberDTO();
		//비회원: -1
		member.setAdmin(-1);
		//회원:일반회원(1) 관리자1
		//회원이지만 비번오류 2
		try {
			con=DBConnection.getConnection();
			String sql = "select* from memberdb where userid ='"+ userid +"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {//비번맞음
					member.setAdmin(rs.getInt("admin"));
					member.setEmail(rs.getString("email"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setPwd(rs.getString("pwd"));
					member.setUserid(rs.getString("userid"));
				}else {
					member.setAdmin(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return member;
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
