package com.learning.restapi.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "barang")
public class barang {
	@Id
	private String noRegister;
	
	private String namaBarang;
	private Integer jumlahBarang;
	private String namaPemesan;
	private String alamatPemesan;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date tanggalPemesanan;
	
	
}
