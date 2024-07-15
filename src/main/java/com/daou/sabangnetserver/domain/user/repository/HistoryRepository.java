package com.daou.sabangnetserver.domain.user.repository;

import com.daou.sabangnetserver.domain.user.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("SELECT h.loginTime, u.name, u.id, h.loginDevice, h.loginIp " +
            "FROM History h " +
            "INNER JOIN User u ON u.userId = h.userId " +
            "WHERE (:id = '' OR u.id = :id) AND " +
            "(:name = '' OR u.name LIKE %:name%)")
    Page<Object[]> searchHistorys(
            @Param("id") String id,
            @Param("name") String name,
            Pageable pageable
    );

}
