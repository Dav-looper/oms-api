package com.jonathan.portfolio.order_management_system.domain.ports;

import com.jonathan.portfolio.order_management_system.domain.model.User;

public interface UserRepository {
    User saveUser(User user);
}
