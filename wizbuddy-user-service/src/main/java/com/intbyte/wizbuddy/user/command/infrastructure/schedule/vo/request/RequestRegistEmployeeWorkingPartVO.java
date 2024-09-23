package com.intbyte.wizbuddy.user.command.infrastructure.schedule.vo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestRegistEmployeeWorkingPartVO {
    private String employeeCode;
    private int scheduleCode;
    private LocalDateTime workingDate;
    private String workingPartTime;
}
