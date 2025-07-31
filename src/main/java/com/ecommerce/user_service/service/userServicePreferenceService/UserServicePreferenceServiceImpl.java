package com.ecommerce.user_service.service.userServicePreferenceService;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.entity.UserPreference;
import com.ecommerce.user_service.repository.UserPreferenceRepository;
import com.ecommerce.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServicePreferenceServiceImpl implements UserServicePreferenceService {

    private final UserPreferenceRepository preferenceRepository;
    private final UserRepository userRepository;

    @Override
    public List<UserPreference> getUserPreferences(UUID userId) {
        if (!userRepository.existsById(userId))
            throw new EntityNotFoundException("User not found");
        return preferenceRepository.findByUserId(userId);
    }

    @Override
    public void updateUserPreferences(UUID userId, List<UserPreference> preferences) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        preferences.forEach(pref -> pref.setUser(user));
        preferenceRepository.saveAll(preferences);
    }
}
