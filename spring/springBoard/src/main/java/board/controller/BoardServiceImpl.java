package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public int boardWrite(BoardDTO boardDTO) {
		return boardDAO.boardWrite(boardDTO);
	}
	@Override
	public int boardModify(BoardDTO boardDTO) {
		return boardDAO.boardModify(boardDTO);
	}
	@Override
	public List<BoardDTO> boardList(int startNum, int endNum) {
		return boardDAO.boardList(startNum, endNum);
	}
	@Override
	public BoardDTO boardView(int seq) {
		return boardDAO.boardView(seq);
	}
	@Override
	public void updateHit(int seq) {
		boardDAO.updateHit(seq);
	}
	@Override
	public int boardDelete(int seq) {
		return boardDAO.boardDelete(seq);
	}
	@Override
	public int getTatalA() {
		return boardDAO.getTatalA();
	}
}






