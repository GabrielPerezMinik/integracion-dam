package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import IesPerezMinik.Gestor.de.Correos.GestorDeCorreosApplication;
import IesPerezMinik.Gestor.de.Correos.appVista2;
import IesPerezMinik.Gestor.de.Correos.Repository.UsuarioRepository;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

@Component
public class LoginController implements Initializable {

	public RootController root;

	@Autowired
	public RegistroController registro;

	@Autowired
	private UsuarioRepository control;

	@FXML
	private ImageView Avatar;

	@FXML
	private TextField CorreoField;

	@FXML
	private PasswordField PasswordField;

	@FXML
	private BorderPane vista;

	@FXML
	private Label labelModo;
	
    @FXML
    private Slider modoOscuro;

	@FXML
	void iniciarSesion(ActionEvent event) throws IOException {

		String correo = CorreoField.getText();
		String pass = PasswordField.getText();

		if (correo.isEmpty() || pass.isEmpty()) {
			Alert alertErr = new Alert(AlertType.ERROR);
			alertErr.initOwner(appVista2.primaryStage);
			alertErr.setHeaderText("Ambos campos deben ser llenados.");
			alertErr.setContentText("Llene ambos Campos por favor");
			alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
			alertErr.showAndWait();
		} else {

			if (control.findByCorreoAndContrasena(CorreoField.getText(), PasswordField.getText()) != null) {

				root = new RootController(CorreoField.getText(), PasswordField.getText());

				appVista2.primaryStage.setScene(new Scene(root.getVistaLogo()));
			} else {
				Alert alertErr = new Alert(AlertType.ERROR);
				alertErr.initOwner(appVista2.primaryStage);
				alertErr.setHeaderText("No se pudo iniciar sesion el email o la contraseña estan mal.");
				alertErr.setContentText("verifique la contraseña o el email");
				alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
				alertErr.showAndWait();
			}
		}

	}

	@FXML
	void registrarse(ActionEvent event) throws IOException {
		registro = new RegistroController();
		registro.Cargar(appVista2.aplicationContext);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Avatar.setImage(new Image("/images/login.png"));
		
		modoOscuro.setMajorTickUnit(1);
		modoOscuro.setMinorTickCount(0);
		modoOscuro.setSnapToTicks(true);
		
		DoubleProperty modoOscuroProperty = new SimpleDoubleProperty(modoOscuro.getValue());

		modoOscuro.valueProperty().addListener((observable, oldValue, newValue) -> {
			modoOscuroProperty.set(newValue.doubleValue());

			modoOscuroOn(newValue.doubleValue());

		});
		
	}

	public BorderPane getVista() {
		return vista;
	}

	public void Cargar(ConfigurableApplicationContext context) throws IOException {
		FXMLLoader loader = new FXMLLoader(GestorDeCorreosApplication.class.getResource("/vista/login.fxml"));
		loader.setControllerFactory(context::getBean);
		appVista2.primaryStage.setScene(new Scene(loader.load()));
	}

	void modoOscuroOn(double x) {
		
		if (x == 1) {
			
			labelModo.setText("Modo Oscuro:");
			vista.getStyleClass().add("modoOscuro");
		} else {
			labelModo.setText("Modo Claro:");
			vista.getStyleClass().remove("modoOscuro");
		}
	}
	
}
