package com.daou.sabangnetserver.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@Builder
@AllArgsConstructor
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
    private LocalDateTime registrationDate;

    @Column(name ="IS_USED", nullable = false)
    private String isUsed;

    @Column(name ="LAST_LOGIN_TIME", nullable = false)
    private LocalDateTime lastLoginTime;

    @Column(name ="LAST_LOGIN_IP", nullable = false)
    private String lastLoginIp;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;


    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;


}
