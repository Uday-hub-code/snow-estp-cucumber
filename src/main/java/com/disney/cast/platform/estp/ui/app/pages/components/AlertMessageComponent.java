package com.disney.cast.platform.estp.ui.app.pages.components;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

public class AlertMessageComponent extends PageElement {

    public AlertMessageComponent(By contextLocator) {
        super(contextLocator);
    }

    public Supplier<WebElement> alertContent = () -> waitFor(ExpectedConditions
            .presenceOfNestedElementLocatedBy(getContextLocator(), By.cssSelector("div.kng-alert-content")));

    public Supplier<WebElement> alertContentIcon = () -> waitFor(ExpectedConditions
            .presenceOfNestedElementLocatedBy(getContextLocator(), By.cssSelector("div.kng-alert-content h4")));
    public Supplier<WebElement> alertContentText = () -> waitFor(ExpectedConditions
            .presenceOfNestedElementLocatedBy(getContextLocator(),
                    By.cssSelector("div.kng-alert-content>div.ng-binding")));

    public boolean isAlertIconVisible() {
        return alertContentIcon.get().getAttribute("class").equals("alert-icon");
    }

    public String getTextFromAlertMessage() {
        return alertContentText.get().getText();
    }

}
