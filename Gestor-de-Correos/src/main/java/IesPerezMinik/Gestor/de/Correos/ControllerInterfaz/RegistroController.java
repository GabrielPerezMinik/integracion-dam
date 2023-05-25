package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IesPerezMinik.Gestor.de.Correos.appVista;
import IesPerezMinik.Gestor.de.Correos.Controller.UsuarioController;
import IesPerezMinik.Gestor.de.Correos.Entity.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

@Component
public class RegistroController implements Initializable {

	LoginController login;
	
	@Autowired
	UsuarioController control;
	//UsuarioController control = new UsuarioController();	
	
	@FXML
	private VBox vista;

	@FXML
	private PasswordField textContra;

	@FXML
	private PasswordField textContraVerificado;

	@FXML
	private TextField textCorreo;

	@FXML
	private TextField textNombre;

	@FXML
	private TextField textUsuario;

	@FXML
	void OnRegistrarse(ActionEvent event) { 
		
		//System.out.println("estoy");
		
		if(textContra.getText().contentEquals(textContraVerificado.getText())) {
		
			//System.out.println("Si tiene lo mismo");
			
		control.guardarUsuario(new Usuario(textNombre.getText(), textUsuario.getText(), textCorreo.getText(), textContra.getText()));
		}
		
//		if() {
//			
//		}
//		
//		else {
//			
//		}
//		appVista.primaryStage.setScene(new Scene(registro.getVista()));
		
	}

	@FXML
	void onIniciar(ActionEvent event) throws IOException {
		 login = new LoginController();
		appVista.primaryStage.setScene(new Scene(login.getVista()));
	}

	public RegistroController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public VBox getVista() {
		return vista;
	}

}
