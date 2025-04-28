package kr.kh.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.shoppingmall.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDao;
}
