package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SuabenhnhanController implements Initializable{
	
	@FXML
	TextField hoten1;
	@FXML
	TextField namsinh1;
	@FXML
	TextField diachi1;
	@FXML
	TextField sdt1;
	@FXML
	TextField gioitinh1;
	@FXML
	TextField maBHYT1;
	@FXML
	Label canhbao1;
	@FXML
	Label canhbao2;
	
	String hoten11;
	String diachi11;
	String sdt11;
	String maBHYT11;
	String gioitinh11;
	String namsinh11;
	
	PreparedStatement pst = null;
	Connection conn = null;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			hoten1.setText(br.readLine());
			namsinh1.setText(br.readLine());
			gioitinh1.setText(br.readLine());
			maBHYT1.setText(br.readLine());
			sdt1.setText(br.readLine());
			diachi1.setText(br.readLine());
			br.close();
			fr.close();
		}catch (Exception e1){
			
		}
	}
	
	public void suaBN(ActionEvent e) throws SQLException {
		hoten11 = hoten1.getText();
		diachi11 = diachi1.getText();
		sdt11 = sdt1.getText();
		maBHYT11 = maBHYT1.getText();
		gioitinh11 = gioitinh1.getText();
		namsinh11 = namsinh1.getText();
		if(hoten11.equals("")||diachi11.equals("")||sdt11.equals("")||maBHYT11.equals("")||gioitinh11.equals("")||namsinh11.equals("")) {
			canhbao2.setVisible(false);
			canhbao1.setVisible(true);
		} else {
			conn = ConnectSQL.Connect();
	        String sql = "update BenhNhan set HoTen = N'" + hoten11 + "',NamSinh ='" + namsinh11 + "',GioiTinh = N'" + gioitinh11
                    + "', Diachi = N'" + diachi11 + "', SDT = N'" + sdt11 + "'where MaBHYT ='" + maBHYT11 + "'";;
	        pst = conn.prepareStatement(sql);
            pst.execute();
			String s = "Bệnh nhân " + maBHYT11 + " đã được sửa đổi.";
			canhbao2.setText(s);
			canhbao1.setVisible(false);
			canhbao2.setVisible(true);
			hoten1.setText("");
			diachi1.setText("");
			sdt1.setText("");
			maBHYT1.setText("");
			gioitinh1.setText("");
			namsinh1.setText("");
		}
	}



}
