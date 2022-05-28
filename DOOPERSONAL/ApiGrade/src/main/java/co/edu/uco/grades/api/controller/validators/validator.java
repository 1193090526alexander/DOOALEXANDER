package co.edu.uco.grades.api.controller.validators;

import java.util.List;



public interface validator<D> {
  List<String> validate(D dto);


}
