package com.member.model;

import java.util.ArrayList;

public interface SMemberDAO {
	public void memberjoin(SMemberDTO member); //�߰�
	public ArrayList<SMemberDTO>getMember();//��ü����
	public int memberDelete(String userid);//����
	public int memberUpdate(SMemberDTO member);//����
	public SMemberDTO findById(String userid);//�󼼺���
	public int membercount();//ȸ����
	public String memeberIdCheek(String userid);//���̵��ߺ�Ȯ��
	public SMemberDTO memberLoginCheek(String userid,String pwd);//�α���
}
