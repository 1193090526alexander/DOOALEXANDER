package co.uco.grades.crosscuting.exception;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.uco.grades.crosscuting.exception.enumeration.ExceptionLocation;
import co.uco.grades.crosscuting.exception.enumeration.ExceptionType;
import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;
import java.sql.SQLException;
public class GradesException extends GeneralException {
    /**
     * 
     */
    private static final long serialVersionUID = -4918303258432166026L;
    private ExceptionType type;
    private ExceptionLocation location;
    private GradesException(String userMessage, String technicalMessage, Exception rootException, ExceptionType type,
            ExceptionLocation location) {
        super(userMessage, technicalMessage, rootException);
        setType(type);
        setLocation(location);
    }
    public static GradesException buildUserException(String userMessage) {
        return new GradesException(userMessage, userMessage, null, null, null);
    }
    public static GradesException buildTechnicalException(String technicalMessage) {
        return new GradesException(null, technicalMessage, null, null, null);
    }
    public static GradesException buildTechnicalDataException(String technicalMessage, Exception exception, ExceptionLocation data) {
        return new GradesException(null, technicalMessage, null, null, null);
    }
    public static GradesException buildTechnicalBusinessLogicException(String technicalMessage) {
        return new GradesException(null, technicalMessage, null, null, null);}
    public static GradesException build(String userMessage, String technicalMessage) {
        return new GradesException(userMessage, technicalMessage, null, null, null);
    }
    public static GradesException build(String userMessage, String technicalMessage,
            Exception rootException) {
        return new GradesException(userMessage, technicalMessage, null, null, null);
    }
    public ExceptionType getType() {
        return type;
    }
    public void setType(ExceptionType type) {
        this.type = getUtilObject().getDefault(type, ExceptionType.GENERAL);
    }
    public ExceptionLocation getLocation() {
        return location;
    }
    public void setLocation(ExceptionLocation location) {
        this.location = getUtilObject().getDefault(location, ExceptionLocation.GENERAL);
    }
    public static Exception buildTechnicalException(String string, Exception exception) {
        // TODO Auto-generated method stub
        return null;
    }
}