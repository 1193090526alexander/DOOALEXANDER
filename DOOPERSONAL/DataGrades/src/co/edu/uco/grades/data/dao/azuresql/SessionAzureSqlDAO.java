package co.edu.uco.grades.data.dao.azuresql;

import static co.edu.uco.crosscutting.util.text.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.data.dao.SessionDAO;

import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SessionDTO;
import co.edu.uco.grades.dto.SubjectDTO;
import co.uco.grades.crosscuting.exception.GradesException;

public class SessionAzureSqlDAO extends ConnectionSQL implements SessionDAO {
	private List<SessionDTO> parameters;
	private Object sb;
	private SessionAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static SessionDAO build(Connection connection) {
		return new SessionAzureSqlDAO(connection);
	}

	@Override
	public void create(SessionDTO session) {
		String sql = "INSERT INTO Session(id, course, date) VALUES(?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(1, session.getId());
			preparedStatement.setCourse(2, session.getCourse());
			preparedStatement.setDate(3, (Date) session.getDate());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to create a new subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to create a new subject registry on sql server", exception);
			
		}
		
	}

	



@Override
public void update(SessionDTO session) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	
}

@Override
public void find(SessionDTO session) {
	// TODO Auto-generated method stub
	
}
}
