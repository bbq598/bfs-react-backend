package com.bfs.time_sheet_coreserver.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "time_sheet")
public class WeekSheet {
    @Id
    private String id;
    private Boolean isDefault;
    private String userName;
    private String weekEnding;
    private Integer totalHour;
    private String submissionStatus;
    private String approvalStatus;
    private String comment;
    private List<Day> days;
}
