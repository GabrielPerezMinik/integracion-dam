package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController implements Initializable {

	
	private smtpController smtpController= new smtpController();
	private GmailController gmailController= new GmailController();

    @FXML
    private Tab gmailVista;

    @FXML
    private Tab smtpVista;

    @FXML
    private TabPane vistaLogo;

	
    public RootController() throws IOException {
	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestorCorreoFormato.fxml"));
		loader.setController(this);
		loader.load();
    
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		smtpVista.setContent(smtpController.getVistaSMTP());
		gmailVista.setContent(gmailController.getVistaGmail());
	}

	public TabPane getVistaLogo() {
		return vistaLogo;
	}

	public Tab getGmailVista() {
		return gmailVista;
	}

	public void setGmailVista(Tab gmailVista) {
		this.gmailVista = gmailVista;
	}

	public Tab getSmtpVista() {
		return smtpVista;
	}

	public void setSmtpVista(Tab smtpVista) {
		this.smtpVista = smtpVista;
	}
	
	
}
