package com.disney.cast.platform.estp.test.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.disney.automation.webframework.tests.JUnit4WebDriverTest;
import com.disney.automation.webframework.visual.Ocular;
import com.disney.automation.webframework.webdriver.Drivers;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import ru.yandex.qatools.allure.annotations.Attachment;

public abstract class AbstractEstpUiTest extends JUnit4WebDriverTest {

    private static final String SNAPSHOT_FOLDER = "./target/snapshot";
    private static final String RESULT_FOLDER = "./target/result";

    public AbstractEstpUiTest() throws MalformedURLException {
        super();
        ocularConfig();
    }

    private void ocularConfig() {
        File resultFolder = new File(RESULT_FOLDER);
        File snapshotFolder = new File(SNAPSHOT_FOLDER);

        if (!resultFolder.exists()) {
            resultFolder.mkdirs();
        }

        if (!snapshotFolder.exists()) {
            snapshotFolder.mkdirs();
        }

        Ocular
                .config()
                .resultPath(Paths.get(RESULT_FOLDER))
                .snapshotPath(Paths.get(SNAPSHOT_FOLDER))
                .globalSimilarity(95)
                .saveSnapshot(true);
    }

    @Attachment("Screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) Drivers.INSTANCE.get()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment("Comparison")
    public byte[] attachResultImage(String name) {
        File image = new File(RESULT_FOLDER + "/" + name + ".png");
        try {
            return Files.readAllBytes(image.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Attachment("Expected")
    public byte[] attachSnapshotImage(String name) {
        File image = new File(SNAPSHOT_FOLDER + "/" + name + ".png");
        try {
            return Files.readAllBytes(image.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @After("@Visual")
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.write("Test failed and enter hook");
        } else {
            scenario.write("Test not failed and enter hook");
        }
        System.out.println("Finished running scenario: " + scenario.getName());
    }

    @Override
    protected Object[] setAuthLevels() {
        return UiAuthLevel.values();
    }

}
