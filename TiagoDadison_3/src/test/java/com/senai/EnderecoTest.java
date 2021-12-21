package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Endereco;
import com.senai.domain.repositories.EnderecoRepository;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	EnderecoRepository enderecoRepo;
	
	@Test
	void Endereco() {
		Endereco end = new Endereco();
		end.setId(null);
		end.setLogradouro("Rua do Abacaxi");
		end.setNumero("111");
		end.setComplemento("");
		end.setBairro("Jardim das Carambolas");
		end.setCep("059384212334");
		enderecoRepo.save(end);
	}
	
	@Test
	public void listaEndereco() {
		List<Endereco> list = enderecoRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idEndereco() {
		Endereco endereco = enderecoRepo.findById(1).get();
		assertEquals("442", endereco.getNumero());
	}
	
	@Test
	public void updateEndereco() {
		Endereco endereco = enderecoRepo.findById(2).get();
		endereco.setNumero("222");
		enderecoRepo.save(endereco);
		assertNotEquals("605", endereco.getNumero());
	}
	
	@Test
	public void deleteEndereco() {
		enderecoRepo.deleteById(2);
		assertThat(enderecoRepo.existsById(2));
	}

}
