package com.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.senai.domain.Cliente;
import com.senai.domain.repositories.ClienteRepository;

@SpringBootTest
public class ClienteTest {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Jorge Jorge");
		cli.setCpfOuCnpj("55039582947");
		cli.setEmail("jorge1jorge2@gmail.com.br");
		clienteRepo.save(cli);
	}
	
	@Test
	public void listaCliente() {
		List<Cliente> list = clienteRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void idCliente() {
		Cliente cliente = clienteRepo.findById(1).get();
		assertEquals("Tiago Dadison Andrade Sousa", cliente.getNome());
	}
	
	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepo.findById(2).get();
		cliente.setNome("Jacinto Pinto");
		clienteRepo.save(cliente);
		assertNotEquals("Jacinto Cleber", cliente.getNome());
	}
	
	@Test
	public void deleteClinte() {
		clienteRepo.deleteById(2);
		assertThat(clienteRepo.existsById(2));
	}
	
	
	//Teste das Operações Matemáticas 
	@Test
	public void somar() {
		double num1 = 8;
		double num2 = 23;
		Cliente cliente = new Cliente();
		double soma = cliente.somar(num1, num2);
		assertEquals(31, soma);
	}
	
	@Test
	public void subtrair() {
		double num1 = 13;
		double num2 = 4;
		Cliente cliente = new Cliente();
		double subtracao = cliente.subtrair(num1, num2);
		assertEquals(9, subtracao);
	}
	
	@Test
	public void multiplicar() {
		double num1 = 50;
		double num2 = 100;
		Cliente cliente = new Cliente();
		double multiplicacao = cliente.multiplicar(num1, num2);
		assertEquals(5000, multiplicacao);
	}
	
	@Test
	public void dividir() {
		double num1 = 32;
		double num2 = 8;
		Cliente cliente = new Cliente();
		double divisao = cliente.dividir(num1, num2);
		assertEquals(4, divisao);
	}

}
