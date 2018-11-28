package view;

import java.io.IOException;
import java.util.ArrayList;

import application.Observable;
import application.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VyhladavanieForm implements Form, Observable {
	@FXML
	private Button buttonVyhladajPouz;
	@FXML
	private Label label1, label2;
	@FXML
	private TextField textField1, textField2;
	@FXML
	private ComboBox<String> typComboBox;

	@FXML
	private void initialize() {
		buttonVyhladajPouz.setOnAction((event) -> {
			this.notifyObservers("Zobraz vyhForm");
		});
		typComboBox.setOnAction((event) -> {
			label2.setText(typComboBox.getValue());
		});
	}

	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	Stage stage;
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	@Override
	public void vytvor() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("VyhladavanieForm.fxml"));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			this.stage = new Stage();
			this.stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void zobraz() {
		this.stage.show();
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
			ob.update(this.toString(), msg);
		}

	}

}
