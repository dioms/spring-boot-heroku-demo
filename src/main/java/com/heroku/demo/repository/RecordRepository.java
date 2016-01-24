package com.heroku.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroku.demo.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
