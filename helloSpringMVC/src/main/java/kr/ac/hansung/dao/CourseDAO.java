package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO{
private JdbcTemplate jdbcTemplate;


	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	public List<Course> getCourses() { 
		String sqlStatement = "select * from course";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setYear(rs.getInt("year"));
				course.setSem(rs.getString("sem"));
				course.setCode(rs.getString("name"));
				course.setCode(rs.getString("code"));
				course.setValue(rs.getString("value"));
				course.setGrades(rs.getInt("grades"));

				return course;
			}
		});
	}
	
	// 이수 학점 조회	
	public List<Course> getSemesterCredit(){
		String sqlStatement = "select year, term, sum(credit) as credit from courses group by year, term";
			return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
			    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				      Course course = new Course();
				      course.setYear(rs.getInt("year"));
					  course.setSem(rs.getString("sem"));
					  course.setGrades(rs.getInt("grades"));
				      return course;
			    }
			});
	}
	
	// 이수 학점 상세보기
	public List<Course> getSemesterGradelink(Course course){
		int year = course.getYear();
		String term = course.getSem();
				
				String sqlStatement = "select year, term, subject, credit as credit from courses where year="+year+" and term ="+ term;
				return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
				    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				      Course course = new Course();
				      course.setYear(rs.getInt("year"));
					  course.setSem(rs.getString("sem"));
					  course.setName(rs.getString("name"));
					  course.setGrades(rs.getInt("grades"));
				      return course;
				    }
		});
	}
	
	// 수강 신청
	public Boolean insertCourse(Course course){
		String subjectCode = course.getCode();
		String sqlStatement = "update applyCourse set isApply = 1 where subjectCode = ?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {subjectCode}) == 1);
	}
	
	// 수강내역 조회 
	public List<Course> searhCourse(){
			String sqlStatement = "select year, sem, name, value, grades from applyCourse where isApply = 1";
			return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {
			    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			      Course course = new Course();
			      course.setYear(rs.getInt("year"));
				  course.setSem(rs.getString("sem"));
				  course.setName(rs.getString("name"));
				  course.setValue(rs.getString("value"));
				  course.setGrades(rs.getInt("grades"));
			      return course;
			    }
			  });
		}

	public boolean insert(Course course) {

		int year = course.getYear();
		String sem = course.getSem();
		String code = course.getCode();
		int grades = course.getGrades();

		String sqlStatement = "insert into course (year,sem,code,grades) values (?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] {year,sem,code,grades}) == 1);
	}


}