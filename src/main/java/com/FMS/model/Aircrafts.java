package com.FMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aircrafts")
public class Aircrafts {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aircraftID;
	
	
    @Column(name = "productionLine")
	private String productionLine;
    
    @Column(name = "model")
	private String model;
	
	public Aircrafts() {
		super();
	}

	public Aircrafts(String productionLine, String model) {
		super();
		this.productionLine = productionLine;
		this.model = model;
	}

	public Long getAircraftID() {
		return aircraftID;
	}

	public void setAircraftID(Long aircraftID) {
		this.aircraftID = aircraftID;
	}

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Aircrafts [aircraftID=" + aircraftID + ", productionLine=" + productionLine + ", model=" + model + "]";
	}
	
	
	
}
