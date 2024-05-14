package com.chat360.assignment.service;
import com.chat360.assignment.model.Log;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class LogIngestor {
    public void log(Log log) {
        String logStr = String.format("%s - %s - %s - %s\n", log.getTimestamp(), log.getLevel(), log.getSource(), log.getMessage());
        try {
            FileWriter fileWriter = new FileWriter(log.getSource() + ".log", true);
            fileWriter.write(logStr);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

