package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.MultiFileReceiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@PageTitle("Single File Uploader")
@Route("single_file_uploader")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 9)
public class FileUploaderView extends VerticalLayout {

    public FileUploaderView() {
        Label title = new Label("File Upload Example");

        // 1. Create a memory buffer to store the uploaded file
        MemoryBuffer memoryBuffer = new MemoryBuffer();

        // 2. Create an Upload component with the memory buffer
        Upload upload = new Upload(memoryBuffer);
        upload.setAcceptedFileTypes(".txt", ".csv", ".pdf"); // restrict to specific file types if necessary

        // 3. Add a listener for the successful upload
        upload.addSucceededListener(event -> {
            InputStream fileData = memoryBuffer.getInputStream(); // Access the uploaded file as InputStream
            String fileName = event.getFileName();
            Notification.show("Upload succeeded: " + fileName);

            // Process the uploaded file (e.g., display content)
            String fileContent = readFileContent(fileData);
            Notification.show("File content: " + fileContent);
        });

        // 4. Add components to the layout
        add(title, upload);
    }

    private String readFileContent(InputStream inputStream) {
        try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file.";
        }
    }
}