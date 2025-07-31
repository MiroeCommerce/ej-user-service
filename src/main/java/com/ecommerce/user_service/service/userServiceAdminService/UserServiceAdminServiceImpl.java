package com.ecommerce.user_service.service.userServiceAdminService;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceAdminServiceImpl implements UserServiceAdminService {

    private final UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(this::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(User incomeUser) {
        User user = new User();
        user.setEmail(incomeUser.getEmail());
        user.setUsername(incomeUser.getUsername());
        user.setPasswordHash(incomeUser.getPasswordHash());
        user.setFirstName(incomeUser.getFirstName());
        user.setLastName(incomeUser.getLastName());
        user.setUserType(incomeUser.getUserType());
        user.setLanguage(incomeUser.getLanguage());
        user.setTimezone(incomeUser.getTimezone());
        user.setActive(true);
        user.setEmailVerified(false);
        userRepo.save(user);
    }

    private User toUser(User user) {
        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userType(user.getUserType())
                .language(user.getLanguage())
                .timezone(user.getTimezone())
                .build();
    }
}
