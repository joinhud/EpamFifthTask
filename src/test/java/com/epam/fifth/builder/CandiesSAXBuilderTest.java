package com.epam.fifth.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandiesSAXBuilderTest {
    private static CandiesSAXBuilder builder;

    @Before
    public void initSAXBuilder() {
        builder = new CandiesSAXBuilder();
    }

    @Test
    public void buildSetCandiesNullFileNameTest() {
        builder.buildSetCandies(null, "data/candies.xsd");
        double expected = 0;
        double actual = builder.getCandies().size();
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void buildSetCandiesNullSchemaNameTest() {
        builder.buildSetCandies("data/candies.xml", null);
        double expected = 0;
        double actual = builder.getCandies().size();
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void buildSetCandiesIncorrectFileNameTest() {
        builder.buildSetCandies("test_data.xml", "data/candies.xsd");
        double expected = 0;
        double actual = builder.getCandies().size();
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void buildSetCandiesIncorrectSchemaNameTest() {
        builder.buildSetCandies("data/candies.xml", "test_data.xsd");
        double expected = 0;
        double actual = builder.getCandies().size();
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void buildSetCandiesCorrectParamsTest() {
        builder.buildSetCandies("data/candies.xml", "data/candies.xsd");
        double expected = 2;
        double actual = builder.getCandies().size();
        Assert.assertEquals(expected, actual, 0.1);
    }
}