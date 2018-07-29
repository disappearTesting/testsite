package scanword_tests.unit_tests.sudoku;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

public class Unit_SudokuSolved_TestSuite {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            Unit_SudokuSolved_SudokuListData.class,
            Unit_SudokuSolved_Info.class
    })

    public class JunitTestSuite {

    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
