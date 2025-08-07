package com.ecommerce.user_service.service.userServiceSettingsService;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.entity.UserSettings;
import com.ecommerce.user_service.repository.UserRepository;
import com.ecommerce.user_service.repository.UserSettingsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceSettingsServiceImpl implements UserServiceSettingsService {

    private final UserSettingsRepository settingsRepo;
    private final UserRepository userRepo;

    @Override
    public UserSettings getUserSettings(UUID userId) {
        return settingsRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User settings not found"));
    }


    @Override
    public void updateUserSettings(UUID userId, UserSettings userSettings) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserSettings settings = settingsRepo.findById(userId)
                .orElse(UserSettings.builder().user(user).userId(userId).build());

        settings.setSettings(userSettings.getSettings());
        settingsRepo.save(settings);
    }
}


