package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Button Example")
@Route("button_example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 4)
public class ButtonExample extends VerticalLayout {
    public ButtonExample(){
        TextField number1 = new TextField("Enter First Number");
        TextField number2 = new TextField("Enter Second Number");

        Label resultLabel = new Label("Result");

        Button addButton = new Button("ADD");

        addButton.addClickListener(
                event -> {
                    try{
                        double num1 = Double.parseDouble(number1.getValue());
                        double num2 = Double.parseDouble(number2.getValue());

                        double result =  add(num1, num2);
                        resultLabel.setText("Result: "+ result);
                    }catch (NumberFormatException e){
                        Notification.show("Please enter valid numbers");
                    }
                }
        );

        add(number1, number2, addButton, resultLabel);

    }


    private double add(double num1, double num2){
        return num1 + num2;
    }



}
