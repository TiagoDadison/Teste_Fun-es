package com.senai;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senai.domain.Cidade;
import com.senai.domain.Cliente;
import com.senai.domain.Endereco;
import com.senai.domain.Estado;
import com.senai.domain.enuns.TipoCliente;
import com.senai.domain.repositories.CidadeRepository;
import com.senai.domain.repositories.ClienteRepository;
import com.senai.domain.repositories.EnderecoRepository;
import com.senai.domain.repositories.EstadoRepository;

@SpringBootApplication
public class Senai3Application implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Senai3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Acre");
		Estado est2 = new Estado(null, "Rio Grande do Sul");
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		Cidade c1 = new Cidade(null, "Rio Branco", est1);
		Cidade c2 = new Cidade(null, "Porto Alegre", est2);
		cidadeRepository.saveAll(Arrays.asList(c1,c2));
		
		Cliente cli1 = new  Cliente(null, "Tiago Dadison Andrade Sousa", "36453728593", "tiagodadison2503@gmail.com", 
				TipoCliente.PESSOAFISICA);
		Cliente cli2 = new  Cliente(null, "Jacinto Cleber", "48592215037", "jacinto123@gmail.com", 
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("39568329", "13502537"));
		cli2.getTelefones().addAll(Arrays.asList("59358298", "11052759"));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		
		Endereco e1 = new Endereco(null, "Rua da Maçã", "442","", "Jardim dos Pequis", "5093965495",cli1,c1);
		Endereco e2 = new Endereco(null, "Rua da Banana", "605","", "Jardim das Peras", "5930592854",cli2,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
