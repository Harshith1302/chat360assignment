package com.chat360.assignment.model;

import com.chat360.assignment.enums.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Log {
    private LocalDateTime timestamp;
    private LogLevel level;
    private String source;
    private String message;

    public Log(LogLevel level, String message, String source){
        this.message = message;
        this.level = level;
        this.timestamp = LocalDateTime.now();
        this.source = source;
    }

}
