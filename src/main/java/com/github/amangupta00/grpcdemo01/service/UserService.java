package com.github.amangupta00.grpcdemo01.service;

import com.github.amangupta00.grpcdemo01.dao.UserDao;
import com.github.amangupta00.grpcdemo01.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public User getUserForUserId(String username) {
        return userDao.getUserForUserId(username);
    }

    public List<User> findAll() {
        return userDao.getAllUsers();
    }

    public User insert(User user){
        return userDao.insert(user);
    }

    public int deleteById(int userId){
        return userDao.deleteById(userId);
    }
}
