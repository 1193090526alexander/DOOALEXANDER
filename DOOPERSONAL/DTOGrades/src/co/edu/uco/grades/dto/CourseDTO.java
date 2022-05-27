package co.edu.uco.grades.dto;

import java.util.Date;

import co.edu.uco.crosscutting.util.text.UtilText;

public class CourseDTO {
	
	private int id;
	private SubjectDTO subject;
	private TeacherDTO professor;
	private Date initialDate;
	private Date finalDate;
	
	
	
	public CourseDTO() {
		setId (id);
		setSubject (subject);
		setProfessor (professor);
		setInitialDate (initialDate);
		setFinalDate (finalDate);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public TeacherDTO getProfessor() {
		return professor;
	}
	public void setProfessor(TeacherDTO professor) {
		this.professor = professor;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
		
		
}


