/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.validator;

import mastilovic.bozidar.fon.fisweb.dto.DepartmentDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Bozidar
 */
@Component
public class DepartmentValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return DepartmentDto.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DepartmentDto department = (DepartmentDto) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shortName", null, "Short name must not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "Name must not be empty.");
        
        if(errors.hasErrors())
            return;
        
        if(department.getName().length() <= 2)
            errors.rejectValue("name", null, "Name should be more than 2 characters.");
    }
    
}
