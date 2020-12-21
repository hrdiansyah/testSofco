package com.learning.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.restapi.model.barang;

@Repository
public interface barangRepository extends JpaRepository<barang, Integer> {
	
	barang findByNoRegister(String noRegister);
	
	List<barang> findByNamaPemesan(String namaPemesan);
}
