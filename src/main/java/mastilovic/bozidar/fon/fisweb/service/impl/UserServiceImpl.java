/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastilovic.bozidar.fon.fisweb.service.impl;

import java.util.List;
import mastilovic.bozidar.fon.fisweb.dto.UserDto;
import mastilovic.bozidar.fon.fisweb.repository.UserRepository;
import mastilovic.bozidar.fon.fisweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bozidar
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}