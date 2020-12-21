package com.learning.restapi.dto;

import java.sql.Date;

import javax.persistence.Id;

import lombok.Data;

@Data
public class barangDto {
	private String noRegister;
	private String namaBarang;
	private Integer jumlahBarang;
	private String namaPemesan;
	private String alamatPemesan;
	private Date tanggalPemesanan;

}
