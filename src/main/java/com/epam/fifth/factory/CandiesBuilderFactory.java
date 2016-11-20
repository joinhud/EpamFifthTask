package com.epam.fifth.factory;

import com.epam.fifth.builder.AbstractCandiesBuilder;
import com.epam.fifth.builder.CandiesDOMBuilder;
import com.epam.fifth.builder.CandiesSAXBuilder;
import com.epam.fifth.builder.CandiesStAXBuilder;
import com.epam.fifth.exception.CandiesBuilderFactoryException;

public class CandiesBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractCandiesBuilder createCandiesBuiler(String typeParser) throws CandiesBuilderFactoryException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());

        switch (type) {
            case DOM:
                return new CandiesDOMBuilder();
            case SAX:
                return new CandiesSAXBuilder();
            case STAX:
                return new CandiesStAXBuilder();
            default:
                throw new CandiesBuilderFactoryException("Unknown type of builder.");
        }
    }
}
