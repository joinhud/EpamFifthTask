package com.epam.fifth.validate;

import org.junit.Assert;
import org.junit.Test;

public class XMLValidatorTest {

    @Test
    public void validateNullFileNameTest() {
        boolean actual = XMLValidator.validate(null, "data/candies.xsd");
        Assert.assertFalse(actual);
    }

    @Test
    public void validateNullSchemaNameTest() {
        boolean actual = XMLValidator.validate("data/candies.xsd", null);
        Assert.assertFalse(actual);
    }

    @Test
    public void validateIncorrectFileNameTest() {
        boolean actual = XMLValidator.validate("1234", "data/candies.xsd");
        Assert.assertFalse(actual);
    }

    @Test
    public void validateIncorrectSchemaNameTest() {
        boolean actual = XMLValidator.validate("data/candies.xml", "1234");
        Assert.assertFalse(actual);
    }

    @Test
    public void validateNotValidFileNameBySchemeNameTest() {
        boolean actual = XMLValidator.validate("data/test.xml", "data/candies.xsd");
        Assert.assertFalse(actual);
    }

    @Test
    public void validateCorrectParamsTest() {
        boolean actual = XMLValidator.validate("data/candies.xml", "data/candies.xsd");
        Assert.assertTrue(actual);
    }
}