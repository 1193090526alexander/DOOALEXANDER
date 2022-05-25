package co.edu.uco.grades.data.factory.azuresql;

import java.sql.Connection;

import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;

import co.edu.co.crosscutting.util.sql.UtilConnection;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.uco.grades.crosscuting.exception.GradesException;

public  abstract class AzureSqlDAOfactory  extends DAOFactory {
	
	private Connection connection;
	
	private AzureSqlDAOfactory() {
		openConnection();
	}
	
	@Override
	protected void openConnection() {
		if(!UtilObject.getUtilObject.isNull(connection) 
			&& !UtilConnection.isClosed(connection)) {
		throw GradesException.buildTechnicalException("It's not possible open a connection because its already is open"); 	
		}
	}
	
	@Override
	public void getConnection() {
		//TODO Auto-generated method stub
	}
	
	

}
