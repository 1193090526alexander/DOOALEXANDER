package co.edu.uco.grades.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.text.UtilText;

public class IdTypeDTO {
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> validateName(){
		List<String> validationMessages = new ArrayList<>();
		if (UtilText.isEmpty(getName())) {
			validationMessages.add("Name of id type is required");
			
		}else if(UtilText.getDefault(getName()).lenght()>50) {
			validationMessages.add(" Lenhgt of name of id type must be less o equalsto 50 caracters");
		}else if(!UtilText.getDefault(getName()).matches()>50) {
			validationMessages.add(" Name of id type is contains invalide ");
		}
	}

}
