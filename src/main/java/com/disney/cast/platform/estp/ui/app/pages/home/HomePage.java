package com.disney.cast.platform.estp.ui.app.pages.home;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.estp.ui.app.pages.AbstractEstpPageObject;
import com.disney.cast.platform.estp.ui.app.pages.components.AlertMessageComponent;
import com.disney.cast.platform.estp.ui.app.pages.components.PerformanceHorizontalChart;

public class HomePage extends AbstractEstpPageObject {

    private Supplier<WebElement> centerText = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.center-text h3")));

    private Supplier<WebElement> welcomeSubHeadingDiv = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.center-text div[class*='welcome']")));

    private Supplier<WebElement> thisMonthsPerformance = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.row div[class*='month-performance']")));

    private Supplier<WebElement> viewFullPerformance = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.row div[class*='summary-link']")));

    private Supplier<WebElement> viewFullPerformanceLink = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(viewFullPerformance.get(), tagName("a")));

    private Supplier<WebElement> viewRewardHistory = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.row div[class*='past-redemptions']")));

    private Supplier<WebElement> viewRewardHistoryLink = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(viewRewardHistory.get(), tagName("a")));

    private AlertMessageComponent alertMessageComponent = new AlertMessageComponent(
            cssSelector("div[class='kng-alert ng-scope kng-alert-warning']"));

    public final PerformanceHorizontalChart performanceChart = new PerformanceHorizontalChart(
            cssSelector("[class*='white-kng-cards-lg kng-cards-vertical']"));

    public boolean isEntitlementListEmpty() {
        return getDriver().findElements(cssSelector("kng-cards[class*='recentRewards']")).isEmpty();
    }

    public AlertMessageComponent getAlertMessageComponent() {
        return alertMessageComponent;
    }

    public String getCenterText() {
        return centerText.get().getText();
    }

    public String getWelcomeSubHeading() {
        return welcomeSubHeadingDiv.get().getText();
    }

    public String getThisMonthsPerformance() {
        return thisMonthsPerformance.get().getText().split("\n")[0];
    }

    public String getViewFullPerformance() {
        return viewFullPerformance.get().getText();
    }

    public String getRewardHistory() {
        return viewRewardHistory.get().getText();
    }

    public void clickOnViewFullPerformance() {
        viewFullPerformanceLink.get().click();
        waitForLoad();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/wdpr-cast/x_wdtpa_wdpr_vacat_WDPR%20Vacation%20Planner%20Page.do#!/home";
    }

    @Override
    public void goToOwnUrl() {
        super.goToOwnUrl();
        waitForLoad();
    }

    public boolean isPageDisplayed() {
        return getDriver().getCurrentUrl().equals(this.getOwnUrl());
    }

    private void waitForLoad() {
        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-spinner")));
        waitFor(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".ng-animate"), 0));
    }
}