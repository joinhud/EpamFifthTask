package com.epam.fifth.builder;

import com.epam.fifth.entity.Candy;
import com.epam.fifth.entity.Chocolate;
import com.epam.fifth.entity.Sweet;
import com.epam.fifth.type.CandyEnum;
import com.epam.fifth.type.ChocolateColor;
import com.epam.fifth.type.SweetType;
import com.epam.fifth.validate.XMLValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CandiesDOMBuilder {
    private static final Logger LOG = LogManager.getLogger();

    private Set<Candy> candies;
    private DocumentBuilder docBuilder;

    public CandiesDOMBuilder() {
        candies = new HashSet<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.log(Level.ERROR, e);
        }
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public List<String> getCandiesStrings() {
        return candies.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public void buildSetCandies(String fileName, String schemaName) {
        Document doc = null;
        XMLValidator.validate(fileName, schemaName);
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList sweetList = root.getElementsByTagName(CandyEnum.SWEET.getValue());
            NodeList chocolateList = root.getElementsByTagName(CandyEnum.CHOCOLATE.getValue());

            for (int i = 0; i < sweetList.getLength(); i++) {
                Element sweetElement = (Element) sweetList.item(i);
                Sweet sweet = buildSweet(sweetElement);
                candies.add(sweet);
            }

            for (int i = 0; i < chocolateList.getLength(); i++) {
                Element chocolateElement  = (Element) chocolateList.item(i);
                Chocolate chocolate = buildChocolate(chocolateElement);
                candies.add(chocolate);
            }
        } catch (SAXException | IOException e) {
            LOG.log(Level.ERROR, e);
        }
    }

    private Sweet buildSweet(Element sweetElement) {
        Sweet sweet = new Sweet();

        sweet.setName(sweetElement.getAttribute(CandyEnum.NAME.getValue()));
        Double energy = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.ENERGY.getValue()));
        sweet.setEnergy(energy);

        Double proteins = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.PROTEINS.getValue()));
        Double fats = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.FATS.getValue()));
        Double carbohydrates =
                Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.CARBOHYDRATES.getValue()));
        sweet.getValue().setProteins(proteins);
        sweet.getValue().setFats(fats);
        sweet.getValue().setCarbohydrates(carbohydrates);

        sweet.setProduction(getElementTextContent(sweetElement, CandyEnum.PRODUCTION.getValue()));
        sweet.setType(SweetType.valueOf(getElementTextContent(sweetElement, CandyEnum.TYPE.getValue()).toUpperCase()));

        Double water = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.WATER.getValue()));
        Double sugar = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.SUGAR.getValue()));
        Double fructose = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.FRUCTOSE.getValue()));
        Double vanilla = Double.parseDouble(getElementTextContent(sweetElement, CandyEnum.VANILLA.getValue()));
        sweet.getIngredients().setWater(water);
        sweet.getIngredients().setSugar(sugar);
        sweet.getIngredients().setFructose(fructose);
        sweet.getIngredients().setVanilla(vanilla);

        return sweet;
    }

    private Chocolate buildChocolate(Element chocolateElement) {
        Chocolate chocolate = new Chocolate();

        chocolate.setName(chocolateElement.getAttribute(CandyEnum.NAME.getValue()));
        Double energy = Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.ENERGY.getValue()));
        chocolate.setEnergy(energy);

        Double proteins = Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.PROTEINS.getValue()));
        Double fats = Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.FATS.getValue()));
        Double carbohydrates =
                Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.CARBOHYDRATES.getValue()));
        chocolate.getValue().setProteins(proteins);
        chocolate.getValue().setFats(fats);
        chocolate.getValue().setCarbohydrates(carbohydrates);

        chocolate.setProduction(getElementTextContent(chocolateElement, CandyEnum.PRODUCTION.getValue()));
        String chocolateColorType = getElementTextContent(chocolateElement, CandyEnum.COLOR.getValue()).toUpperCase();
        chocolate.setColor(ChocolateColor.valueOf(chocolateColorType));

        Double cocoaMass = Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.COCOA_MASS.getValue()));
        Double sugar = Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.SUGAR.getValue()));
        Double cocoaButter =
                Double.parseDouble(getElementTextContent(chocolateElement, CandyEnum.COCOA_BUTTER.getValue()));

        chocolate.getIngredients().setCocoaMass(cocoaMass);
        chocolate.getIngredients().setSugar(sugar);
        chocolate.getIngredients().setCocoaButter(cocoaButter);

        return chocolate;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
