package com.ecommerce.user_service.service.userServiceAdminService;

import com.ecommerce.user_service.entity.User;

import java.util.List;

public interface UserServiceAdminService {
    List<User> getAllUsers();

    void createUser(User user);
}
