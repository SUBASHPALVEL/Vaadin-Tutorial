package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Label Example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 1)
@Route("label_example")
public class LabelExample extends VerticalLayout {

    public LabelExample(){
        Label exampleLabel = new Label("Hello, Subash");
        add(exampleLabel);
    }


}