package com.quantumofvalue.java.agileguru.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
@Entity
@Table(name = "item")
public class Item implements Serializable {

	private Long id;
	private String itemText;
	
	public Item() {
		
	}
	
	public Item(String itemText) {
		this.itemText = itemText;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message="{validation.firstname.NotEmpty.message}")
	@Size(min=3, max=60, message="{validation.firstname.Size.message}")
	@Column(name = "ITEM_TEXT")
	public String getItemText() {
		return itemText;
	}
	
	public void setItemText(String itemText) {
		this.itemText = itemText;
	}
		
	
	public String toString() {		
		return "Item - Id: " + id + ", Item text: " + itemText ;
	}
	
	@Override
	public boolean equals(Object item) {
		return (id == ((Item)item).getId() && itemText == ((Item)item).getItemText());
	}
	
}
