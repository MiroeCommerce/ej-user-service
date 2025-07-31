package com.ecommerce.user_service.entity;

import com.ecommerce.user_service.enums.Gender;
import com.ecommerce.user_service.enums.UserType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_users_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_users_username", columnNames = "username")
        },
        indexes = {
                @Index(name = "idx_users_user_type", columnList = "user_type"),
                @Index(name = "idx_users_created_at", columnList = "created_at"),
                @Index(name = "idx_users_role_id", columnList = "role_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;
    
    @Email
    @Column(nullable = false, length = 255)
    private String email;

    @Column(length = 150)
    private String username;

    @Column(name = "password_hash", nullable = false, columnDefinition = "text")
    private String passwordHash;


    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(name = "profile_picture", columnDefinition = "text")
    private String profilePicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", length = 50, nullable = false)
    private UserType userType = UserType.GUEST;

    // TODO: Loyalty field is part of temporary design — to be reevaluated in the future.
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private UserLoyalty loyalty;


    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @Column(name = "is_email_verified", nullable = false)
    private boolean emailVerified = false;

    @Column(name = "last_login_at")
    private Instant lastLoginAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    /* ---------- Auth & locale ---------- */
    @Column(name = "auth_provider", length = 50)
    private String authProvider;

    @Column(length = 50)
    private String timezone;

    @Column(length = 10)
    private String language;

    @Column(name = "role_name", length = 100)
    private String role;
}
