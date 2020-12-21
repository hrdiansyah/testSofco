package com.learning.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pemesan")
public class pemesan {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private String idPemesan;
	private String namaPemesan;
	private String alamatPemesan;
	
	@Override
	public String toString() {
		return "Pemesan [idPemesan=" + idPemesan + ", namaPemesan=" + namaPemesan + ", alamatPemesan =" + alamatPemesan  + "]";
	}
}
