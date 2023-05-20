package IesPerezMinik.Gestor.de.Correos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Controller2 implements Initializable{


//    @FXML
//    private ImageView Avatar;
//
//    @FXML
//    private JFXTextField CorreoField;
//
//    @FXML
//    private JFXPasswordField PasswordField;
//
//    @FXML
//    private BorderPane Vista;

	    
	@FXML
    private ImageView Avatar;

    @FXML
    private TextField CorreoField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private BorderPane Vista;
	
	    
//	    @FXML
//	    private Button toggleModeButton;
//
//	    private boolean isDarkMode = false;
//
//	    @FXML
//	    private void toggleMode() {
//	        if (isDarkMode) {
//	        	Vista.getStyleClass().remove("dark-mode");
//	            isDarkMode = false;
//	        } else {
//	        	Vista.getStyleClass().add("dark-mode");
//	            isDarkMode = true;
//	        }
//	    }
	    
	    public Controller2() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/login.fxml"));
			loader.setController(this);
			loader.load();
		}

		public void initialize(URL location, ResourceBundle resources) {

			
		}

		public BorderPane getVista() {
			return Vista;
		}
  

}
