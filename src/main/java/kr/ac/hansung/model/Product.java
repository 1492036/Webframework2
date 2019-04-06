package kr.ac.hansung.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	
	private int id;
	
	@NotEmpty(message="The product name must not be null")
	private String name;
	private String category;
	
	@Min(value=0, message="The product price must not be less than zero")
	private int price;
	
	@NotEmpty(message="The manufacturer must not be null")
	private String manufacturer;
	
	@Min(value=0, message="The product unitInStock must not be less than zero")
	private int unitInStock;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
	
}
