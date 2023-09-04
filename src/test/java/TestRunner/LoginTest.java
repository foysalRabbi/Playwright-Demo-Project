package TestRunner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

    @Suite
    @IncludeEngines("cucumber")
    @SelectClasspathResource("features/TC_01_Login.feature")

    public class LoginTest{

    }
