package db.ex1.service;

import java.util.List;

import db.ex1.model.vo.StudentVO;

public interface StudentService {

	List<StudentVO> getStudentList();

	StudentVO getStudent(int grade, int classNum, int num);

	StudentVO getStudent(StudentVO studentVO);

	boolean addStudent(StudentVO std4);

	boolean updateStudentName(StudentVO std5);

	boolean deleteStudent(StudentVO std);

}
