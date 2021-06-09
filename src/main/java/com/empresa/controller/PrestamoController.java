package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Prestamo;
import com.empresa.service.PrestamoService;

@RestController
@RequestMapping("/rest/prestamo")
public class PrestamoController {

	@Autowired
	private PrestamoService service; 
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Prestamo>> lista(){
		List<Prestamo> lista = service.listaPrestamo();
		return ResponseEntity.ok(lista);
	}
	
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Prestamo> eliminarPorId(@PathVariable("id") int cod_cli){
        Optional<Prestamo> optCliente = service.obtienePorId(cod_cli);
        if(optCliente.isPresent()) {
            service.eliminaPrestamo(cod_cli);
            return ResponseEntity.ok(optCliente.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Prestamo> listaPorId(@PathVariable("id") int idPrestamo){
        Optional<Prestamo> optAlumno =  service.obtienePorId(idPrestamo);
        if (optAlumno.isPresent()) {
            return ResponseEntity.ok(optAlumno.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Prestamo> registra(@RequestBody Prestamo obj){
        return ResponseEntity.ok(service.insertaActualizaPrestamo(obj));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Prestamo> actualiza(@RequestBody Prestamo obj){
        return ResponseEntity.ok(service.insertaActualizaPrestamo(obj));
	
}
}
