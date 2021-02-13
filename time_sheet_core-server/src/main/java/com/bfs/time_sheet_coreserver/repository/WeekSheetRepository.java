package com.bfs.time_sheet_coreserver.repository;

import com.bfs.time_sheet_coreserver.model.WeekSheet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeekSheetRepository extends MongoRepository<WeekSheet, Integer> {
    List<WeekSheet> findByUserName(String userName);

    WeekSheet findFirst1ByUserNameAndIsDefault(String userName, boolean isDefault);
}
