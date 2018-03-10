package com.disney.cast.platform.estp.ui.app.pages.components;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

/**
 * @author jose.oropeza
 */
public class TitleBarComponent extends PageElement {

    private Supplier<WebElement> title = () -> waitFor(ExpectedConditions
            .presenceOfNestedElementLocatedBy(getContextLocator(),
                    By.cssSelector("div[class*='kng-header-title']")));

    private Supplier<WebElement> mainMenuButton = () -> {
        waitFor(ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(),
                By.cssSelector("i[class*='kng-icon kng-icon-menu']")));
        return waitFor(ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(),
                By.cssSelector("i[class*='kng-icon kng-icon-menu']")));
    };

    public TitleBarComponent(By contextLocator) {
        super(contextLocator);
    }

    public String getTitle() {
        return title.get().getText();
    }

}
