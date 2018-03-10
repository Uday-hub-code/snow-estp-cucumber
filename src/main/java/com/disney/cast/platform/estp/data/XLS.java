package com.disney.cast.platform.estp.data;

import static java.lang.Thread.currentThread;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.disney.automation.servicetesting.logging.Logging;

public enum XLS implements Logging {

    VACATION_PLANNER_REWARDS("estp.xlsx");

    private final XSSFWorkbook workBook;

    XLS(String fileName) {
        XSSFWorkbook temp = null;
        try {
            temp = new XSSFWorkbook(currentThread().getContextClassLoader().getResource(fileName).getFile());
        } catch (IOException e) {
            getLogger().error(e.getLocalizedMessage(), e);
        }
        this.workBook = temp;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (workBook != null) {
                    workBook.close();
                }
            } catch (IOException e) {
                getLogger().error(e.getLocalizedMessage(), e);
            }
        }));
    }

    public XSSFWorkbook get() {
        return workBook;
    }
}