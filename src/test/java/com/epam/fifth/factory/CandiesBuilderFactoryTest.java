package com.epam.fifth.factory;

import com.epam.fifth.builder.AbstractCandiesBuilder;
import com.epam.fifth.exception.CandiesBuilderFactoryException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CandiesBuilderFactoryTest {
    private static CandiesBuilderFactory factory;

    @BeforeClass
    public static void initFactory() {
        factory = new CandiesBuilderFactory();
    }

    @Test(expected = CandiesBuilderFactoryException.class)
    public void createCandiesBuilderNullParamTest() throws CandiesBuilderFactoryException {
        AbstractCandiesBuilder actual = factory.createCandiesBuilder(null);
        Assert.assertNull(actual);
    }

    @Test(expected = CandiesBuilderFactoryException.class)
    public void createCandiesBuilderIncorrectParamTest() throws CandiesBuilderFactoryException {
        AbstractCandiesBuilder actual = factory.createCandiesBuilder("wax");
        Assert.assertNull(actual);
    }

    @Test
    public void createCandiesBuilderCorrectParamTest() throws CandiesBuilderFactoryException {
        AbstractCandiesBuilder actual = factory.createCandiesBuilder("dom");
        Assert.assertNotNull(actual);
    }
}