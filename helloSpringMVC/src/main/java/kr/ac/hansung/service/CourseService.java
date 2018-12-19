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
	
	// 학기별 학점 조회 
	public List<Course> getSemesterCredit(){
		return courseDao.getSemesterCredit();
	}
	
	// 학기별 과목 조회 
	public List<Course> getSemesterCreditLink(Course course){
		
		return courseDao.getSemesterGradelink(course);
	}

	// 수강신청 
	public boolean insertCourse(Course course){
		return courseDao.insertCourse(course);
	}
	
	// 수강신청 내역 
	public List<Course> getSearchCourse(){
		return courseDao.searhCourse();
	}
}