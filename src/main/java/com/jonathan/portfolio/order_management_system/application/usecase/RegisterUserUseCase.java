package com.jonathan.portfolio.order_management_system.application.usecase;

import com.jonathan.portfolio.order_management_system.domain.model.User;
import com.jonathan.portfolio.order_management_system.domain.ports.UserRepository;

public class RegisterUserUseCase {
    private UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        return userRepository.saveUser(user);
    }
}