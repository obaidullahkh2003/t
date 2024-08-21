package com.example.web.services;

import com.example.web.dtos.UserDto;
import com.example.web.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {
    UserDto registerUser(UserDto userDTO);
    UserDto loginUser(String username, String password);
    boolean userExists(String username);
    boolean emailExists(String email);
    List<UserDto> getAllUsers();
}
