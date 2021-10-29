package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThembenhnhanController {
	
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
	ObservableList<BenhNhan> listT = null;
	public void themBN(ActionEvent e) throws SQLException {
		hoten11 = hoten1.getText();
		diachi11 = diachi1.getText();
		sdt11 = sdt1.getText();
		maBHYT11 = maBHYT1.getText();
		gioitinh11 = gioitinh1.getText();
		namsinh11 = namsinh1.getText();
		listT = ConnectSQL.getBenhNhan();
		for(int i = 0; i < listT.size(); i++) {
			if (listT.get(i).getMaBHYT() == Integer.parseInt(maBHYT11)) {
				canhbao1.setText("Mã BHYT " + maBHYT11 + " này đã được sửa dụng rồi.");
				canhbao2.setVisible(false);
				canhbao1.setVisible(true);
				return ;
			}
		}
		if(hoten11.equals("")||diachi11.equals("")||sdt11.equals("")||maBHYT11.equals("")||gioitinh11.equals("")||namsinh11.equals("")) {
			canhbao2.setVisible(false);
			canhbao1.setVisible(true);
		} else {
			conn = ConnectSQL.Connect();
	        String sql = "insert into BenhNhan values(?, ?, ?, ?, ?, ?)";
	        pst = conn.prepareStatement(sql);
            pst.setString(1, hoten11);
            pst.setInt(2, Integer.parseInt(namsinh11));
            pst.setString(3, gioitinh11);
            pst.setInt(4, Integer.parseInt(maBHYT11));
            pst.setString(5, sdt11);
            pst.setString(6, diachi11);
            pst.execute();
			String s = "Bệnh nhân " + hoten11 + " đã được thêm.";
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
