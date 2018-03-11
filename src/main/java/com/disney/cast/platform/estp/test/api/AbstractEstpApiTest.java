package com.disney.cast.platform.estp.test.api;

import java.net.MalformedURLException;

import com.disney.automation.servicetesting.core.AbstractApiTest;

import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author walter.finkbeiner
 */
public abstract class AbstractEstpApiTest extends AbstractApiTest {

    public AbstractEstpApiTest() throws MalformedURLException {
        super();
    }

    @Attachment(value = "JSON", type = "application/json")
    public String attachJson(String json) {
        return json;
    }

    @Attachment(value = "String", type = "text")
    public String attachString(String string) {
        return string;
    }

    @Override
    protected Object[] setAuthLevels() {
        return ApiAuthLevel.values();
    }

}
