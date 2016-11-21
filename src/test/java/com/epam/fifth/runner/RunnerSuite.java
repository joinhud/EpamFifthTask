package com.epam.fifth.runner;

import com.epam.fifth.builder.CandiesDOMBuilderTest;
import com.epam.fifth.builder.CandiesSAXBuilderTest;
import com.epam.fifth.builder.CandiesStAXBuilderTest;
import com.epam.fifth.factory.CandiesBuilderFactoryTest;
import com.epam.fifth.validate.XMLValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({XMLValidatorTest.class, CandiesBuilderFactoryTest.class,
        CandiesDOMBuilderTest.class, CandiesSAXBuilderTest.class, CandiesStAXBuilderTest.class})
@RunWith(Suite.class)
public class RunnerSuite {
}
