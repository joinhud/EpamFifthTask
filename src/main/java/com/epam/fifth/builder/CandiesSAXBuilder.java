package com.epam.fifth.builder;

import com.epam.fifth.entity.Candy;
import com.epam.fifth.handler.CandyHandler;
import com.epam.fifth.validate.XMLValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CandiesSAXBuilder extends AbstractCandiesBuilder {
    private static final Logger LOG = LogManager.getLogger();

    private CandyHandler handler;
    private XMLReader reader;

    public CandiesSAXBuilder() {
        handler = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOG.log(Level.ERROR, e);
        }
    }

    @Override
    public void buildSetCandies(String fileName, String schemaName) {
        XMLValidator.validate(fileName, schemaName);
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            LOG.log(Level.ERROR, e);
        }
        candies = handler.getCandies();
    }
}
