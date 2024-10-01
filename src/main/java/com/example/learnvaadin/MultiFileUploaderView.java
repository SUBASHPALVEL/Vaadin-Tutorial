package com.example.learnvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.MultiFileReceiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@PageTitle("Multiple File Uploader")
@Route("multiple_file_uploader")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 10)
public class MultiFileUploaderView extends VerticalLayout {

    public MultiFileUploaderView() {
        Label title = new Label("Multi File Upload Example");

        Map<String, ByteArrayOutputStream> uploadedFiles = new HashMap<>();

        MultiFileReceiver receiver = (fileName, mimeType) -> {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            uploadedFiles.put(fileName, outputStream);
            return outputStream;
        };

        Upload multiUpload = new Upload(receiver);
        multiUpload.setAcceptedFileTypes(".txt", ".csv", ".pdf");
        multiUpload.setMaxFiles(50 * 1024 * 1024);

        multiUpload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            ByteArrayOutputStream fileStream = uploadedFiles.get(fileName);
            if (fileStream != null) {

                String fileContent = fileStream.toString();
                Notification.show("Upload succeeded: " + fileName);
                Notification.show("File content: " + fileContent);
            }
        });

        add(title, multiUpload);
    }
}
