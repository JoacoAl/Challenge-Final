package com.example.challengefinal.growshop.controladores;


import com.example.challengefinal.growshop.Repositorios.ClienteRepositorio;
import com.example.challengefinal.growshop.dto.ClienteDTO;
import com.example.challengefinal.growshop.dto.ClienteRegistroDTO;
import com.example.challengefinal.growshop.models.Cliente;
import com.example.challengefinal.growshop.servicios.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClienteControlador {

    @Autowired
    private ServicioCliente servicioCliente;

    @Autowired
    PasswordEncoder codificadorDeContraseña;

    @GetMapping("/clientes")
    public List<ClienteDTO> traerClientesDTO(){
        return servicioCliente.traerClientesDTO();
    }
    @GetMapping("/clientes/{id}")
    public  ClienteDTO traerClientePorId(@PathVariable Long id){
          return servicioCliente.traerClientePorId(id);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Object> registrarCliente(@RequestBody ClienteRegistroDTO clienteRegistroDTO){

        if (clienteRegistroDTO.getNombre().isBlank() || clienteRegistroDTO.getApellido().isBlank() || clienteRegistroDTO.getEmail().isBlank() || clienteRegistroDTO.getContraseña().isBlank()|| clienteRegistroDTO.getDireccion().isBlank() || clienteRegistroDTO.getEdad() <= 0 || clienteRegistroDTO.getTelefono().isBlank() ){
            return new ResponseEntity<>("Falta informacion", HttpStatus.FORBIDDEN);
        }

        if (servicioCliente.traerClientePorEmail(clienteRegistroDTO.getEmail()) != null){

            return new ResponseEntity<>("El email esta en uso", HttpStatus.FORBIDDEN);
        }

        Cliente cliente = new Cliente(clienteRegistroDTO.getNombre(),clienteRegistroDTO.getApellido(),clienteRegistroDTO.getEmail(),clienteRegistroDTO.getDireccion(), clienteRegistroDTO.getTelefono(),codificadorDeContraseña.encode(clienteRegistroDTO.getContraseña()), clienteRegistroDTO.getEdad());

        servicioCliente.save(cliente);

        return new ResponseEntity<>("El usuario fue registrado exitosamente", HttpStatus.CREATED);

    }
}
