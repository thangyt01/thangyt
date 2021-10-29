package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class QLBNController implements Initializable {
	private static Stage stage = Main.stage;
	private static Scene scene;
	
	TextInputDialog dialog;
	String rs;
	
	@FXML
	private TextField sTen;
	@FXML
	private TextField sBHYT;
	@FXML
	private TextField sSDT;
	@FXML
	private TextField sDiachi;
	@FXML
	private Button thoat;
	
	@FXML
    TableView<BenhNhan> tablebenhnhan;

    @FXML
    private TableColumn<BenhNhan, String> gioitinh;

    @FXML
    private TableColumn<BenhNhan, String> diachi;

    @FXML
    private TableColumn<BenhNhan, String> sdt;

    @FXML
    private TableColumn<BenhNhan, String> hoten;

    @FXML
    private TableColumn<BenhNhan, Integer> namsinh;

    @FXML
    private TableColumn<BenhNhan, Integer> maBHYT;
	
	ObservableList<BenhNhan> listM = null;
	ObservableList<BenhNhan> listSearch = null;
	Connection conn;
	PreparedStatement pst = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(listM == null) {
			hoten.setCellValueFactory(new PropertyValueFactory<>("HoTen"));
	        namsinh.setCellValueFactory(new PropertyValueFactory<>("NamSinh"));
	        gioitinh.setCellValueFactory(new PropertyValueFactory<>("GioiTinh"));
	        maBHYT.setCellValueFactory(new PropertyValueFactory<>("MaBHYT"));
	        sdt.setCellValueFactory(new PropertyValueFactory<>("SDT"));
	        diachi.setCellValueFactory(new PropertyValueFactory<>("DiaChi"));

	        try {
	            listM = ConnectSQL.getBenhNhan();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        tablebenhnhan.setItems(listM);
	        System.out.println("Load thành công dữ liệu!");
		}
		
	}
	
	public void thoat(ActionEvent e) {
		System.exit(0);
	}
	
	public void search() {
		
		
	}
	public void dentrangchu(ActionEvent e) throws IOException {
		System.out.println("Den trang chu");
		Parent root = FXMLLoader.load(getClass().getResource("Trangchu.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void denqlbn(ActionEvent e) throws IOException {

	}
	public void denqlt(ActionEvent e) throws IOException {
		System.out.println("Den quan ly thuoc");
		Parent root = FXMLLoader.load(getClass().getResource("Quanlythuoc.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	public void denpb(ActionEvent e) throws IOException {
		System.out.println("Den quan ly phong benh");
		Parent root = FXMLLoader.load(getClass().getResource("Quanlyphongbenh.fxml"));
		scene = new Scene(root);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setTitle("Quản lý bệnh nhân");
		stage.setScene(scene);
		stage.show();
	}
	
//	Mở cửa số thêm bệnh nhân
	public void thembenhnhan(ActionEvent e) throws IOException {
		System.out.println("Them Benh Nhan");
		Parent root1 = FXMLLoader.load(getClass().getResource("ThemBenhNhan.fxml"));
		Scene scene1 = new Scene(root1);
		Stage stage1 = new Stage();
		stage1.setTitle("Thêm bệnh nhân");
		stage1.initOwner(stage);
		stage1.initModality(Modality.APPLICATION_MODAL);
		stage1.setScene(scene1);
		stage1.show();
		EventHandler<WindowEvent> myEvent = new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}
			
		};
		stage1.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, myEvent);
	}
	
	public void suabenhnhan(ActionEvent e) throws IOException {
		try {
			FileWriter fw = new FileWriter("data.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(tablebenhnhan.getSelectionModel().getSelectedItem().toString());
			bw.close();
			fw.close();
		}catch (Exception e1){
			
		}
//		System.out.println(tablebenhnhan.getSelectionModel().getSelectedItem());
		System.out.println("Sua Benh Nhan");
		Parent root1 = FXMLLoader.load(getClass().getResource("SuaBenhNhan.fxml"));
		Scene scene1 = new Scene(root1);
		Stage stage1 = new Stage();
		stage1.setTitle("Thêm bệnh nhân");
		stage1.initOwner(stage);
		stage1.initModality(Modality.APPLICATION_MODAL);
		stage1.setScene(scene1);
		stage1.show();
		EventHandler<WindowEvent> myEvent = new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				update();
			}
			
		};
		stage1.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, myEvent);
	}
	
	public void xoabenhnhan(ActionEvent e) throws SQLException {		
		System.out.println("Bấm vào xóa bệnh nhân");
		conn = ConnectSQL.Connect();
		String s = "delete from BenhNhan where maBHYT = ?";
		
		try {
			pst = conn.prepareStatement(s);
			pst.setInt(1, tablebenhnhan.getSelectionModel().getSelectedItem().getMaBHYT());
			pst.execute();
			update();
		}catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
	}
	
	public void timkiembenhnhan() {
		String tentk = sTen.getText();
		String bhyttk = sBHYT.getText();
		String sdttk = sSDT.getText();
		String diachitk = sDiachi.getText();
		System.out.println("Tim kiem Benh Nhan");
		listSearch = listM;
		FilteredList<BenhNhan> fd = new FilteredList<>(listSearch);
		boolean check = false; //Kiểm tra xem các ô tìm kiếm có được điền hay bỏ trống
		if(!tentk.equals("")) {
			check = true;
			fd.setPredicate(data -> {
				return data.getHoTen().toLowerCase().contains(tentk.toLowerCase());
			});
		};
		if(!bhyttk.equals("")) {
			check = true;
			fd.setPredicate(data -> {
				return (data.getMaBHYT() + "").toLowerCase().contains(bhyttk.toLowerCase());
			});
		};
		if(!sdttk.equals("")) {
			check = true;
			fd.setPredicate(data -> {
				return data.getSDT().toLowerCase().contains(sdttk.toLowerCase());
			});
		};
		if(!diachitk.equals("")) {
			check = true;
			fd.setPredicate(data -> {
				return data.getDiaChi().toLowerCase().contains(diachitk.toLowerCase());
			});
		};
		if(check) {
			tablebenhnhan.setItems(fd);
		} else {
			tablebenhnhan.setItems(listM);
		}
	}

	
	public void update() {        
        try {
            listM = ConnectSQL.getBenhNhan();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tablebenhnhan.setItems(listM);
		System.out.println("Update được chạy");
	}
	
	public void dangxuat(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		scene = new Scene(root);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}
	
	public void timkiem(KeyEvent e) {
		System.out.println(e.getCode()); //In ra key code mình vừa nhấn
		timkiembenhnhan();
	}
	
}
