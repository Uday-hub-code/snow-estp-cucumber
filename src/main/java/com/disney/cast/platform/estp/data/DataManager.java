package com.disney.cast.platform.estp.data;

import java.io.IOException;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import com.disney.automation.webframework.logging.Logging;

/**
 * @author walter.finkbeiner
 */
public class DataManager implements MethodRule, Logging {

    public static AlertDataManager ALERT_DATA_MANAGER;
    public static PayrollDataManager PAYROLL_DATA_MANAGER;
    public static UserDataManager USER_DATA_MANAGER;
    public static UIUserDataManager UI_USER_DATA_MANAGER;

    @Override
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                try {
                    ALERT_DATA_MANAGER = new AlertDataManager();
                    PAYROLL_DATA_MANAGER = new PayrollDataManager();
                    USER_DATA_MANAGER = new UserDataManager();
                    UI_USER_DATA_MANAGER = new UIUserDataManager();
                } catch (IOException ioe) {
                    getLogger().error(ioe.getLocalizedMessage(), ioe);
                }
                base.evaluate();
            }
        };
    }
}
