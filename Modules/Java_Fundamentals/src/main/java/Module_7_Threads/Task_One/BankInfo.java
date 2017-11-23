package Module_7_Threads.Task_One;

import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class BankInfo {

    private static String filepath = "./src/main/resources/BankInfo.xml";


    public static Account[] getBankAccounts() {
        Account account[];
        File xmlFile = new File(filepath);
        DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
            Document doc = xmlBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("account");
            if (nodeList.getLength() == 0) {
                return new Account[0];
            }
            account = new Account[nodeList.getLength()];
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    account[i] = new Account().setAccountId(element.getAttribute("id"))
                            .setFirstName(element.getElementsByTagName("first").item(0).getTextContent())
                            .setLastName(element.getElementsByTagName("last").item(0).getTextContent())
                            .setBalance(Integer.valueOf(element.getElementsByTagName("balance").item((0)).getTextContent()));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return new Account[0];
        }

        return account;
    }


    public static Transaction[] getTransactions() {
        Transaction transaction[];
        File xmlFile = new File(filepath);
        DocumentBuilderFactory xmlFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
            Document doc = xmlBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("transaction");
            if (nodeList.getLength() == 0) {
                return new Transaction[0];
            }
            transaction = new Transaction[nodeList.getLength()];
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    transaction[i] = new Transaction().setTransactionId(element.getAttribute("id"))
                            .setAccountId_from(element.getElementsByTagName("from").item(0).getTextContent())
                            .setAccountId_to(element.getElementsByTagName("to").item(0).getTextContent())
                            .setAmmount(Integer.valueOf(element.getElementsByTagName("ammount").item(0).getTextContent()));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return new Transaction[0];
        }

        return transaction;

    }


}
