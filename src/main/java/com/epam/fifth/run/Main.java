package com.epam.fifth.run;

import com.epam.fifth.builder.AbstractCandiesBuilder;
import com.epam.fifth.exception.CandiesBuilderFactoryException;
import com.epam.fifth.factory.CandiesBuilderFactory;
import com.epam.fifth.report.Report;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOG = LogManager.getLogger();

    private static final String CANDIES_FILE_XML = "data/candies.xml";
    private static final String CANDIES_FILE_XSD = "data/candies.xsd";

    private static final String SAX = "sax";
    private static final String STAX = "stax";
    private static final String DOM = "dom";

    public static void main(String[] args) {
        CandiesBuilderFactory factory = new CandiesBuilderFactory();
        Report report = new Report();

        try {
            AbstractCandiesBuilder builder = factory.createCandiesBuilder(SAX);
            builder.buildSetCandies(CANDIES_FILE_XML, CANDIES_FILE_XSD);
            report.writeCandiesDataReport(builder.getCandiesStrings());

            builder = factory.createCandiesBuilder(STAX);
            builder.buildSetCandies(CANDIES_FILE_XML, CANDIES_FILE_XSD);
            report.writeCandiesDataReport(builder.getCandiesStrings());

            builder = factory.createCandiesBuilder(DOM);
            builder.buildSetCandies(CANDIES_FILE_XML, CANDIES_FILE_XSD);
            report.writeCandiesDataReport(builder.getCandiesStrings());
        } catch (CandiesBuilderFactoryException e) {
            LOG.log(Level.ERROR, e);
        }
    }
}
