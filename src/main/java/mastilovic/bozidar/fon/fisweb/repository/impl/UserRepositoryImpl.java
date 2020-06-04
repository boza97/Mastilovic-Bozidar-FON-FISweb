/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.repository.impl;

import java.util.ArrayList;
import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.UserDto;
import mastilovic.bozidar.fon.fisweb.repository.UserRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bozidar
 */
@Component
public class UserRepositoryImpl implements UserRepository{
    
    private List<UserDto> users;

    public UserRepositoryImpl() {
        users = new ArrayList<UserDto>() {
            {
                add(new UserDto("Bozidar", "Mastilovic", "boza@gmail.com", "boza"));
                add(new UserDto("Petar", "Petrovic", "petar@gmail.com", "petar"));
                add(new UserDto("Marko", "Markovic", "marko@gmail.com", "marko"));
            }
        };
    }
    
    @Override
    public List<UserDto> getAll() {
        return users;
    }

    @Override
    public UserDto findByEmail(String email) {
        UserDto userDto = users.stream().filter(user -> email.equals(user.getEmail())).findAny().orElse(null);
        return userDto;
    }
}
