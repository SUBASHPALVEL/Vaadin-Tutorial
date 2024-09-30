package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@PageTitle("DateTime Example")
@Route("datetime_example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 3)
public class DateTimeExample extends VerticalLayout {

    public DateTimeExample(){
        Label titleLabel = new Label("Example Date Picker");
        DatePicker datePicker = new DatePicker("Select a Date");
        datePicker.setPlaceholder("Pick a date");
        datePicker.addValueChangeListener(
                event -> {
                    LocalDate selectedDate = event.getValue();
                    if (selectedDate != null){
                        titleLabel.setText("Selected date: " + selectedDate.toString());
                    } else{
                        titleLabel.setText("No date selected");
                    }
                }
        );

        add(titleLabel, datePicker);
    }

}
