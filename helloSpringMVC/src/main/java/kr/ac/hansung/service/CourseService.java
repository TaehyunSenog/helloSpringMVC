package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;

@Service
public class CourseService {

	private CourseDAO courseDao;
	
	@Autowired
	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}
	
	// �б⺰ ���� ��ȸ 
	public List<Course> getSemesterCredit(){
		return courseDao.getSemesterCredit();
	}
	
	// �б⺰ ���� ��ȸ 
	public List<Course> getSemesterCreditLink(Course course){
		
		return courseDao.getSemesterGradelink(course);
	}

	// ������û 
	public boolean insertCourse(Course course){
		return courseDao.insertCourse(course);
	}
	
	// ������û ���� 
	public List<Course> getSearchCourse(){
		return courseDao.searhCourse();
	}
}