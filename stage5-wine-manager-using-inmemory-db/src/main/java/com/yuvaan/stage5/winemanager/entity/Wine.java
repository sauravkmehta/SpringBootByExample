package com.yuvaan.stage5.winemanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Wines")
@ApiModel(description = " ")
public class Wine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	@Size(min = 5, message = "Name should have at least 5 characters")
	@ApiModelProperty(example = "my wine name", allowEmptyValue = false, hidden = false, required = true)
	private String name;
	
	@Min(value= 1950)
	@ApiModelProperty(example = "1996", allowEmptyValue = false, hidden = false, required = true)
	private int year;
	
	@DecimalMin(value = "5.0", message = "Alcohal content should be more than 5%")
	@DecimalMax(value = "20.0", message = "Alcohal content should be less than 20%")
	@ApiModelProperty(example = "13.5", allowEmptyValue = false, hidden = false, required = true)
	private float alcohalContent;
	
	@NotBlank
	@ApiModelProperty(example = "Ireland", allowEmptyValue = false, hidden = false, required = true)
	private String country;
	
	@NotBlank
	@ApiModelProperty(example = "Westmeath", allowEmptyValue = false, hidden = false, required = true)
	private String region;
	
	@Lob
	@NotBlank
	@ApiModelProperty(example = "my description", allowEmptyValue = false, hidden = false, required = true)
	private String description;
	
	@NotBlank
	@ApiModelProperty(example = "AZX-8737338", allowEmptyValue = false, hidden = false, required = true)
	private String batchNumber;

	public Wine() {

	}

	public Wine(Integer id, String name, int year, float alcohalContent, String country, String region,
			String description, String batchNumber) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.alcohalContent = alcohalContent;
		this.country = country;
		this.region = region;
		this.description = description;
		this.batchNumber = batchNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getAlcohalContent() {
		return alcohalContent;
	}

	public void setAlcohalContent(float alcohalContent) {
		this.alcohalContent = alcohalContent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(alcohalContent);
		result = prime * result + ((batchNumber == null) ? 0 : batchNumber.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + year;
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
		Wine other = (Wine) obj;
		if (Float.floatToIntBits(alcohalContent) != Float.floatToIntBits(other.alcohalContent))
			return false;
		if (batchNumber == null) {
			if (other.batchNumber != null)
				return false;
		} else if (!batchNumber.equals(other.batchNumber))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", name=" + name + ", year=" + year + ", alcohalContent=" + alcohalContent
				+ ", country=" + country + ", region=" + region + ", description=" + description + ", batchNumber="
				+ batchNumber + "]";
	}

}
