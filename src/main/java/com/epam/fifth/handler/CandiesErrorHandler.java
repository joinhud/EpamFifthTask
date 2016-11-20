package com.epam.fifth.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class CandiesErrorHandler extends DefaultHandler {
    private static final Logger LOG = LogManager.getLogger();

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        LOG.warn(getLineAddress(e) + " - " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        LOG.error(getLineAddress(e) + " - " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        LOG.fatal(getLineAddress(e) + " - " + e.getMessage());
    }
}
