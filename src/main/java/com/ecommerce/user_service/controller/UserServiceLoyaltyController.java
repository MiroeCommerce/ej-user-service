package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.entity.UserLoyalty;
import com.ecommerce.user_service.service.userServiceLoyaltyService.UserServiceLoyaltyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

// TODO: Current loyalty controller is temporary — revisit for improvements or restructuring.
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserServiceLoyaltyController {

    private final UserServiceLoyaltyService userServiceLoyaltyService;

    @GetMapping("/{userId}/loyalty")
    public ResponseEntity<UserLoyalty> getLoyalty(@PathVariable UUID userId) {
        return ResponseEntity.ok(userServiceLoyaltyService.getLoyaltyInfo(userId));
    }
}
