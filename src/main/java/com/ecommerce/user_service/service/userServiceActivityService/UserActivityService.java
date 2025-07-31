package com.ecommerce.user_service.service.userServiceActivityService;

import com.ecommerce.user_service.entity.UserActivity;

import java.util.List;
import java.util.UUID;

public interface UserActivityService {
    List<UserActivity> getUserActivity(UUID userId);
}

