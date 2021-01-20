package com.example.repository;

import com.example.model.PageVisitCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageVisitCounterRepository extends JpaRepository<PageVisitCounter, Long> {
}
