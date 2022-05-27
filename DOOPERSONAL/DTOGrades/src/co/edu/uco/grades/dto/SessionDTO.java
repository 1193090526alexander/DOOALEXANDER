package co.edu.uco.grades.dto;

import java.util.Date;

public class SessionDTO {
	
	private int id;
	private SessionDTO course;
	private Date date;
	
	
	
	public SessionDTO() {
		setId (id);
		setCourse (course);
		setDate (date);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SessionDTO getCourse() {
		return course;
	}
	public void setCourse(SessionDTO course) {
		this.course = course;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
