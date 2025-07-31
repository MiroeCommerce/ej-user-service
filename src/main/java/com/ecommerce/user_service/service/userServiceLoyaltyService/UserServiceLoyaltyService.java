package com.ecommerce.user_service.service.userServiceLoyaltyService;

import com.ecommerce.user_service.entity.UserLoyalty;

import java.util.UUID;

public interface UserServiceLoyaltyService {
    UserLoyalty getLoyaltyInfo(UUID userId);
}
