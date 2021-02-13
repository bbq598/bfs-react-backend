package com.bfs.time_sheet_coreserver.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "time_sheet")
public class Day {
    private String date;
    private String start;
    private String end;
    private boolean isFloatingDate;
    private boolean isHoliday;
    private boolean isVacation;
}
