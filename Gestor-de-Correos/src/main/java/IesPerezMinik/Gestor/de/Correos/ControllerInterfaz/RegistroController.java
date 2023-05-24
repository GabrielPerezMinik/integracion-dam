package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class RegistroController implements Initializable{
	
	@FXML
    private VBox vista;

	
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
