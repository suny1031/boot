package com.toy.sy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository UserRepository;

    public UserService(UserRepository userRepository) {
        this.UserRepository = userRepository;
    }

    public List<User> selectAll(){
        return UserRepository.selectAll();
    }

    public void insertUser(User user) {
         UserRepository.insertUser(user);
    }

    public void updateUser(User user) {
        UserRepository.updateUser(user);
    }

    public void updateTest(User user) {
        UserRepository.updateTest(user);
    }

    public void deleteUser(User user) {
        UserRepository.deleteUser(user);
    }
}
