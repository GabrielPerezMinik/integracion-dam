package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import IesPerezMinik.Gestor.de.Correos.appVista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{

	public RootController root;
	public RegistroController registro;
	
	@FXML
	private ImageView Avatar;

	@FXML
	private TextField CorreoField;

	@FXML
	private PasswordField PasswordField;

	@FXML
	private BorderPane Vista;

	@FXML
	private Label labelModo;

	public LoginController() throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/login.fxml"));
		loader.setController(this);
		loader.load();
		root=new RootController();
		registro= new RegistroController();
	}
	
	@FXML
	void iniciarSesion(ActionEvent event) {
		
		appVista.primaryStage.setScene(new Scene(root.getVistaLogo()));
		
	}

	@FXML
	void registrarse(ActionEvent event) {

		appVista.primaryStage.setScene(new Scene(registro.getVista()));
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

	public BorderPane getVista() {
		return Vista;
	}

}
