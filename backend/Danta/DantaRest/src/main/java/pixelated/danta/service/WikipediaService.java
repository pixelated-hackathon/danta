/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Repository;
import org.w3c.dom.NodeList;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.danta.service.logic.ErrorHandler;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class WikipediaService {

    public String getWikipediaPage(String pageTitle) {
        try {
            String content = this.executeRequest(pageTitle);
            String extractContext = null;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            ByteArrayInputStream stream = new ByteArrayInputStream(content.getBytes("UTF-8"));
            Document doc = dBuilder.parse(stream);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("api");
            if (nList.getLength() > 0) {
                nList = doc.getElementsByTagName("query");
                if (nList.getLength() > 0) {
                    nList = doc.getElementsByTagName("pages");
                    if (nList.getLength() > 0) {
                        nList = doc.getElementsByTagName("page");
                        if (nList.getLength() > 0) {
                            nList = doc.getElementsByTagName("extract");
                            if (nList.getLength() > 0) {
                                extractContext = nList.item(0).getTextContent();
                                extractContext = Jsoup.parse(extractContext).text();
                                extractContext = extractContext.replaceAll("[\\n\\t]", "");
                            }
                        }
                    }
                }
            }
            return extractContext;
        } catch (Exception ex) {

            ErrorHandler.handleError(this.getClass(), ex);
            return ex.getMessage();
        }
    }

    protected String executeRequest(String pageTitle) throws Exception {

        String returnContent = "";
        try {

            String urlStr = "http://es.wikipedia.org/w/api.php?format=xml&action=query&prop=extracts&titles=" + pageTitle + "&redirects=true";
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(false);
            connection.setConnectTimeout(60000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new Exception("Bad response");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder responseBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            returnContent = responseBuilder.toString();

        } catch (MalformedURLException e) {
            ErrorHandler.handleError(this.getClass(), e);
        } catch (IOException ex) {
            ErrorHandler.handleError(this.getClass(), ex);
        }
        return returnContent;
    }

}
