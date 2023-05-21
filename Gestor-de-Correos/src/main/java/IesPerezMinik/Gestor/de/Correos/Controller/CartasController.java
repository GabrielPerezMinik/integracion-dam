package IesPerezMinik.Gestor.de.Correos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import IesPerezMinik.Gestor.de.Correos.Service.CartaService;

@CrossOrigin
@RestController

public class CartasController {

	@Autowired
	CartaService cartaservice;
	
	
	@GetMapping("/ver")
	public ResponseEntity<?> VerCartas(){
		
		return new ResponseEntity<?>(cartaservice.findall(),HttpStatusCode.OK);
		
	}
	
}
