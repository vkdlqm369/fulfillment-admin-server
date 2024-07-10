package com.daou.sabangnetserver.domain.user.repository;

import com.daou.sabangnetserver.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE " +
            "(:id = '' OR u.id = :id) AND " +
            "(:name = '' OR u.name LIKE %:name%) AND " +
            "(:email = '' OR u.email LIKE %:email%) AND " +
            "(:isUsed = '' OR u.isUsed = :isUsed)")
    Page<User> searchUsers(
            @Param("id") String id,
            @Param("name") String name,
            @Param("email") String email,
            @Param("isUsed") String isUsed,
            Pageable pageable
    );

    Optional<User> findById(String id);

    boolean existsById(String id);
    boolean existsByEmail(String email);
}

