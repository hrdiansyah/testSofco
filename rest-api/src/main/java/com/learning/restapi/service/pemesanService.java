package com.learning.restapi.service;

import org.springframework.stereotype.Service;

import com.learning.restapi.dto.pemesanDto;
import com.learning.restapi.model.pemesan;

@Service
public class pemesanService {

	public pemesanDto transformToDto(pemesan Pemesan) {
		pemesanDto PemesanDto = new pemesanDto();
		PemesanDto.setIdPemesan(Pemesan.getIdPemesan());
		PemesanDto.setNamaPemesan(Pemesan.getNamaPemesan());
		PemesanDto.setAlamatPemesan(Pemesan.getAlamatPemesan());
		return PemesanDto;
	}
}
