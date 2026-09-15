package com.jonathan.portfolio.order_management_system.application.ports.out;

import com.jonathan.portfolio.order_management_system.domain.model.User;

public interface UserPort {
    User saveUser(User user);
}
