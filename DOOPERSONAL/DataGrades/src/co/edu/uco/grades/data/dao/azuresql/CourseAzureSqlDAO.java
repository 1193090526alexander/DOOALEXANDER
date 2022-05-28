package co.edu.uco.grades.data.dao.azuresql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grades.data.dao.CourseDAO;

import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.CourseDTO;
import co.edu.uco.grades.dto.SubjectDTO;
import co.uco.grades.crosscuting.exception.GradesException;

public class CourseAzureSqlDAO  extends ConnectionSQL implements CourseDAO {
	private CourseAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static CourseDAO build(Connection connection) {
		return (CourseDAO) new CourseAzureSqlDAO(connection);
	}

	@Override
	public void create(CourseDTO course) {
		String sql = "INSERT INTO Course(subject, professor, initialDate, finalDate) VALUES(?,?,?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setObject(1, course.getSubject());
			preparedStatement.setProfessor(2, course.getProfessor());
			preparedStatement.setDate(3, course.getInitialDate());
			preparedStatement.setDate(4, course.getFinalDate());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalDataException("There was a problem trying to create a new studend registry on sql server", exception, null);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalDataException("There was an unexpected problem trying to create a new studend registry on sql server", exception, null);
			
		}
		
	}



	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(CourseDTO course) {
		// TODO Auto-generated method stub
		
	}
}
