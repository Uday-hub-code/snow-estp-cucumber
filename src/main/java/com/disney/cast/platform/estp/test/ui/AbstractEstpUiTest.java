package com.disney.cast.platform.estp.test.ui;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.disney.automation.webframework.tests.JUnit4WebDriverTest;
import com.disney.automation.webframework.visual.Ocular;
import com.disney.automation.webframework.webdriver.Drivers;

import ru.yandex.qatools.allure.annotations.Attachment;

public abstract class AbstractEstpUiTest extends JUnit4WebDriverTest {

    public AbstractEstpUiTest() throws MalformedURLException {
        super();
        ocularConfig();
    }

    private void ocularConfig() {
        File resultFolder = new File("./target/result");
        File snapshotFolder = new File("./target/snapshot");

        if (!resultFolder.exists()) {
            resultFolder.mkdir();
        }

        if (!snapshotFolder.exists()) {
            snapshotFolder.mkdir();
        }

        Ocular
                .config()
                .resultPath(Paths.get("./target/result"))
                .snapshotPath(Paths.get("./target/snapshot"))
                .globalSimilarity(95)
                .saveSnapshot(true);
    }

    @Attachment("Screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) Drivers.INSTANCE.get()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment("Result")
    public String attachResultImage() {
        return "./target/result/Login.png";
    }

    @Override
    protected Object[] setAuthLevels() {
        return UiAuthLevel.values();
    }

}
