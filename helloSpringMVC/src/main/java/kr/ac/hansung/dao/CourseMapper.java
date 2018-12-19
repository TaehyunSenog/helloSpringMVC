package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Course;


public class CourseMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();

		course.setYear(rs.getInt("year"));
		course.setSem(rs.getString("sem"));
		course.setName(rs.getString("name"));
		course.setCode(rs.getString("code"));
		course.setGrades(rs.getInt("grades"));
		course.setValue(rs.getString("value"));

		return course;
	}

}