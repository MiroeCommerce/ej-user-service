package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.service.userServiceAdminService.UserServiceAdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserServiceAdminController {

    private final UserServiceAdminService userServiceAdminService;

    /**
     * GET /users  (admin)
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServiceAdminService.getAllUsers());
    }

    /**
     * POST /users  (admin)
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> createUser(@Valid @RequestBody User dto) {
        userServiceAdminService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
