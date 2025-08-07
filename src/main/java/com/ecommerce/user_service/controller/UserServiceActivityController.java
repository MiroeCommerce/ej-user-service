package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.entity.UserActivity;

import com.ecommerce.user_service.service.userServiceActivityService.UserActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserServiceActivityController {

    private final UserActivityService activityService;

    /**
     * GET /users/{userId}/activity
     */
    @GetMapping("/{userId}/activity")
    public ResponseEntity<List<UserActivity>> getActivity(@PathVariable UUID userId) {
        return ResponseEntity.ok(activityService.getUserActivity(userId));
    }
}

