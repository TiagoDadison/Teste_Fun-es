package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cidade;
import com.senai.domain.repositories.CidadeRepository;

@SpringBootTest
public class CidadeTest {
	
	@Autowired
	CidadeRepository cidadeRepo;
	
	@Test
	void Cidade() {
		Cidade cid = new Cidade();
		cid.setId(null);
		cid.setNome("Uberaba");
		cidadeRepo.save(cid);
	}
	
	@Test
	public void listaCidade() {
		List<Cidade> list = cidadeRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idCidade() {
		Cidade cidade = cidadeRepo.findById(1).get();
		assertEquals("Rio Branco", cidade.getNome());
	}
	
	@Test
	public void updateCidade() {
		Cidade cidade = cidadeRepo.findById(2).get();
		cidade.setNome("Montes Claros");
		cidadeRepo.save(cidade);
		assertNotEquals("Porto Alegre", cidade.getNome());
	}
	
	@Test
	public void deleteCidade() {
		cidadeRepo.deleteById(2);
		assertThat(cidadeRepo.existsById(2));
	}

}
