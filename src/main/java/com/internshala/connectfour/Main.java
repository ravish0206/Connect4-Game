package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        controller=loader.getController();
        controller.createPlayground();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

       Pane menuePane= (Pane) rootGridPane.getChildren().get(0);
       menuePane.getChildren().add(menuBar);


        Scene scene=new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu(){
        // File menu
        Menu fileMenu=new Menu("File");

        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.restGame());

        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");

        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);

        //Help Menu
        Menu helpMenu=new Menu("Help");

        MenuItem aboutGame=new MenuItem("About Connect4");
        aboutGame.setOnAction(actionEvent -> aboutConnect4());

        SeparatorMenuItem separator=new SeparatorMenuItem();

        MenuItem aboutMe=new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);


        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Ravish kumar Roy");
        alert.setContentText("I love to play around with code and create game. "+
                "Connect4 is one of them. In free time "+
                "I like to spend time with nears and dears.");

        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the " +
                "players first choose a color and then take turns dropping colored discs in the box." );

        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {

        launch(args);
    }
}

    
