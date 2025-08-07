package com.ecommerce.user_service.service.userService;

import com.ecommerce.user_service.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface UserService {
    @Transactional(readOnly = true)
    User getUserById(UUID id);

    @Transactional
    User updateUser(UUID id, User incoming);

    @Transactional
    void deleteUser(UUID id);
}
