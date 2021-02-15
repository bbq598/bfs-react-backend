package com.bfs.time_sheet_coreserver.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "time_sheet")
public class WeekSheet implements Comparable{
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

    @Override
    public int compareTo(Object weekSheet) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate thisDate = LocalDate.parse(this.getWeekEnding(), formatter);
        WeekSheet w = (WeekSheet)weekSheet;
        LocalDate weekSheetDate = LocalDate.parse(w.getWeekEnding(), formatter);
        return thisDate.compareTo(weekSheetDate);
    }


}
