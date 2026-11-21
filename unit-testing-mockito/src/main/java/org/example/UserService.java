package org.example;


public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int id) {

        User user = userRepository.findById(id);

        if (user == null) {
            return "User not found";
        }

        return user.getName();
    }
}