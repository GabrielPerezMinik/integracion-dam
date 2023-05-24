package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller1 implements Initializable{

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private TextField usernameField;

	    @FXML
	    private AnchorPane vista;
	    
	    
	    @FXML
	    private Button toggleModeButton;

	    private boolean isDarkMode = false;

	    @FXML
	    private void toggleMode() {
	        if (isDarkMode) {
	        	vista.getStyleClass().remove("dark-mode");
	            isDarkMode = false;
	        } else {
	        	vista.getStyleClass().add("dark-mode");
	            isDarkMode = true;
	        }
	    }
	    
	    public Controller1() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login2.fxml"));
			loader.setController(this);
			loader.load();
		}

		public void initialize(URL location, ResourceBundle resources) {

			
		}

		public AnchorPane getVista() {
			return vista;
		}

}
