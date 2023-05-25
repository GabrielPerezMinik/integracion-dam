package IesPerezMinik.Gestor.de.Correos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import IesPerezMinik.Gestor.de.Correos.Entity.Usuario;
import IesPerezMinik.Gestor.de.Correos.Service.UsuarioService;

//@Controller
@RestController
public class UsuarioController {

	    @Autowired
	    private UsuarioService usuarioService;


	    public boolean guardarUsuario(Usuario usuario) {
	    	try {
	    		usuarioService.save(usuario);
		        return true;	
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return false;
	    }

	    
}
