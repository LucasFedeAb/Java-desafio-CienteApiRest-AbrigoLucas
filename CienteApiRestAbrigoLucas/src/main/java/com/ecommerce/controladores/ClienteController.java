package com.ecommerce.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.modelos.Cliente;
import com.ecommerce.servicios.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
		clienteService.agregarCliente(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED); // Codigo 201
	}
	
	@GetMapping (value = "/all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Cliente>> listarClientes() {
		try {
			List<Cliente> clientes = clienteService.listarClientes();
			return new ResponseEntity<>(clientes, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
	
	@GetMapping(value = "/cliente/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> mostrarClientePorDNI(@PathVariable("id") Integer dni) {
		try {
			Cliente cliente = clienteService.mostrarClientePorDNI(dni);
			if (cliente != null) {
				return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
	
	@GetMapping("/edadcliente/{id}")
    public ClienteResponse getCliente(@PathVariable("id") Integer dni) {
        Cliente cliente = clienteService.mostrarClientePorDNI(dni);
        return new ClienteResponse(cliente.getName(), cliente.getLastName(), cliente.getAge());
    }

    public static class ClienteResponse {
        private String nombre;
        private String apellido;
        private int años;

        public ClienteResponse(String nombre, String apellido, int años) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.años = años;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getAños() {
            return años;
        }

        public void setAños(int años) {
            this.años = años;
        }
    }
	
}
