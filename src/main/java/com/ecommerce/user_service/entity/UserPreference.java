package com.ecommerce.user_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "user_preferences",
        uniqueConstraints = @UniqueConstraint(name = "uk_user_preferences_user_key", columnNames = {"user_id", "preference_key"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "preference_id", nullable = false)
    private UUID preferenceId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user"))
    private User user;

    @Column(name = "preference_key", nullable = false, columnDefinition = "text")
    private String preferenceKey;

    @Column(name = "preference_value", columnDefinition = "jsonb", nullable = false)
    private Object preferenceValue;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.updatedAt = Instant.now();
    }
}
