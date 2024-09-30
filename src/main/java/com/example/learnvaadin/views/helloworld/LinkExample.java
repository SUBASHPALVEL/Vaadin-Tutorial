package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("link_example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 2)
@PageTitle("Link Example")
public class LinkExample extends VerticalLayout {

    public LinkExample(){

        Anchor exampleLink = new Anchor("https://google.com", "Visit Google");
        add(exampleLink);
    }
}
