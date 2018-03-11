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

    private static AlertDataManager ALERT_DATA_MANAGER;
    private static PayrollDataManager PAYROLL_DATA_MANAGER;
    private static UserDataManager USER_DATA_MANAGER;
    private static UIUserDataManager UI_USER_DATA_MANAGER;
    private static FeatureDataManager FEATURE_DATA_MANAGER;

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

    public static AlertDataManager getAlertDataManager() {
        if (ALERT_DATA_MANAGER == null) {
            try {
                ALERT_DATA_MANAGER = new AlertDataManager();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ALERT_DATA_MANAGER;
    }

    public static FeatureDataManager getFeatureDataManager() throws IOException {
        if (FEATURE_DATA_MANAGER == null) {
            FEATURE_DATA_MANAGER = new FeatureDataManager();
        }
        return FEATURE_DATA_MANAGER;
    }

}
