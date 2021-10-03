package com.devsuperior.crudCliente.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.crudCliente.entities.Client;

public class ClientDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double income;
	private String cpf;
	private Integer children;
	private Long id;
	private Instant birthDate;

	public ClientDTO() {
		
	}

	public ClientDTO(String name, Double income, String cpf, Integer children, Instant birthDate,Long id) {
		this.name = name;
		this.income = income;
		this.cpf = cpf;
		this.children = children;
		this.birthDate = birthDate;
		this.id = id;
	}
	
	public ClientDTO(Client client) {
		this.name= client.getName();
		this.income= client.getIncome();
		this.cpf= client.getCpf();
		this.children= client.getChildren();
		this.birthDate= client.getBirthDate();
		this.id = client.getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
