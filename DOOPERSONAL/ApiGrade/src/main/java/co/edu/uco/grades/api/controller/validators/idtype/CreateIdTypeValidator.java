package co.edu.uco.grades.api.controller.validators.idtype;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Validator;

import co.edu.uco.grades.api.controller.validators.validator;
import co.edu.uco.grades.dto.IdTypeDTO;

public class CreateIdTypeValidator implements  validator<IdTypeDTO> {
 
	private List<String> validationMessages = new ArrayList<>();
	
	@Override 
	public List<String> validate(idTypeDTO)
	
}
