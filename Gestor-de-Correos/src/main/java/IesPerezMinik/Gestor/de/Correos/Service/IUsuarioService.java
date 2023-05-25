package IesPerezMinik.Gestor.de.Correos.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IesPerezMinik.Gestor.de.Correos.Entity.Usuario;
import IesPerezMinik.Gestor.de.Correos.Repository.UsuarioRepository;

@Service
public class IUsuarioService implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
	
}
