package com.learning.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.restapi.model.pemesan;

@Repository
public interface pemesanRepository extends JpaRepository<pemesan, Long> {
//	pemesan save();
}
