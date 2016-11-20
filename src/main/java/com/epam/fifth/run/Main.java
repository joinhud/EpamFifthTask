package com.epam.fifth.run;

import com.epam.fifth.builder.CandiesDOMBuilder;
import com.epam.fifth.builder.CandiesSAXBuilder;
import com.epam.fifth.builder.CandiesStAXBuilder;
import com.epam.fifth.report.Report;

public class Main {
    private static final String CANDIES_XML = "data/candies.xml";
    private static final String CANDIES_XSD = "data/candies.xsd";

    public static void main(String[] args) {
//        CandiesSAXBuilder saxBuilder = new CandiesSAXBuilder();
//        saxBuilder.buildSetCandies(CANDIES_XML, CANDIES_XSD);
//        Report report = new Report();
//        report.writeCandiesDataReport(saxBuilder.getCandiesStrings());

        /*CandiesDOMBuilder domBuilder = new CandiesDOMBuilder();
        domBuilder.buildSetCandies(CANDIES_XML, CANDIES_XSD);
        Report report = new Report();
        report.writeCandiesDataReport(domBuilder.getCandiesStrings());*/

        CandiesStAXBuilder builder = new CandiesStAXBuilder();
        builder.buildSetCandies(CANDIES_XML);
        Report report = new Report();
        report.writeCandiesDataReport(builder.getCandiesStrings());
    }
}
