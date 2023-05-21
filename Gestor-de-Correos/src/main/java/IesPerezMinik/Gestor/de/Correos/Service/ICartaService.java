package IesPerezMinik.Gestor.de.Correos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IesPerezMinik.Gestor.de.Correos.Entity.Carta;
import IesPerezMinik.Gestor.de.Correos.Repository.CartasRepository;

@Service
public class ICartaService implements CartaService{

	@Autowired
	private CartasRepository cartaRepo;

	@Override
	public Carta save(Carta carta) {
		// TODO Auto-generated method stub
		return cartaRepo.save(carta);
	}

	@Override
	public List<Carta> findall() {
		// TODO Auto-generated method stub
		return cartaRepo.findAll();
	}
	
}
