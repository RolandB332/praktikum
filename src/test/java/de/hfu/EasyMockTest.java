package de.hfu;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import static org.easymock.EasyMock.*;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class EasyMockTest {
	
	 @Test
	 public void test() {
		 List<Resident> Liste = new ArrayList<Resident>();
			Liste.add(new Resident("Jonas", "Schlecht", "Hauptstraße","München", new Date(12,12,1993)));
			Liste.add(new Resident("Artur", "Gut", "Nebenstraße", "Berlin", new Date(8,11,1994)));
			Liste.add(new Resident("Peter", "Schön",  "Schrambergerstraße","Rottweil", new Date(12,12,1993)));
			
			ResidentRepository rep = createMock(ResidentRepository.class);
			expect(rep.getResidents()).andReturn(Liste);
			expect(rep.getResidents()).andReturn(Liste);
			expect(rep.getResidents()).andReturn(Liste);
			expect(rep.getResidents()).andReturn(Liste);

		        replay(rep);
		        BaseResidentService service = new BaseResidentService();
		        service.setResidentRepository(rep);
		        
		        Resident Jonas = new Resident("Jonas", "Schlecht", "Hauptstraße","München", new Date(12,12,1993));
				Resident Artur = new Resident("Artur", "Gut", "Nebenstraße", "Berlin", new Date(8,11,1994));
				Resident Peter = new Resident("Peter", "Schön",  "Schrambergerstraße","Rottweil", new Date(12,12,1993));
				Resident error = new Resident("error", "error","errorstrasse", "errortadt", new Date(2133,12,26));
				Resident wildcard = new Resident("rol*", "G*", "Muster*", "Must*", new Date(1994,07,31));
				try {
					assertThat(service.getUniqueResident(Jonas), equalTo(Jonas));
				} catch (ResidentServiceException e) {
				}

				try {
					assertThat(service.getUniqueResident(Artur), equalTo(Artur));
				} catch (ResidentServiceException e) {
				}
				
				try {
					assertThat(service.getUniqueResident(Peter), equalTo(Peter));
				} catch (ResidentServiceException e) {
				}
				
				
				//ERROR
				try {
					service.getUniqueResident(error);
					Assert.fail();
				} catch(ResidentServiceException e) {
					assertThat(e.getMessage(), equalTo("Suchanfrage lieferte kein eindeutiges Ergebnis!"));
				} 
				//wildcard
				try {
					service.getUniqueResident(wildcard);
					Assert.fail();
				} catch(ResidentServiceException e) {
					assertThat(e.getMessage(), equalTo("Wildcards (*) sind nicht erlaubt!"));
				} 
				verify(rep);
			}
			

			@Test
			public void testGetFilteredResidentsList() {
				 List<Resident> Liste = new ArrayList<Resident>();
					Liste.add(new Resident("Jonas", "Schlecht", "Hauptstraße","München", new Date(12,12,1993)));
					Liste.add(new Resident("Artur", "Gut", "Nebenstraße", "Berlin", new Date(8,11,1994)));
					Liste.add(new Resident("Peter", "Schön",  "Schrambergerstraße","Rottweil", new Date(12,12,1993)));
					
					ResidentRepository rep = createMock(ResidentRepository.class);
					expect(rep.getResidents()).andReturn(Liste);
					expect(rep.getResidents()).andReturn(Liste);
					expect(rep.getResidents()).andReturn(Liste);
					

				        replay(rep);
				        BaseResidentService service = new BaseResidentService();
				        service.setResidentRepository(rep);
				
				
				        Resident Jonas = new Resident("Jonas", 	"Schlecht", "Hauptstraße",		    "München",	 new Date(12,12,1993));
						Resident Artur = new Resident("Artur", 	"Gut", 		"Nebenstraße", 			"Berlin", 	 new Date(8,11,1994));
						Resident Peter = new Resident("Peter", 	"Schön",  	"Schrambergerstraße",	"Rottweil",	 new Date(12,12,1993));
				
				
				

				
				Liste.clear();
				Liste.add(Jonas);
				assertThat(service.getFilteredResidentsList(Jonas),equalTo(Liste));
				
				Liste.clear();
				Liste.add(Artur);
				assertThat(service.getFilteredResidentsList(Artur),equalTo(Liste));
				
				Liste.clear();
				Liste.add(Peter);
				assertThat(service.getFilteredResidentsList(Peter),equalTo(Liste));
				
				
				
				verify(rep);

			}
		}
