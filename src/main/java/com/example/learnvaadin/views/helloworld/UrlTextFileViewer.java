package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Route("url-file-viewer")
public class UrlTextFileViewer extends VerticalLayout {

    private TextArea textArea;
    private Button loadButton;

    public UrlTextFileViewer() {
        textArea = new TextArea("Text File Content");
        textArea.setWidth("600px");
        textArea.setHeight("400px");
        textArea.setReadOnly(true);

        loadButton = new Button("Load Text File");
        loadButton.addClickListener(event -> loadTextFile("https://zerp-dev.s3.eu-north-1.amazonaws.com/internal_tool/invoice/TABLE%201/TABLE%201.txt?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20241010T072542Z&X-Amz-SignedHeaders=host&X-Amz-Credential=AKIAQUIGVQGHFL3O62EU%2F20241010%2Feu-north-1%2Fs3%2Faws4_request&X-Amz-Expires=600&X-Amz-Signature=7cedc0b11d67329d3ea73fec9f523b6fad8c6eeb23acd3167b97d4edd91da6e8"));

        add(loadButton, textArea);
    }

    private void loadTextFile(String urlString) {
        new Thread(() -> {
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    content.append(line).append("\n");
                }

                in.close();
                connection.disconnect();

                // Update the TextArea on the UI thread
                getUI().ifPresent(ui -> ui.access(() -> textArea.setValue(content.toString())));

            } catch (Exception e) {
                // Handle errors
                Notification.show("Error loading file: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        }).start();
    }
}
