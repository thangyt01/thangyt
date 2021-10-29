package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrangChuController {
	private Stage stage = Main.stage;;
	private Scene scene;
	
	
	public void thoat() {
		System.exit(0);
	}
	
	public void search() {
		
	}
	public void dentrangchu() {
		
	}
	public void denqlbn(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Quanlybenhnhan.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void denqlt(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Quanlythuoc.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void denpb(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Quanlyphongbenh.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void dangxuat(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		scene = new Scene(root);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}
}
