package scanword_tests.unit_tests.cross;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

public class Unit_CrossSolved_TestSuite {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            Unit_CrossSolved_CrossListData.class,
            //Unit_CrossSolved_Info.class,
            Unit_CrossSolved_Sync.class
    })

    public class JunitTestSuite {

    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Unit_CrossSolved_TestSuite.JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
