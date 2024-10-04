package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Image Viewer")
@Route("image-viewer")
@Menu(icon = "line-awesome/svg/image-solid.svg", order = 12)
public class ImageViewerView extends VerticalLayout {

    public ImageViewerView() {

        Image image = new Image("1.png", "Alternate text for image");
        image.setHeight("600px");
        image.setWidth("100%");

        add(image);
    }
}