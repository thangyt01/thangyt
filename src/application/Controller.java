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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller{
	
    private Stage stage;
    private Scene scene;
	@FXML
	private TextField userName;
	@FXML 
	private PasswordField password;
	@FXML 
	private Label warning;
	
//	login vào hệ thống tk vs mk đều là admin
	public void login(ActionEvent e) throws IOException {
		System.out.println("An vao login");
		if((userName.getText()).equals("admin")&&(password.getText()).equals("admin")) {
			System.out.println("Dang nhap thanh cong!");
			Parent root = FXMLLoader.load(getClass().getResource("Trangchu.fxml"));
			scene = new Scene(root);
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			stage.setTitle("Quản lý bệnh nhân");
			stage.setScene(scene);
			stage.show();
		} else {
			warning.setVisible(true);
		}
	}
	
	public void quenmatkhau(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("QuenMatKhau.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	
	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
}
