package com.ecommerce.user_service.service.userServiceLoyaltyService;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.entity.UserLoyalty;
import com.ecommerce.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

// TODO: Basic implementation of loyalty logic — subject to refactor and extension.
@Service
@RequiredArgsConstructor
public class UserServiceLoyaltyServiceImpl implements UserServiceLoyaltyService {

    private final UserRepository userRepository;

    @Override
    public UserLoyalty getLoyaltyInfo(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserLoyalty loyalty = user.getLoyalty();
        if (loyalty == null) {
            throw new EntityNotFoundException("User loyalty not found");
        }

        return loyalty;
    }
}
