package com.ecommerce.user_service.repository;

import com.ecommerce.user_service.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, UUID> {
    List<UserActivity> findAllByUserId(UUID userId);
}

