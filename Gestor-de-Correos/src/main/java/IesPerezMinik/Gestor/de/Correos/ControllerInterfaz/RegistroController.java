package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import IesPerezMinik.Gestor.de.Correos.GestorDeCorreosApplication;
import IesPerezMinik.Gestor.de.Correos.appVista2;
import IesPerezMinik.Gestor.de.Correos.Entity.Usuario;
import IesPerezMinik.Gestor.de.Correos.Repository.UsuarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


@Component
public class RegistroController implements Initializable {

	LoginController login;
	RootController root;
	
	@Autowired
	private UsuarioRepository control;
		
	
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
	public void OnRegistrarse(ActionEvent event) { 
		
		
		 String correo = textCorreo.getText();
         String nombre = textNombre.getText();
         String usuario = textUsuario.getText();
         String contra = textContra.getText();
         String contraVerificado = textContraVerificado.getText();

         if (correo.isEmpty() || nombre.isEmpty() || usuario.isEmpty() || contra.isEmpty() || contraVerificado.isEmpty()) {
        	 Alert alertErr = new Alert(AlertType.ERROR);
 			alertErr.initOwner(appVista2.primaryStage);
 			alertErr.setHeaderText("Ambos campos deben ser llenados.");
 			alertErr.setContentText("Llene ambos Campos por favor");
 			alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
 			alertErr.showAndWait();
         } 
         
         else if(!esFormatoCorreoValido(correo)) {
        	 Alert alertErr = new Alert(AlertType.ERROR);
  			alertErr.initOwner(appVista2.primaryStage);
  			alertErr.setHeaderText("El formato de correo no es valido.");
  			alertErr.setContentText("Revise el correo para comprobar que es correcto");
  			alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
  			alertErr.showAndWait();
         }
         
         else if (!contra.equals(contraVerificado)) {
        	 Alert alertErr = new Alert(AlertType.ERROR);
 			alertErr.initOwner(appVista2.primaryStage);
 			alertErr.setHeaderText("Las contraseñan no coinciden.");
 			alertErr.setContentText("Revise las contraseñas");
 			alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
 			alertErr.showAndWait();
         } else {
        	 
        	 control.save(new Usuario(textNombre.getText(), textUsuario.getText(), textCorreo.getText(), textContra.getText()));
        	 Alert alertCon = new Alert(AlertType.CONFIRMATION);
 			alertCon.initOwner(appVista2.primaryStage);
 			alertCon.setHeaderText("Te has registrado con éxito "+  nombre  +".");
 			alertCon.setGraphic(new ImageView(new Image("/images/ok.png")));
 			alertCon.showAndWait();
 			try {
				root=new RootController(textCorreo.getText(),textContra.getText());
				appVista2.primaryStage.setScene(new Scene(root.getVistaLogo()));
			} catch (IOException e) {
				e.printStackTrace();
				 Alert alertErr = new Alert(AlertType.ERROR);
		 			alertErr.initOwner(appVista2.primaryStage);
		 			alertErr.setHeaderText("Algo a salido mal");
		 			alertErr.setContentText("Revise las datos porfavor");
		 			alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
		 			alertErr.showAndWait();
			}
 			
         }
		
	}

	@FXML
	void onIniciar(ActionEvent event) throws IOException {
		login = new LoginController();
		login.Cargar(appVista2.aplicationContext);
		
	}

	public RegistroController() {}
	
	public void Cargar(ConfigurableApplicationContext context) throws IOException {
		FXMLLoader loader = new FXMLLoader(GestorDeCorreosApplication.class.getResource("/vista/Registro.fxml"));
		loader.setControllerFactory(context::getBean);
		appVista2.primaryStage.setScene(new Scene(loader.load()));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public VBox getVista() {
		return vista;
	}

	 private boolean esFormatoCorreoValido(String correo) {
	        String expresionRegular = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	        Pattern pattern = Pattern.compile(expresionRegular);
	        Matcher matcher = pattern.matcher(correo);
	        return matcher.matches();
	    }
	
}
