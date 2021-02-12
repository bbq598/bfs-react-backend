package com.bfs.time_sheetserver.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeekSheet {
    private String id;
    private String userName;
    private String weekEnding;
    private Integer totalHour;
    private String submissionStatus;
    private String approvalStatus;
    private String comment;
    private List<Day> days;

}
