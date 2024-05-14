package com.chat360.assignment.controller;

import com.chat360.assignment.enums.LogLevel;
import com.chat360.assignment.model.Log;
import com.chat360.assignment.service.LogIngestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LogQueryController {

    @Autowired
    private LogIngestor logIngestor;

    @GetMapping("/logs")
    public List<Log> getLogs(
            @RequestParam(required = false) String level,
            @RequestParam String source,
            @RequestParam(required = false) LocalDateTime startTime,
            @RequestParam(required = false) LocalDateTime endTime
    ) {
        List<Log> logs = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(source + ".log"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                LocalDateTime logTime = LocalDateTime.parse(parts[0]);
                String logLevel = parts[1];
                String logSource = parts[2];
                String logMessage = parts[3];

                boolean levelMatch = (level == null || logLevel.equals(level));
                boolean sourceMatch = (source == null || logSource.equals(source));
                boolean timeMatch = (startTime == null || logTime.isAfter(startTime)) &&
                        (endTime == null || logTime.isBefore(endTime));

                if (levelMatch && sourceMatch && timeMatch) {
                    logs.add(new Log(logTime, LogLevel.valueOf(logLevel),logSource,logMessage));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }
}

