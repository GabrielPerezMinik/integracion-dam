package IesPerezMinik.Gestor.de.Correos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("IesPerezMinik.Gestor.de.Correos.ControllerInterfaz")
public class GestorDeCorreosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorDeCorreosApplication.class, args);
		
		appVista.main(args);
		
	}

}
