package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Task;
import com.exo1.exo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT DISTINCT t FROM Task t " +
            "LEFT JOIN FETCH t.projet p " +
            "LEFT JOIN FETCH t.user u")
    List<Task> findAll();

    @Query("SELECT t FROM Task t " +
            "LEFT JOIN FETCH t.user u " +
            "LEFT JOIN FETCH t.projet p " +
            "WHERE t.id = :id"
    )
    Optional<Task> findById(@Param("id") Long id);

}
