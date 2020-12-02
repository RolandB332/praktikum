package de.hfu;
import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*; 

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import junit.framework.Assert;

public class ResidentTest {

	@Test
	public void testGetFilteredResidentsList() {
		List<Resident> Liste = new ArrayList();
		Resident Jonas = new Resident ("Jonas", "Schlecht",  "Hauptstraße", "München",new Date(12,12,1993));
		Resident Artur = new Resident ("Artur", "Gut",  "Nebenstraße","Berlin", new Date(8,11,1994));
		Resident Peter = new Resident ("Peter", "Schön",  "Schrambergerstraße","Rottweil", new Date(12,12,1993));

		Resident Wildcard = new Resident ("*", "Sch*", "*", "*", new Date(12,12,1993));
		Liste.add(Jonas);
		BaseResidentService Service = new BaseResidentService();
		Service.setResidentRepository(new ResidentRepositoryStub());
		Assert.assertEquals(Liste, Service.getFilteredResidentsList(Jonas));
		Liste.add(Peter);
		Assert.assertEquals(Liste, Service.getFilteredResidentsList(Wildcard));
		Liste.clear();
		Liste.add(Artur);
		Assert.assertEquals(Liste, Service.getFilteredResidentsList(Artur));
	}
	
	@Test
	public void testGetUniqueResident() {
		
		Resident Jonas = new Resident ("Jonas", "Schlecht", "Hauptstraße", "München", new Date(12,12,1993));
		Resident Artur = new Resident ("Artur", "Gut",  "Nebenstraße","Berlin", new Date(8,11,1994));
		Resident Peter = new Resident ("Peter", "Schön",  "Schrambergerstraße","Rottweil", new Date(12,12,1993));
		Resident Wildcard = new Resident ("*","Sch*","*","*",new Date(1,1,1992));
		BaseResidentService Service = new BaseResidentService();
		Service.setResidentRepository(new ResidentRepositoryStub());
		
		try {
			Assert.assertEquals(Jonas, Service.getUniqueResident(Jonas));
			Assert.assertEquals(Peter, Service.getUniqueResident(Peter));
			Assert.assertEquals(Artur, Service.getUniqueResident(Artur));
		} catch (ResidentServiceException e) {
			e.printStackTrace();
		}
		//Wildcard Test
        try {
           Service.getUniqueResident(Wildcard);
            Assert.fail();
        } catch(ResidentServiceException e) {
            Assert.assertEquals(e.getMessage(), "Wildcards (*) sind nicht erlaubt!");
        }
	}
	
	@Test
	public void testWildcardNull() {
		BaseResidentService y = new BaseResidentService();
		y.setResidentRepository(new ResidentRepositoryStub());
		Resident wcard = new Resident(null, "Sch*", "Musterstrasse", "Furtwangen", new Date(2000,05,31));
		Resident wcard2 = new Resident("Max", null, "Muster*", "Musterstadt", new Date(2001,01,01));
		try {
			y.getUniqueResident(wcard);
			Assert.fail();
		} catch(ResidentServiceException e) {
			Assert.assertEquals(e.getMessage(), "Wildcards (*) sind nicht erlaubt!");
		} 
		try {
			y.getUniqueResident(wcard2);
			Assert.fail();
		} catch(ResidentServiceException e) {
			Assert.assertEquals(e.getMessage(), "Wildcards (*) sind nicht erlaubt!");
		} 

	}
	
	@Test 
	public void testcompileFilterPattern() {
		BaseResidentService y = new BaseResidentService();
		y.setResidentRepository(new ResidentRepositoryStub());
		Resident wcard = new Resident(null, "Sch*", "Musterstrasse", "Furtwangen", new Date(2000,05,31));
		Resident wcard2 = new Resident("Max", "", "Muster*", "Musterstadt", new Date(2001,01,01));
		y.getFilteredResidentsList(wcard);
		y.getFilteredResidentsList(wcard2);
	}
	
	@Test
	public void testWildcard() {
		BaseResidentService y = new BaseResidentService();
		y.setResidentRepository(new ResidentRepositoryStub());
		Resident wcard = new Resident("Kevin", "Sch*", "Musterstrasse", "Furtwangen", new Date(2000,05,31));
		Resident wcard2 = new Resident("Max", "Mustermann", "Muster*", "Musterstadt", new Date(2001,01,01));
		try {
			y.getUniqueResident(wcard);
			Assert.fail();
		} catch(ResidentServiceException e) {
			Assert.assertEquals(e.getMessage(), "Wildcards (*) sind nicht erlaubt!");
		} 
		try {
			y.getUniqueResident(wcard2);
			Assert.fail();
		} catch(ResidentServiceException e) {
			Assert.assertEquals(e.getMessage(), "Wildcards (*) sind nicht erlaubt!");
		} 

	}
	
}
