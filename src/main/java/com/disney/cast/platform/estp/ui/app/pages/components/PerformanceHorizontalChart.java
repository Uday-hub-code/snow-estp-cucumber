package com.disney.cast.platform.estp.ui.app.pages.components;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

public class PerformanceHorizontalChart extends PageElement {
    private final Supplier<WebElement> centerTextRewardLevelTitle;
    private final Supplier<LevelNGScope> levelNGScope;

    public PerformanceHorizontalChart(By contextElement) {
        super(contextElement);
        centerTextRewardLevelTitle = () -> waitFor(ExpectedConditions.presenceOfNestedElementLocatedBy(
                getContextLocator(), By.cssSelector("div.h4.book.center-text.reward-level-title.ng-scope > span")));
        levelNGScope = () -> new LevelNGScope();
    }

    public String getCenterRewardLevelTitle() {
        return centerTextRewardLevelTitle.get().getText();
    }

    public String getActiveLevel() {
        return levelNGScope.get().getActiveLevel().toString();
    }

    public enum Level {
        BRONZE, SILVER, GOLD, FAILURE
    }

    private static class LevelNGScope {
        private final LevelElement bronze = new LevelElement(By.cssSelector(".levelContainerLeft"));
        private final LevelElement silver = new LevelElement(By.cssSelector(".levelContainerCenter"));
        private final LevelElement gold = new LevelElement(By.cssSelector(".levelContainerRight"));

        public Level getActiveLevel() {
            return getActiveLevel(bronze, silver, gold);
        }

        private Level getActiveLevel(LevelElement... levelElements) {
            for (LevelElement levelElement : levelElements) {
                if (levelElement.isLevelActive()) {
                    return Level.valueOf(levelElement.getLevelText().toUpperCase());
                }
            }
            return Level.FAILURE;
        }

        public static class LevelElement extends PageElement {
            private Supplier<WebElement> iconLevel = () -> waitFor(ExpectedConditions
                    .presenceOfNestedElementLocatedBy(getContextLocator(), By.cssSelector("div")));
            private Supplier<WebElement> level = () -> waitFor(ExpectedConditions
                    .presenceOfNestedElementLocatedBy(getContextLocator(),
                            By.cssSelector("h4")));

            protected LevelElement(By contextLocator) {
                super(contextLocator);
            }

            public boolean isLevelActive() {
                return !iconLevel.get().getAttribute("class").contains("inactive");
            }

            public String getLevelText() {
                return level.get().getText();
            }
        }
    }
}
