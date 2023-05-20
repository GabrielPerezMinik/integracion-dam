package IesPerezMinik.Gestor.de.Correos.Api;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppSmtp extends Application{

		public static Stage primaryStage;
		private Smtp control;

		@Override
		public void start(Stage primaryStage) throws Exception {
			control = new Smtp();
			AppSmtp.primaryStage=primaryStage;
			primaryStage.setTitle("Enviar Email");
			primaryStage.setScene(new Scene(control.getView()));
			primaryStage.getIcons().add(new Image("/images/email-send-icon-32x32 (1).png"));
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);

		}
		
	}
