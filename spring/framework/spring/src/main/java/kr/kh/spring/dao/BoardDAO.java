package kr.kh.spring.dao;

import java.util.List;

import kr.kh.spring.model.vo.BoardVO;

public interface BoardDAO {

	int selectCount();

	List<BoardVO> selectBoardList();

}
