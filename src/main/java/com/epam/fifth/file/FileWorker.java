package com.epam.fifth.file;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWorker {

    private static final Logger LOG = LogManager.getRootLogger();

    public void addLinesToFile(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            LOG.log(Level.FATAL, e);
            throw new RuntimeException();
        }
    }

    public void addDataToFile(String path, String data) {
        try {
            Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            LOG.log(Level.FATAL, e);
            throw new RuntimeException();
        }
    }

}
