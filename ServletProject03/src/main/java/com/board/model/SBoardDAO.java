package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
	
	//추가
	public void boardInsert(BoardDTO board);
	
	//수정
	public void boardUpdate(BoardDTO board);

	
	//전체보기
	public ArrayList<BoardDTO> boardList();
	
	public ArrayList<BoardDTO> boardList(int starRow,int endRow, String field, String word);
	
	// 삭제 
	public void boardDelete(int num);
	
	//게시글수
	public int boardCount(String field,String word);
	//상세보기
	public BoardDTO findByNum(int num);
	
	//--comment
	//추가
	public void commentInser(CommentDTO comment);
	//전체보기
	public ArrayList<CommentDTO>findAllComment(int bnum);
	//댓글개수
	public int commentCount(int bnum);
	

}
