package service.generate;

import entity.AthleteResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import service.GenerateFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GenerateFileXml implements GenerateFile {

    @Override
    public void generate(List<AthleteResult> results) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("athletes");
            doc.appendChild(rootElement);


            for (AthleteResult result: results) {

                Element athlete = doc.createElement("athlete");
                rootElement.appendChild(athlete);

                athlete.setAttribute("name", result.getName());

                athlete.appendChild(createElement(doc, "rank", result.getRanking() + ""));
                athlete.appendChild(createElement(doc, "score", result.getScore() + ""));
            }

            saveFile(doc);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private Element createElement(Document doc, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    private void saveFile(Document document) throws TransformerException, IOException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        File tempFile = File.createTempFile("decathlon.", ".result");
        StreamResult result = new StreamResult(tempFile);

        transformer.transform(source, result);
    }

}
