package com.example.learnvaadin.views.helloworld;

import com.vaadin.componentfactory.pdfviewer.PdfViewer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("PDF Document Viewer")
@Route("pdf-viewer")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 8)
public class PdfViewerView extends VerticalLayout {

    public PdfViewerView() {

        PdfViewer pdfViewer = new PdfViewer();
        pdfViewer.setSrc("Statistics.pdf");
        pdfViewer.setHeight("600px");
        pdfViewer.setWidth("100%");

        add(pdfViewer);

    }
}
