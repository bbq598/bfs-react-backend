package com.bfs.timeSheetCore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "time_sheet")
public class WeekSheet {
    @Id
    private String id;
    private String userName;
    private String weekEnding;
    private Integer totalHour;
    private String submissionStatus;
    private String approvalStatus;
    private String comment;
    private List<Day> days;


}
