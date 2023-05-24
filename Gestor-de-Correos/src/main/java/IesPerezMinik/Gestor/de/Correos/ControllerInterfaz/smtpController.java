package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import IesPerezMinik.Gestor.de.Correos.Api.llamadaSMTP;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class smtpController implements Initializable {

	llamadaSMTP SMTP = new llamadaSMTP();

	@FXML
	private CheckBox checkGmail;

	@FXML
	private CheckBox checkMicro;

	@FXML
	private CheckBox checkStartlls;

	@FXML
	private CheckBox checkYahoo;

	@FXML
	private PasswordField contrasenaSmtp;

	@FXML
	private Button enviarButton;

	@FXML
	private Slider modoOscuro;

	@FXML
	private Label labelModo;

	@FXML
	private Button salirButton;

	@FXML
	private TextField textAsunto;

	@FXML
	private TextArea textCuerpo;

	@FXML
	private TextField textDestinatario;

	@FXML
	private TextField textPuerto;

	@FXML
	private TextField textServidor;

	@FXML
	private Button vaciarButton;

	@FXML
	private GridPane vistaSMTP;

	public smtpController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/SMTP.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

//		modoOscuro.setMin(0);
//        modoOscuro.setMax(1);
//        modoOscuro.setBlockIncrement(1);
		modoOscuro.setMajorTickUnit(1);
		modoOscuro.setMinorTickCount(0);
		modoOscuro.setSnapToTicks(true);

		// Observar cambios en el valor del Slider

		DoubleProperty modoOscuroProperty = new SimpleDoubleProperty(modoOscuro.getValue());

		// Observar cambios en el valor del Slider
		modoOscuro.valueProperty().addListener((observable, oldValue, newValue) -> {
			modoOscuroProperty.set(newValue.doubleValue());

			modoOscuroOn(newValue.doubleValue());

			System.out.println("Nuevo valor de modoOscuro: " + newValue);
		});

		// Obtener el valor inicial del Slider
		double valorModoOscuro = modoOscuro.getValue();
		System.out.println("Valor inicial de modoOscuro: " + valorModoOscuro);

	}

	@FXML
	void modoOscuroOn(double x) {

		if (x == 1) {
			System.out.println("entro");
			labelModo.setText("Modo Oscuro:");
			vistaSMTP.getStyleClass().add("modoOscuro");
			//vistaSMTP.getStyleClass().remove("vistaSMTP");
		} else {
			labelModo.setText("Modo Claro:");
			vistaSMTP.getStyleClass().remove("modoOscuro");
			//vistaSMTP.getStyleClass().add("vistaSMTP");
		}
	}

	@FXML
	void onCheckGma(ActionEvent event) {

		automatizacion(checkGmail, 'g');

	}

	@FXML
	void onCheckOu(ActionEvent event) {

		automatizacion(checkMicro, 'o');

	}

	@FXML
	void onCheckYaho(ActionEvent event) {

		automatizacion(checkYahoo, 'y');

	}

	private void automatizacion(CheckBox check, char v) {

		Properties pro = null;
		if (v == 'g') {
			pro = SMTP.smtpGmail();
		}

		if (v == 'o') {
			pro = SMTP.smtpMicrosoft();
		}
		if (v == 'y') {
			pro = SMTP.smtpYahoo();
		}

		if (check.isSelected()) {

			textPuerto.setText(pro.getProperty("mail.smtp.port"));
			textServidor.setText(pro.getProperty("mail.smtp.host"));
			checkStartlls.setSelected(pro.getProperty("mail.smtp.starttls.enable").contains("true"));
		} else {
			textPuerto.setText("");
			textServidor.setText("");
			checkStartlls.setSelected(false);
		}
	}

	public GridPane getVistaSMTP() {
		return vistaSMTP;
	}

}
