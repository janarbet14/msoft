package view;

import java.io.IOException;
import java.util.ArrayList;

import application.Observable;
import application.Observer;
import controller.ZamestnanieController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ZamestnanieForm implements Form, Observable {
	@FXML
	private Button buttonVyhladajZam;
	@FXML
	private Text textVyhladajInfo;
	@FXML
	private ToggleGroup toggleGroupPohlavie;
	@FXML
	private RadioButton radioButtonMuz, radioButtonZena;
	@FXML
	private TextField textFieldMeno, textFieldPriezvisko, textFieldUlica, textFieldUlicaCislo, textFieldMesto,
			textFieldPSC, textFieldTelefon, textFieldEmail, textFieldIBAN, textFieldCisloUctu;
	@FXML
	private DatePicker datePickerDatumNar;
	@FXML
	private Label labelPriezvisko, labelMeno, labelPohlavie, labelAdresa, labelUlica, labelUlicaCislo, labelDatumNar,
			labelMesto, labelPSC, labelStat, labelKontakt, labelTelefon, labelEmail, labelBankSpojenie, labelIBAN,
			labelBanka, labelCisloUctu;
	@FXML
	private ComboBox<String> statComboBox, bankaComboBox;
	@FXML
	private ObservableList<String> statComboBoxData = FXCollections.observableArrayList();
	@FXML
	private ObservableList<String> bankaComboBoxData = FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		registerObserver(zamController);
		buttonVyhladajZam.setOnAction((event) -> {
			System.out.println("ma sa notifikovat zamcontroller" + observers.size());
			this.notifyObservers("Zobraz vyhForm");
		});
	}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX	
	Stage stage;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private ZamestnanieController zamController;
	private ZamestnanieForm zamForm;

	

	@Override
	public void vytvor() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ZamestnanieForm.fxml"));
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
			ob.update(this.toString(),"aa");
		}

	}
	
	public ZamestnanieController getZamController() {
		return zamController;
	}

	public void setZamController(ZamestnanieController zamController) {
		this.zamController = zamController;
	}
	public ZamestnanieForm getZamForm() {
		return zamForm;
	}

	public void setZamForm(ZamestnanieForm zamForm) {
		this.zamForm = zamForm;
	}

}
