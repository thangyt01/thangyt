package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TrangChuController implements Initializable{
	private static Stage stage = Main.stage;;
	private static Scene scene;
	private static WebEngine webEngine;
	static String url = "https:youtube.com";
	
	@FXML
	private TextField thanhtimkiem;
	@FXML
	private WebView browser;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(webEngine);
		try {
			webEngine.load("");
		} catch (Exception e){
			
		}

		// TODO Auto-generated method stub
		webEngine = browser.getEngine();
		webEngine.load(url);
	}
	
	public void thoat() {
		System.exit(0);
	}
	
	public void search() {
		url = thanhtimkiem.getText();
		if(!url.contains("http")) url = "http://" + url;
		System.out.println(url);
		webEngine.load(url);
	}
	public void dentrangchu() {
		
	}
	public void timkiem(KeyEvent e) {
		if(e.getCode().getName().equals("Enter")) search();
	}
	public void denqlbn(ActionEvent e) throws IOException {
		url = webEngine.getLocation();
		Parent root = FXMLLoader.load(getClass().getResource("Quanlybenhnhan.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void denqlt(ActionEvent e) throws IOException {
		url = webEngine.getLocation();
		Parent root = FXMLLoader.load(getClass().getResource("Quanlythuoc.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void denpb(ActionEvent e) throws IOException {
		url = webEngine.getLocation();
		Parent root = FXMLLoader.load(getClass().getResource("Quanlyphongbenh.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void dangxuat(ActionEvent e) throws IOException {
		url = "https://music-dxt.herokuapp.com/index.html?fbclid=IwAR0-Uy7fVrk8F8Eg0IYja-QlBJrmV-TOjrYjJ_XtAuup6q3OJaQDi31OTW4";
		webEngine.load("");
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		scene = new Scene(root);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}


}
