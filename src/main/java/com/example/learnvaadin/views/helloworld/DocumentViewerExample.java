package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Document Viewer Example")
@Route("documentviewer_example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 7)
public class DocumentViewerExample extends VerticalLayout {

    public DocumentViewerExample(){
        IFrame pdfFrame = new IFrame();
        pdfFrame.setWidth("100%");
        pdfFrame.setHeight("600px");

        pdfFrame.setSrc("Statistics.pdf");

        add(pdfFrame);

    }
}
