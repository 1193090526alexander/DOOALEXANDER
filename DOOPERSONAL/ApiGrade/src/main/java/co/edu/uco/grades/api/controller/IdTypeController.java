package co.edu.uco.grades.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.api.controller.response.Response;
import co.edu.uco.grades.api.controller.validators.validator;
import co.edu.uco.grades.api.controller.validators.idtype.CreateIdTypeValidator;
import co.edu.uco.grades.bisinesslogic.facade.impl.IdTypeFacadeImpl;
import co.edu.uco.grades.businesslogic.facade.IdTypeFacade;
import co.edu.uco.grades.dto.IdTypeDTO;
import co.uco.grades.crosscuting.exception.GradesException;
import co.uco.grades.crosscuting.exception.enumeration.ExceptionType;

@RestController
@RequestMapping("/api/v1/idtype")
public class IdTypeController {
	
	
	@GetMapping("/dummy")
	public IdTypeDTO getDummy(){
		return new IdTypeDTO();
	}
	
	@PostMapping
	public ResponseEntity<Response<IdTypeDTO>> create(@RequestBody IdTypeDTO dto) {
		
		validator<IdTypeDTO> validator = new CreateIdTypeValidator();
		List<String> messages =UtilObject.getUtilObject().getDefault(validator.validate(dto), new ArrayList<>());
		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> resposeEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;

		if(messages.isEmpty()) {
			try {
				IdTypeFacade facade = new IdTypeFacadeImpl();
				facade.create(dto);
				messages.add("Id type was created succesfully!");
				statusCode= HttpStatus.OK;
			}catch(GradesException exception) {
				if(ExceptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("These was a problem trying  to register  the new  id type.  Please, try again...");
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
                    exception.getRootException().printStackTrace();
				}else {
					messages.add(exception.getUserMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}
				
			}catch (Exception exception) {
				messages.add("These was a problem trying  to register  the new  id type. Please, try again...");
				exception.printStackTrace();
				
			}
		}
		 response.setMessages(messages);
		 ResponseEntity responseEntity = new ResponseEntity<>(response, statusCode);
		return responseEntity;
		
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") int id,@RequestBody IdTypeDTO dto) {
		System.out.println("estoy en actualizar!!");
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		System.out.println("estoy en Eliminar!!");
	}
	@GetMapping ("/{id}")
	public void findById(@PathVariable("id") int id) {
		System.out.println("estoy en consultar todos!!");
	}
	@GetMapping
	public void find() {
		System.out.println("estoy en consultar todos!!");
	}

}
