package com.ecommerce.user_service.service.userService;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    @Transactional(readOnly = true)
    public User getUserById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public User updateUser(UUID id, User incoming) {
        User u = getUserById(id);
        u.setUsername(incoming.getUsername());
        u.setFirstName(incoming.getFirstName());
        u.setLastName(incoming.getLastName());
        u.setPhoneNumber(incoming.getPhoneNumber());
        u.setDateOfBirth(incoming.getDateOfBirth());
        u.setGender(incoming.getGender());
        u.setProfilePicture(incoming.getProfilePicture());
        u.setLanguage(incoming.getLanguage());
        u.setTimezone(incoming.getTimezone());
        u.setRole(incoming.getRole());
        return repo.save(u);
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        repo.deleteById(id);
    }
}
