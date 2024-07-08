package com.daou.sabangnetserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "USERS")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "PERMISSION", nullable = false)
    private String permission;

    @Column(name ="ID", nullable = false)
    private String id;

    @Column(name = "PASSWORD", nullable = false)
    private String pw;

    @Column(name ="NAME", nullable = false)
    private String name;

    @Column(name ="EMAIL", nullable = false)
    private String email;

    @Column(name = "DEPARTMENT", nullable = true)
    private String department;

    @Column(name ="MEMO", nullable = true)
    private String memo;

    @Column(name ="REGISTRATION_DATE", nullable = false)
    private Timestamp registrationDate;

    @Column(name ="IS_USED", nullable = false)
    private Boolean isUsed;

    @Column(name ="LAST_LOGIN_TIME", nullable = false)
    private Timestamp lastLoginTime;

    @Column(name ="LAST_LOGIN_IP", nullable = false)
    private String lastLoginIp;



}
