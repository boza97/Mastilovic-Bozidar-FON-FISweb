/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.service;

import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.UserDto;

/**
 *
 * @author Bozidar
 */
public interface UserService {
    List<UserDto> getAll();
    UserDto findByEmail(String email);
}
