package com.example.app1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
	public static void main(String[] args)
	{
		System.out.println("main");
		launch();
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage stage) throws IOException {
		System.out.println("init");
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		VBox rootNode = fxmlLoader.load();

		MenuBar menuBar= createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);
		stage.setTitle("Temperature Converter Tool");
		stage.setScene(scene);
		stage.show();
	}

	private MenuBar createMenu(){
		//fileMenu
		Menu fileMenu=new Menu("File");

		MenuItem newMenuItem=new MenuItem("New");

		newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));

		SeparatorMenuItem SeparatorMenuItem= new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");

		quitMenuItem.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem,SeparatorMenuItem,quitMenuItem);

		//helpMenu
		Menu helpMenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");

		aboutApp.setOnAction(actionEvent -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);
		//MenuBar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;

	}

	private void aboutApp() {

		Alert alertDialog= new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App (Visa Kakashi)");
		alertDialog.setHeaderText("Learning JavaFx"); //this is basically the subTitle
		alertDialog.setContentText("Soon to be Pro Programmer Visa the Gamer Developer GG ");

		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("Yes Button Clicked !");

		}
		else{
			System.out.println("No Button Clicked !");
		}

		alertDialog.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}