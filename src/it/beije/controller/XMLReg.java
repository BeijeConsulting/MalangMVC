package it.beije.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class XMLReg {
 
    public static final String xmlFilePath = "C:\\temp\\XMLContainer.xml";
 
        	public static void addXMLContact(String cognome, String nome, String email, String telefono) throws SAXException, IOException {
        try {
        	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document1 =documentBuilder.parse(new File(xmlFilePath));
            Document document = documentBuilder.newDocument();
            
            Element e = document1.getDocumentElement();	        
	        //System.out.println(element.getTagName());     
	        	        
			NodeList nodeList = e.getElementsByTagName("Contatto");
			System.out.println("contatto num : " + nodeList.getLength());
			Element root = document.createElement("Rubrica");
        	document.appendChild(root);
        	if (nodeList.getLength()!=0)
        	{
			for (int i = 0; i < nodeList.getLength(); i++) {
	        	e = (Element)nodeList.item(i);
	        	//System.out.println(e.getTagName());
	        	
	        	
	        	Element employee = document.createElement("Contatto");
	        	 
	            root.appendChild(employee);
	            Attr attr = document.createAttribute("id");
	            attr.setValue(String.valueOf(i));
	            employee.setAttributeNode(attr);
	            
	            NodeList nomi = e.getElementsByTagName("Cognome");
	            Element firstName = document.createElement("Cognome");
	            firstName.appendChild(document.createTextNode(nomi.item(0).getTextContent()));
	            employee.appendChild(firstName);
	        	
	        	NodeList cognomi = e.getElementsByTagName("Nome");
	        	Element lastName = document.createElement("Nome");
	            lastName.appendChild(document.createTextNode(cognomi.item(0).getTextContent()));
	            employee.appendChild(lastName);
	            
	        	NodeList emails = e.getElementsByTagName("Email");
	        	Element ema = document.createElement("Email");
	            ema.appendChild(document.createTextNode(emails.item(0).getTextContent()));
	            employee.appendChild(ema);
	            
	        	NodeList telefoni = e.getElementsByTagName("Telefono");
	        	Element tel = document.createElement("Telefono");
	            tel.appendChild(document.createTextNode(telefoni.item(0).getTextContent()));
	            employee.appendChild(tel);

	        }}
            // root element
			int j=nodeList.getLength();
 
            // employee element
            Element employee = document.createElement("Contatto");
            root.appendChild(employee);
 
            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue(String.valueOf(j));
            employee.setAttributeNode(attr);
 
            //you can also use staff.setAttribute("id", "1") for this
 
            // firstname element
            Element firstName = document.createElement("Cognome");
            firstName.appendChild(document.createTextNode(cognome));
            employee.appendChild(firstName);
 
            // lastname element
            Element lastname = document.createElement("Nome");
            lastname.appendChild(document.createTextNode(nome));
            employee.appendChild(lastname);
 
            // email element
            Element ema = document.createElement("Email");
            ema.appendChild(document.createTextNode(email));
            employee.appendChild(ema);
 
            // department elements
            Element department = document.createElement("Telefono");
            department.appendChild(document.createTextNode(telefono));
            employee.appendChild(department);
 
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
 
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            System.out.println("Done creating XML File");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
}
}