package IesPerezMinik.Gestor.de.Correos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IesPerezMinik.Gestor.de.Correos.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCorreo(String nombre);
	boolean existsByCorreo(String correo);
	Usuario findByCorreoAndContrasena(String correo, String contrasena);
}
