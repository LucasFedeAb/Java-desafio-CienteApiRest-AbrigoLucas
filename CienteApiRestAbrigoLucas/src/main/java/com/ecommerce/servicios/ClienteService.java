package com.ecommerce.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.modelos.Cliente;
import com.ecommerce.repositorios.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente agregarCliente(Cliente cliente) {
		cliente.setId(cliente.getDni());
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente mostrarClientePorDNI(Integer dni) {
		return clienteRepository.findById(dni).orElse(null);
	}
	

}
