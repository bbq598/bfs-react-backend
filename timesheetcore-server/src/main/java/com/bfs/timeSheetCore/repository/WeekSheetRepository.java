package com.bfs.timeSheetCore.repository;

import com.bfs.timeSheetCore.model.WeekSheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeekSheetRepository extends MongoRepository<WeekSheet, Integer> {
    List<WeekSheet> findByUserName(String userName);
}
