package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Checkbox Example")
@Route("checkbox_example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 5)
public class CheckBoxExample extends VerticalLayout {

    public CheckBoxExample(){
        Label statusLabel = new Label("Checkbox is not checked");
        Checkbox checkbox = new Checkbox("Check me");

        checkbox.addValueChangeListener(
                event -> {
                    if(checkbox.getValue()){
                        statusLabel.setText("Checkbox is checked");
                    } else {
                        statusLabel.setText("Checkbox is not checked");
                    }
                }
        );

        add(checkbox, statusLabel);
    }
}
