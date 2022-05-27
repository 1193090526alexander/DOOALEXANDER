package co.edu.uco.grades.data.factory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.IdTypeDTO;
import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import static co.edu.uco.crosscutting.util.text.UtilText.EMPTY;
import static co.edu.uco.crosscutting.util.text.UtilText.SPACE;
import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;



public class IdTypeAzureSqlDAO extends ConnectionSQL implements IdTypeDAO {

	private List<IdTypeDTO> parameters;
	private Object sb;
	private IdTypeAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static IdTypeAzureSqlDAO build(Connection connection) {
		return new IdTypeAzureSqlDAO(connection);
	}

	@Override
	public void create(IdTypeDTO idType) {
		String sql = "INSERT INTO IdType(id, name) VALUES(?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(1, idType.getId());
			preparedStatement.setString(2, idType.getName());			
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to create a new subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to create a new subject registry on sql server", exception);
			
		}
		
	}

	@Override
	public void update(IdTypeDTO idType) {
String sql = "UPDATE FROM Subject WHERE id = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(1, idType.getId());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to update a subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to update a subject registry on sql server", exception);
			
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM IdType WHERE id = ?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(1, idType.getId());
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to delete a subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to delete a subject registry on sql server", exception);
			
		}
		
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO idType) {
		
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<IdTypeDTO> results = new ArrayList<IdTypeDTO>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT id, name").append(EMPTY);
		sb.append("FROM IdType").append(SPACE);
		
		if(!UtilObject.getUtilObject().isNull(idType)) {
			
			if(UtilNumeric.getUtilNumeric().isGreatherThan(idType.getId(), idType.getName())){
				sb.append("WHERE id= ? ");
				setWhere = false;
				
				
			}
			if(!UtilText.isEmpty(idType.getName())){
				sb.append(setWhere ? "WHERE " : "AND ");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(idType.getName()));
			}
		}
		
		sb.append("ORDER BY name ASC");
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())){
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
			
			try (ResultSet resultSet = preparedStatement.executeQuery()){
			
		}catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to delete a subject registry on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to delete a subject registry on sql server", exception);
			
		}
		return results;}
	}
		
	private List<IdTypeDTO> assembleResults (ResultSet resultSet) throws Exception {
		List<IdTypeDTO> results = new ArrayList<>();
		
		try {
			while (resultSet.next()) {
			
		} }catch (SQLException exception){
			
			throw GradesException.buildTechnicalException("There was a problem trying to recover tyhe subject names on sql server", exception);
			
		}catch (Exception exception) {
			
			throw GradesException.buildTechnicalException("There was an unexpected problem trying to delete a subject registry on sql server", exception);
			
	}
	return results;

}
	
private List<IdTypeDTO> executeQuery(PreparedStatement preparedStatement){
	List<IdTypeDTO>;

	
	
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
private IdTypeDTO assembleDTO(ResultSet resultSet) throws Exception {
	
	IdTypeDTO dto = new IdTypeDTO();
	
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


}

