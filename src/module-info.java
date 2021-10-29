module QUANLYBENHNHAN {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires fontawesomefx;
	requires javafx.base;
	requires java.sql;
	requires com.microsoft.sqlserver.jdbc;
	requires java.desktop;
	requires javafx.web;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base, javafx.controls;
}
