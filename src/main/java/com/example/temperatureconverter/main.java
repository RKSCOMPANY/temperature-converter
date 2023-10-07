package com.example.temperatureconverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws IOException {

       // System.out.println("action");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        // menu bar
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0 , menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CONVERTER");
        primaryStage.show();
    }

    private MenuBar createMenu(){

        Menu fileMenu = new Menu("FILE");

        Menu helpMenu = new Menu("HELP");

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu , helpMenu);

        return menuBar;


    }
}
