package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("grid_example")
public class MainView extends VerticalLayout {

    public MainView() {
        // Create a list of people
        List<Person> people = getPeople();

        // Create a grid for displaying people
        Grid<Person> grid = new Grid<>(Person.class);

        // Set the items for the grid
        grid.setItems(people);

        // Configure columns (this will auto-bind Person fields)
        grid.addColumn(Person::getName).setHeader("Name");
        grid.addColumn(Person::getAge).setHeader("Age");
        grid.addColumn(Person::getEmail).setHeader("Email");

        // Add the grid to the layout
        add(grid);
    }

    // Method to generate some sample data
    private List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John Doe", 29, "john.doe@example.com"));
        people.add(new Person("Jane Smith", 34, "jane.smith@example.com"));
        people.add(new Person("Michael Johnson", 45, "michael.j@example.com"));
        return people;
    }

    // Inner class to represent a person
    public static class Person {
        private String name;
        private int age;
        private String email;

        public Person(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }
    }
}
