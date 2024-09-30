package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Data Binding Example")
@Route("databinding_example")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 6)
public class DataBindingExample extends VerticalLayout {

    // Data Model

    public static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

        public DataBindingExample(){
            Person person = new Person();

            TextField nameField = new TextField("Enter Name");
            Binder<Person> binder = new Binder<>(Person.class);
            binder.bind(nameField, Person::getName, Person::setName);

            Button showNameButton = new Button("Show Name", event -> {
                binder.writeBeanIfValid(person);
                Notification.show("Name: " + person.getName());
            });

            add(nameField, showNameButton);
            binder.readBean(person);  // this line for initial binding if the model has any data. It is optional

    }


}
