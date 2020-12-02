package de.hfu.residents.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Stefan Betermieux
 *
 */
public class Resident implements Serializable {

  private String givenName;
  private String familyName;
  private String street;
  private String city;
  private Date dateOfBirth;
  
  public Resident() {
    super();
  }
  
  public Resident(String givenName, String familyName, String street, String city, Date dateOfBirth) {
    super();
    this.givenName = givenName;
    this.familyName = familyName;
    this.street = street;
    this.city = city;
    this.dateOfBirth = dateOfBirth;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
	result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
	result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
	result = prime * result + ((street == null) ? 0 : street.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Resident other = (Resident) obj;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (dateOfBirth == null) {
		if (other.dateOfBirth != null)
			return false;
	} else if (!dateOfBirth.equals(other.dateOfBirth))
		return false;
	if (familyName == null) {
		if (other.familyName != null)
			return false;
	} else if (!familyName.equals(other.familyName))
		return false;
	if (givenName == null) {
		if (other.givenName != null)
			return false;
	} else if (!givenName.equals(other.givenName))
		return false;
	if (street == null) {
		if (other.street != null)
			return false;
	} else if (!street.equals(other.street))
		return false;
	return true;
}
  
  
  
}
