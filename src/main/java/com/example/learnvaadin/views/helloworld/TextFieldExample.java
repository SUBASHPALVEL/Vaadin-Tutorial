package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("textfield_example")
@PageTitle("TextField Example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 2)
public class TextFieldExample extends HorizontalLayout {

    public TextFieldExample(){
        TextField exampleTextField = new TextField();
        exampleTextField.setValue("Enter Name");
        add(exampleTextField);
    }
}
