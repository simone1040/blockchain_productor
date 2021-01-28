package com.simone.progetto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id_client;
	private Product product;
	private Integer quantity;
	private long timestamp;
	
	public Transaction(Integer id_client, Product product, Integer quantity) {
		super();
		this.id_client = id_client;
		this.product = product;
		this.quantity = quantity;
		this.timestamp = this.createTimestamp();
	}

	private long createTimestamp(){
		return  new Date().getTime();
	}
}
