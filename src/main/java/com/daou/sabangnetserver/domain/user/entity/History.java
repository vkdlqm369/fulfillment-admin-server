package com.daou.sabangnetserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "HISTORY")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_ID", nullable = false)
    private Long historyId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name ="LOGIN_TIME", nullable = false)
    private LocalDateTime loginTime;

    @Column(name = "LOGIN_DEVICE", nullable = false)
    private String loginDevice;

    @Column(name ="LOGIN_IP", nullable = false)
    private String loginIp;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable=false, updatable=false)
    private User user;
}
