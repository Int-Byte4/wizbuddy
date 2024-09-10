package com.intbyte.wizbuddy.like.command.domain.entity.vo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RequestInsertManualBoardLikeVO {
    private LocalDateTime createdAt;
    private int manualCode;
    private int shopCode;
    private String employeeCode;
}