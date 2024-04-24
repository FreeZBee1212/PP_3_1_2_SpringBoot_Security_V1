package ru.kata.spring.boot_security.demo.dao;





import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User showOneUser(int id);
    public void saveUser(User user);
    public void updateUser(User updatedUser);
    public void deleteUser(User user);

    }


