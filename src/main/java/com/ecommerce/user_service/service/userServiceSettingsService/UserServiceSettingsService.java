package com.ecommerce.user_service.service.userServiceSettingsService;

import com.ecommerce.user_service.entity.UserSettings;

import java.util.UUID;

public interface UserServiceSettingsService {
    UserSettings getUserSettings(UUID userId);

    void updateUserSettings(UUID userId, UserSettings settings);
}
