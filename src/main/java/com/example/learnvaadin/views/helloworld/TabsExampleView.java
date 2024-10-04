package com.example.learnvaadin.views.helloworld;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class TabsExampleView extends VerticalLayout {

    public TabsExampleView() {
        Tabs tabs = new Tabs();
        tabs.add(
                createTab("Tab 1", "Invoice"),
                createTab("Tab 2", "Expense"),
                createTab("Tab 3", "Uploader")
        );

        Div content = new Div();
        content.setText("Select a tab");

        tabs.addSelectedChangeListener(
                event -> {
                    Tab selectedTab = event.getSelectedTab();
                    String tabText = selectedTab.getLabel();
                    content.setText("You have selected:" + tabText);
                }
        );

        add(tabs, content);
    }

    private Tab createTab(String tabName, String tabContent) {
        Tab tab = new Tab(tabName);
        tab.setLabel(tabContent);
        return tab;
    }

}