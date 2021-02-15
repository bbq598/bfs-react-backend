package com.bfs.time_sheetserver.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
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
    private Integer floatingDay;
    private Integer floatDayLeft;

    public void setFloatingDay() {
        int n = 0;
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).isFloatingDate() == true) {
                n++;
            }
        }
        this.floatingDay = n;
    }

    public WeekSheet(String id, String userName, String weekEnding, Integer totalHour, String submissionStatus, String approvalStatus, String comment, List<Day> days) {
        this.id = id;
        this.userName = userName;
        this.weekEnding = weekEnding;
        this.totalHour = totalHour;
        this.submissionStatus = submissionStatus;
        this.approvalStatus = approvalStatus;
        this.comment = comment;
        this.days = days;
        this.setFloatingDay();
    }
}
