package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
