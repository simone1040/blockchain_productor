package com.simone.progetto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id_client;
	private Product product;
	private Integer quantity;
	private String timestamp;
	
	public Transaction(Integer id_client, Product product, Integer quantity) {
		super();
		this.id_client = id_client;
		this.product = product;
		this.quantity = quantity;
		this.timestamp = this.createTimestamp();
	}

	private String createTimestamp(){
		return  this.id_client + new SimpleDateFormat("dd/MM/yyyy HH-mm-ss").format(new Date());
	}

	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Transaction [id_client=" + id_client + ", product=" + product + ", quantity=" + quantity
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
	
}
