package org.example;

import java.util.List;

public interface UserMapper {
    void createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}
