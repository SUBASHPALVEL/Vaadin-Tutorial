package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@PageTitle("Text File Viewer")
@Route("text-viewer")
@Menu(icon = "line-awesome/svg/document-text-solid.svg", order = 13)
public class TextFileViewerView extends VerticalLayout {

    public TextFileViewerView() {

        TextArea textArea = new TextArea();
        textArea.setReadOnly(true);
        textArea.setHeight("600px");
        textArea.setWidth("100%");

        String content = loadTextFile("static\\1.txt");
        textArea.setValue(content);

        add(textArea);
    }

    private String loadTextFile(String filename) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            contentBuilder.append("Error loading file: ").append(e.getMessage());
        } catch (NullPointerException e) {
            contentBuilder.append("File not found: ").append(filename);
        }
        return contentBuilder.toString();
    }

}
