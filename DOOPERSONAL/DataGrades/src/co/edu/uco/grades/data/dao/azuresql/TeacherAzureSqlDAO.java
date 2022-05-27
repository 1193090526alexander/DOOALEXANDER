package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grades.data.dao.TeacherDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SubjectDTO;
import co.edu.uco.grades.dto.TeacherDTO;
import co.uco.grades.crosscuting.exception.GradesException;

public class TeacherAzureSqlDAO extends ConnectionSQL implements TeacherDAO {

	protected TeacherAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}


	
	public static TeacherDAO build(Connection connection) {
		return new TeacherAzureSqlDAO(connection);
	}

	@Override
	public void create(TeacherDTO teacher) {
		String sql = "INSERT INTO Teacher(id idNumber, idType, name, email) VALUES(?,?,?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, teacher.getIdNumber());
			preparedStatement.setInt(2, teacher.getIdType().getId());
			preparedStatement.setString(2, teacher.getName());	
			preparedStatement.setString(2, teacher.getEmail());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalDataException("There was a problem trying to create a new studend registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalDataException("There was an unexpected problem trying to create a new studend registry on sql server", exception);
			
		}
		
	}

	@Override
	public void update(TeacherDTO teacher) {
     String sql = "UPDATE FROM Teacher WHERE id = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, teacher.getIdNumber());
			preparedStatement.setInt(2, teacher.getIdType().getId());
			preparedStatement.setString(2, teacher.getName());	
			preparedStatement.setString(2, teacher.getEmail());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to update a subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to update a subject registry on sql server", exception);
			
		}
		
	}

	@Override
	public void find(TeacherDTO teacher) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
