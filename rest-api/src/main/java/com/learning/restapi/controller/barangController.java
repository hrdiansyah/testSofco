package com.learning.restapi.controller;

import java.util.LinkedHashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.restapi.dto.ResponseJson;
import com.learning.restapi.enumeration.responseCodes;
import com.learning.restapi.exception.notFoundException;
import com.learning.restapi.model.barang;
import com.learning.restapi.model.barangTupple;
import com.learning.restapi.repository.barangRepository;
import com.learning.restapi.repository.pemesanRepository;
import java.util.List;
import io.swagger.annotations.ApiOperation;


@RestController

@RequestMapping("/api/barang/v2")
public class barangController {
	
	@Autowired
	barangRepository BarangRepository;
	
	@Autowired
	pemesanRepository PemesanRepository;
	
	@PostMapping("/save")
	@ApiOperation(value = "post data barang pesanan")
	public ResponseEntity<Object> createStudent(@RequestBody barang Barang) {
		String noReg = UUID.randomUUID().toString();
		LinkedHashMap<String, Object> res = new LinkedHashMap<>();
		try {
		Barang.setNoRegister(noReg);
		barang savedBarang = BarangRepository.save(Barang);
		res.put("status", "false");
        res.put("message", "Pesanan telah diterima dengan nomor register \t " + noReg);
        res.put("data", savedBarang);
        return ResponseEntity.ok().body(res);
		} catch (Exception e) {
            res.put("status", "false");
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
		}
	}
	
	@PutMapping("/edit/{noRegister}")
	@ApiOperation(value = "edit data jumlah barang pesanan")
	public ResponseEntity<Object> putBarang(@PathVariable(value = "noRegister") String noRegister,
			@Validated @RequestBody barangTupple BarangTupple) throws notFoundException {
		barang Barang = BarangRepository.findByNoRegister(noRegister);
		LinkedHashMap<String, Object> res = new LinkedHashMap<>();
		try {
		Barang.setJumlahBarang(BarangTupple.getJumlahBarang());
		final barang updatedBarang = BarangRepository.save(Barang);
		res.put("status", "OK");
        res.put("message", "jumlah barang telah diubah");
        res.put("data", updatedBarang);
        return ResponseEntity.ok().body(res);
		} catch (Exception e) {
            res.put("status", "false");
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
		}
	}
	
	@GetMapping("getOne/{namaPemesan}")
	@ApiOperation(value = "get data barang pesanan by nama pemesan")
	public ResponseEntity<Object> 
	putBarang(@PathVariable(value = "namaPemesan") String namaPemesan) throws notFoundException {
//		barang Barang = BarangRepository.findByNoRegister(namaPemesan);
		LinkedHashMap<String, Object> res = new LinkedHashMap<>();
		List<barang> listBarang =  BarangRepository.findByNamaPemesan(namaPemesan);
		try {
		if (listBarang != null) {
			res.put("status", "OK");
	        res.put("message", "Berhasil");
	        res.put("data", listBarang);
	        return ResponseEntity.ok().body(res); 
        	} else {
        		res.put("status", "OK");
    	        res.put("message", "Nama pemesan tidak ditemukan");
    	        res.put("data", listBarang);
    	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseJson(responseCodes.NOTFOUND));
        	}
		} catch (Exception e) {
            res.put("status", "false");
            res.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(res);
		}
	}
	
}
