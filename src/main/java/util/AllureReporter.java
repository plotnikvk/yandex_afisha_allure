package util;

import gherkin.formatter.model.*;
import io.qameta.allure.cucumberjvm.AllureCucumberJvm;
import steps.BaseSteps;
/**
 * * Created by plotnikvk
 */

public class AllureReporter extends AllureCucumberJvm {
    @Override
    public void result(final Result result) {
        if (result.getStatus().equals("failed")){
            BaseSteps.takeScreenshot();
        }
        super.result(result);
    }
}
