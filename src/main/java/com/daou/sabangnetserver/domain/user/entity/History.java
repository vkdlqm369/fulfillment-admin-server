package com.daou.sabangnetserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "HISTORY")
@Getter
@Setter
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


}
