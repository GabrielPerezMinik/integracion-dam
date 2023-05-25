package IesPerezMinik.Gestor.de.Correos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IesPerezMinik.Gestor.de.Correos.Entity.Usuario;
import IesPerezMinik.Gestor.de.Correos.Repository.UsuarioRepository;

@Service
public class UsuarioService2 {
	
	
	    @Autowired
	    private UsuarioRepository usuarioRepository;

	    public void guardarUsuario(Usuario usuario) {
	        usuarioRepository.save(usuario);
	    }

	

}
