package IesPerezMinik.Gestor.de.Correos.Service;

import java.util.List;

import IesPerezMinik.Gestor.de.Correos.Entity.Carta;

public interface CartaService {

	public Carta save(Carta carta);
	
	public List<Carta> findall();
	
}
