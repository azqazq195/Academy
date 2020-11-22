package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;

public interface BoardService {
	// insert : 글저장
	public int boardWrite(BoardDTO boardDTO);
	// 글수정
	public int boardModify(BoardDTO boardDTO);		
	// 목록 읽기 - 5개씩 끊어서 읽어오기
	public List<BoardDTO> boardList(int startNum, int endNum);
	// 상세보기 : 목록 1개
	public BoardDTO boardView(int seq);
	// 조회수 증가
	public void updateHit(int seq);
	// 글 삭제
	public int boardDelete(int seq);
	// 총 글수 구하기
	public int getTatalA();
}





