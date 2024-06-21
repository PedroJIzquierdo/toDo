package com.cjp.ToDo.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.Data;

@Data
public class TaskInDto {

	private String tittle;
	private String description;
	private LocalDate eta;
	
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getEta() {
		return eta;
	}
	public void setEta(LocalDate eta) {
		this.eta = eta;
	}

}
