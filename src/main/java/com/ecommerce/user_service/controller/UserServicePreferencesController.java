package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.entity.UserPreference;
import com.ecommerce.user_service.service.userServicePreferenceService.UserServicePreferenceService;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserServicePreferencesController {

    private final UserServicePreferenceService userServicePreferencesService;

    /**
     * GET /users/{userId}/preferences
     */
    @GetMapping("/{userId}/preferences")
    public ResponseEntity<List<UserPreference>> getPreferences(@PathVariable UUID userId) {
        return ResponseEntity.ok(userServicePreferencesService.getUserPreferences(userId));
    }


    /**
     * PUT /users/{userId}/preferences
     */
    @PutMapping("/{userId}/preferences")
    public ResponseEntity<Void> updatePreferences(@PathVariable UUID userId,
                                                  @RequestBody List<UserPreference> preferences) {
        userServicePreferencesService.updateUserPreferences(userId, preferences);
        return ResponseEntity.noContent().build();
    }

}
