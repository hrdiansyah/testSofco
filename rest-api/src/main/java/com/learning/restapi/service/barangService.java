package com.learning.restapi.service;

import org.springframework.stereotype.Service;

import com.learning.restapi.dto.barangDto;
import com.learning.restapi.model.barang;

@Service
public class barangService {
	
	public barangDto transformToDto(barang Barang) {
		barangDto BarangDto = new barangDto();
		BarangDto.setNoRegister(Barang.getNoRegister());
		BarangDto.setNamaBarang(Barang.getNamaBarang());
		BarangDto.setJumlahBarang(Barang.getJumlahBarang());
		BarangDto.setNamaPemesan(Barang.getNamaPemesan());
		BarangDto.setAlamatPemesan(Barang.getAlamatPemesan());
		BarangDto.setTanggalPemesanan(Barang.getTanggalPemesanan());
		return BarangDto;
	}
}
