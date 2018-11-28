package application;

import java.io.IOException;
import java.util.ArrayList;

import controller.VyhladavanieController;
import controller.ZamestnanieController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.VyhladavanieForm;
import view.ZamestnanieForm;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Main extends Application implements Observable {
	public ZamestnanieController zamController;
	public ZamestnanieForm zamForm;
	public VyhladavanieController vyhController;
	public VyhladavanieForm vyhForm;
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	@FXML
	private Button buttonZamestnajZam;
	@FXML
	private void initialize() {
		zamController = new ZamestnanieController();
		zamForm = new ZamestnanieForm();
		
		vyhController = new VyhladavanieController();
		vyhForm = new VyhladavanieForm();
		
		zamController.setZamForm(zamForm);
		zamController.setVyhController(vyhController);
		zamController.setVyhForm(vyhForm);
		
		zamForm.setZamController(zamController);
		zamForm.setZamForm(zamForm);
		
		zamForm.registerObserver(zamController);
		vyhController.registerObserver(zamController);
		vyhForm.registerObserver(vyhController);
		
		registerObserver(zamController);
		
		buttonZamestnajZam.setOnAction((event) -> {
			this.notifyObservers("Zobraz zamForm");
		});

	}

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Portál zamestnania");
			try {
				FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainForm.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers(Object msg) {
		for (Observer ob : observers) {
			System.out.println("Notifying Observers from" + this.getClass().getName());
			ob.update(this.toString(),msg);
		}
		
	}
}
