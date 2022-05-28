package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.SubjectDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SessionDTO;
import co.edu.uco.grades.dto.SubjectDTO;
import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import static co.edu.uco.crosscutting.util.text.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;
import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;



public class SubjectAzureSqlDAO extends ConnectionSQL implements SubjectDAO {

	private List<SubjectDTO> parameters;
	private Object sb;
	private SubjectAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static SubjectDAO build(Connection connection) {
		return new SubjectAzureSqlDAO(connection);
	}

	@Override
	public void create(SubjectDTO subject) {
		String sql = "INSERT INTO Subject(id, name) VALUES(?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(1, subject.getId());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to create a new subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to create a new subject registry on sql server", exception);
			
		}
		
	}

	@Override
	public void update(SubjectDTO subject) {
String sql = "UPDATE FROM Subject WHERE id = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(1, subject.getId());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to update a subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to update a subject registry on sql server", exception);
			
		}
		
	}




		
	private List<SubjectDTO> assembleResults (ResultSet resultSet) throws Exception {
		List<SubjectDTO> results = new ArrayList<>();
		
		try {
			while (resultSet.next()) {
			
		} }catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to recover tyhe subject names on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to delete a subject registry on sql server", exception);
			
	}
	return results;

}
	
private List<SubjectDTO> executeQuery(PreparedStatement preparedStatement){
	List<SubjectDTO>;

	
	
	try(PreparedStatement preparedStatement1 = getConnection().prepareStatement(sb.toString())){
		for (int index = 0; index < parameters.size(); index++) {
			preparedStatement1.setObject(index + 1, parameters.get(index));
		}
		
		try (ResultSet resultSet = preparedStatement1.executeQuery()){
		
	}catch (SQLException exception){
		
		throw GradesException.buildTechnicalException("There was a problem trying to delete a subject registry on sql server", exception);
		
	}catch (Exception exception) {
		
		throw GradesException.buildTechnicalException("There was an unexpected problem trying to delete a subject registry on sql server", exception);
		
	}
}
}
private SubjectDTO assembleDTO(ResultSet resultSet) throws Exception {
	
	SubjectDTO dto = new SubjectDTO();
	
	try {
		dto.setId(resultSet.getInt("id"));
		dto.setName(resultSet.getString("name"));
		
		}catch (SQLException exception){
		
			throw GradesException.buildTechnicalException("There was a problem trying to assemble tyhe subject names on sql server", exception);
		
		}catch (Exception exception) {
		
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to assemble the subject names on sql server", exception);
		
		}
		return dto;
	}

@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	
}
@Override
public  void find(SubjectDTO subject) {
	// TODO Auto-generated method stub
	
}
}
