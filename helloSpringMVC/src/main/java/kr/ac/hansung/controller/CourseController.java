package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	private CourseService courseService;
	
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	// 학기별 학점 
	@RequestMapping("/semestercredit")
	public String showSemesterCredit (Model model) {
		List<Course> courses = courseService.getSemesterCredit();
		model.addAttribute("course", courses);
		return "semestercredit";
	}
	
	// 수강신청 
	@RequestMapping("/courseRegister")
	public String showAddCourse (Model model){
		model.addAttribute("course", new Course());
		return "courseRegister";
		
	}
	

	// 링크 
	@RequestMapping("/semestercreditlink")
	public String semestercreditlink (Model model, Course course){
		List<Course> courses = courseService.getSemesterCreditLink(course);
		model.addAttribute("course", courses);
		return "semestercreditlink";
	}
	
	// 수강신청조회 
	@RequestMapping("/searchcourse")
	public String showSearchCourse (Model model){
		List<Course> courses = courseService.getSearchCourse();
		model.addAttribute("course", courses);
		return "searchcourse";
	}
	
}