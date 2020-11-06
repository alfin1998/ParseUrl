/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.Thread.State;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.text.Document;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

/**
 *
 * @author Alfin
 */
public class ParseUrlGui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            final WebView webView = new WebView();
            final WebEngine webEngine = webView.getEngine();

            Scene scene = new Scene(webView);

            stage.setScene(scene);
            stage.setWidth(1200);
            stage.setHeight(600);
            stage.show();

            webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends State> ov, State t, State t1) {
                    if (t1 == Worker.State.SUCCEEDED) {
                        try {
                            printDocument(webEngine.getDocument(), System.out);
                        } catch (Exception e) { e.printStackTrace(); }
                    }
                }

                @Override
                public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });

            webView.getEngine().load("http://www.example.com");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }

    public static void main(String[] args) {
        launch(args);
    }
}