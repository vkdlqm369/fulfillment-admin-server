package com.daou.sabangnetserver.domain.user.repository;

import com.daou.sabangnetserver.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE " +
            "(:id IS NULL OR u.id = :id) AND " +
            "(:name IS NULL OR u.name LIKE %:name%) AND " +
            "(:email IS NULL OR u.email LIKE %:email%) AND " +
            "(:isUsed IS NULL OR u.isUsed = :isUsed)")
    Page<User> searchUsers(
            @Param("id") String id,
            @Param("name") String name,
            @Param("email") String email,
            @Param("isUsed") Boolean isUsed,
            Pageable pageable
    );
}

