package com.ecommerce.user_service.service.userServiceActivityService;

import com.ecommerce.user_service.entity.UserActivity;
import com.ecommerce.user_service.repository.UserActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserActivityServiceImpl implements UserActivityService {

    private final UserActivityRepository repo;
    
    @Override
    public List<UserActivity> getUserActivity(UUID userId) {
        return repo.findAllByUserId(userId);
    }
}

