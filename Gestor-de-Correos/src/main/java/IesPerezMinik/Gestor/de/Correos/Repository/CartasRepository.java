package IesPerezMinik.Gestor.de.Correos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IesPerezMinik.Gestor.de.Correos.Entity.Carta;

@Repository
public interface CartasRepository extends JpaRepository<Carta, Integer> {

	
	// @Query("Select e from Carta e where e.id=true") ejemplo query JPA
	// @Query(value=Select idCartas from carta c where c.idCarta = :idCarta ,nativeQuery = true) ejemplo query Nativa de SQL o Mysql


}
