package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
	
	//�߰�
	public void boardInsert(BoardDTO board);
	
	//����
	public void boardUpdate(BoardDTO board);

	
	//��ü����
	public ArrayList<BoardDTO> boardList();
	
	public ArrayList<BoardDTO> boardList(int starRow,int endRow, String field, String word);
	
	// ���� 
	public void boardDelete(int num);
	
	//�Խñۼ�
	public int boardCount(String field,String word);
	//�󼼺���
	public BoardDTO findByNum(int num);
	
	//--comment
	//�߰�
	public void commentInser(CommentDTO comment);
	//��ü����
	public ArrayList<CommentDTO>findAllComment(int bnum);
	//��۰���
	public int commentCount(int bnum);
	

}
