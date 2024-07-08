package com.daou.sabangnetserver.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "HISTORY")
@Getter
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID", nullable = false)
    private Long logId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name ="LOGIN_TIME", nullable = false)
    private Timestamp loginTime;

    @Column(name = "LOGIN_DEVICE", nullable = false)
    private String loginDevice;

    @Column(name ="LOGIN_IP", nullable = false)
    private String loginIp;


}
