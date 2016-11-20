package com.epam.fifth.validate;

import com.epam.fifth.handler.CandiesErrorHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    private static final Logger LOG = LogManager.getLogger();

    public static void validate(String filePath, String schemaPath) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(schemaPath);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filePath);
            validator.setErrorHandler(new CandiesErrorHandler());
            validator.validate(source);
            LOG.info("Validating is ended.");
        } catch (SAXException | IOException e) {
            LOG.log(Level.ERROR, e);
        }
    }
}
