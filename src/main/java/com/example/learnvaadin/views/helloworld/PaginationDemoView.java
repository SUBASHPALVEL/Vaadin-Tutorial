package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.klaudeta.PaginatedGrid;
import com.vaadin.flow.data.provider.ListDataProvider;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Pagination Demo")
@Menu(icon = "line-awesome/svg/globe-solid.svg", order = 11)
@Route("pagination-demo")
public class PaginationDemoView extends VerticalLayout {

    public PaginationDemoView() {

        List<Person> personList = createDummyData();

        PaginatedGrid<Person, String> paginatedGrid = new PaginatedGrid<>();

        ListDataProvider<Person> dataProvider = new ListDataProvider<>(personList);
        paginatedGrid.setDataProvider(dataProvider);

        paginatedGrid.addColumn(Person::getFirstName).setHeader("First Name");
        paginatedGrid.addColumn(Person::getLastName).setHeader("Last Name");
        paginatedGrid.addColumn(Person::getEmail).setHeader("Email");

        paginatedGrid.setPageSize(10);

        paginatedGrid.setPaginatorSize(3);
        paginatedGrid.refreshPaginator();

        paginatedGrid.setPaginationLocation(PaginatedGrid.PaginationLocation.BOTTOM);

        paginatedGrid.setPaginatorTexts("Page", "of");

        add(paginatedGrid);
    }

    private List<Person> createDummyData() {
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            people.add(new Person("First " + i, "Last " + i, "email" + i + "@example.com"));
        }
        return people;
    }

    public class Person {
        private String firstName;
        private String lastName;
        private String email;

        public Person(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }
}
