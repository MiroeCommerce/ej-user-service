package com.ecommerce.user_service.service.userServicePreferenceService;

import com.ecommerce.user_service.entity.UserPreference;

import java.util.List;
import java.util.UUID;

public interface UserServicePreferenceService {
    List<UserPreference> getUserPreferences(UUID userId);

    void updateUserPreferences(UUID userId, List<UserPreference> preferences);
}
