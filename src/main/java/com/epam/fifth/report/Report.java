package com.epam.fifth.report;


import com.epam.fifth.file.FileWorker;

import java.util.List;

public class Report {
    private static final String FILE_PATH = "data/report.txt";
    private static final String GIFT_TITLE = "------------------------ Candies ------------------------\n";
    private static final String ENDER = "------------------------------------------------------\n";
    private FileWorker worker;

    public Report() {
        this.worker = new FileWorker();
    }

    public void writeCandiesDataReport(List<String> data) {
        /*if (data == null) {
            throw new GiftLogicException("Gift data is null.");
        }*/

        worker.addDataToFile(FILE_PATH, GIFT_TITLE);
        worker.addLinesToFile(FILE_PATH, data);
        worker.addDataToFile(FILE_PATH, ENDER);
    }
}
