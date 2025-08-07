package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.entity.UserSettings;
import com.ecommerce.user_service.service.userServiceSettingsService.UserServiceSettingsService;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserServiceSettingsController {

    private final UserServiceSettingsService userServiceSettingsService;

    @GetMapping("/{userId}/settings")
    public ResponseEntity<UserSettings> getSettings(@PathVariable UUID userId) {
        return ResponseEntity.ok(userServiceSettingsService.getUserSettings(userId));
    }

    @PutMapping("/{userId}/settings")
    public ResponseEntity<Void> updateSettings(@PathVariable UUID userId,
                                               @RequestBody UserSettings settings) {
        userServiceSettingsService.updateUserSettings(userId, settings);
        return ResponseEntity.noContent().build();
    }
}


