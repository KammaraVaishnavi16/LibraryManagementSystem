package com.application.libraryManagementSystem.repository;

import com.application.libraryManagementSystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
