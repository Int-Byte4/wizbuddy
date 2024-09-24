package com.intbyte.wizbuddy.user.command.infrastructure.schedule.vo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseRegistWeeklyScheduleVO {
    private int scheduleCode;
    private boolean scheduleFlag;
    private LocalDate scheduleStartDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}