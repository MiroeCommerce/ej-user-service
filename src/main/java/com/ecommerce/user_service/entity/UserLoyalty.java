package com.ecommerce.user_service.entity;

import com.ecommerce.user_service.enums.Tier;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

// TODO: Temporary loyalty implementation — subject to review and refactor in future.
@Entity
@Table(name = "user_loyalty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoyalty {

    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Tier tier = Tier.SILVER;

    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "status", length = 100)
    private String status;
}
