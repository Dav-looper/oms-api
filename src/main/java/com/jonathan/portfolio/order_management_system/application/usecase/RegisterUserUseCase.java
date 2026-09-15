package com.jonathan.portfolio.order_management_system.application.usecase;

import com.jonathan.portfolio.order_management_system.domain.model.User;
import com.jonathan.portfolio.order_management_system.application.ports.out.UserPort;

public class RegisterUserUseCase {
    private UserPort userPort;

    public RegisterUserUseCase(UserPort userPort) {
        this.userPort = userPort;
    }

    public User execute(User user) {
        return userPort.saveUser(user);
    }
}