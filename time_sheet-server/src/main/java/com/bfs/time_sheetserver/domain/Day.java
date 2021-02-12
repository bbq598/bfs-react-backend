package com.bfs.time_sheetserver.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Day {
    private String date;
    private String start;
    private String end;
    private boolean isFloatingDate;
    private boolean isHoliday;
    private boolean isVacation;
}
