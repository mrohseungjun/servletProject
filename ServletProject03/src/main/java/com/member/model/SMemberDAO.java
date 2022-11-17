package com.member.model;

import java.util.ArrayList;

public interface SMemberDAO {
	public void memberjoin(SMemberDTO member); //추가
	public ArrayList<SMemberDTO>getMember();//전체보기
	public int memberDelete(String userid);//삭제
	public int memberUpdate(SMemberDTO member);//수정
	public SMemberDTO findById(String userid);//상세보기
	public int membercount();//회원수
	public String memeberIdCheek(String userid);//아이디중복확인
	public SMemberDTO memberLoginCheek(String userid,String pwd);//로그인
}
