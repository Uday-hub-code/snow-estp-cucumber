package com.disney.cast.platform.estp.ui.app.pages.components;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

public class HistoryEntitlementCard extends PageElement {
    private Supplier<WebElement> rewardTitle = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(getContextElement(),
                    By.cssSelector("[class*='medium vp-reward-title']")));

    private Supplier<WebElement> dates = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(getContextElement(),
                    By.cssSelector("[class*='vp-dates-container']")));

    private Supplier<WebElement> rewardSubTitle = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(getContextElement(), By.cssSelector(
                    "[class*='vp-reward-type vp-reward-type-and-prize'] p[class='b1 medium ng-binding']")));

    private Supplier<WebElement> rewardSubTitlePrize = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(getContextElement(), By.cssSelector(
                    "[class*='vp-reward-type vp-reward-type-and-prize'] p[class='b1 light ng-binding']")));

    private Supplier<List<WebElement>> data = () -> getContextElement()
            .findElements(By.cssSelector("[class='vp-valid-reward-info-box ng-scope'] .row .kng-list-item-row"));

    public HistoryEntitlementCard(WebElement contextLocatorElement) {
        super(contextLocatorElement);
    }

    public String getRewardTitle() {
        return rewardTitle.get().getText();
    }

    public String getDates() {
        return dates.get().getText();
    }

    public String getRewardSubTitle() {
        return rewardSubTitle.get().getText();
    }

    public String getRewardSubTitlePrize() {
        return rewardSubTitlePrize.get().getText();
    }

    public String getItemID() {
        return data.get().get(0).findElement(By.cssSelector(".kng-list-item-value")).getText();
    }

    public String getStatus() {
        return data.get().get(1).findElement(By.cssSelector(".kng-list-item-value")).getText();
    }

    public String getOrderedBy() {
        return data.get().get(2).findElement(By.cssSelector(".kng-list-item-value")).getText();
    }

}