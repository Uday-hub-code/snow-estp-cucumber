package com.disney.cast.platform.estp.ui.app.pages;

import static org.openqa.selenium.By.cssSelector;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.cast.platform.estp.ui.app.pages.components.TitleBarComponent;

public abstract class AbstractEstpPageObject extends PageObject {

    public final TitleBarComponent titleBarComponent = new TitleBarComponent(cssSelector(".kng-header"));

    public AbstractEstpPageObject() {
        super();
    }

    public TitleBarComponent getTitleBarComponent() {
        return titleBarComponent;
    }

}
