package de.hfu.residents.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository  {
	
	public ResidentRepositoryStub() {
		
	}

	@Override
	public List<Resident> getResidents() {
		List<Resident> Liste = new ArrayList();
		Resident Jonas = new Resident ("Jonas", "Schlecht", "Hauptstraße","München", new Date(12,12,1993));
		Resident Artur = new Resident ("Artur", "Gut", "Nebenstraße", "Berlin", new Date(8,11,1994));
		Resident Peter = new Resident ("Peter", "Schön",  "Schrambergerstraße","Rottweil", new Date(12,12,1993));
		Liste.add(Jonas);
		Liste.add(Artur);
		Liste.add(Peter);
		return Liste;
	}
}
