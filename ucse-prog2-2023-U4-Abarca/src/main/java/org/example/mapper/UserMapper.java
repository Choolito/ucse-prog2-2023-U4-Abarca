package org.example.mapper;

import org.example.model.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();
    User getUserById(int id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
