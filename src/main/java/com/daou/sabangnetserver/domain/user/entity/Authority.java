package com.daou.sabangnetserver.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "AUTHORITY")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHORITY_ID", nullable = false)
    private Long id;

    @Column(name = "AUTHORITY_NAME", length = 50)
    private String authorityName;

    public Authority(String authorityName) {
        this.authorityName = authorityName;
    }
}

