package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Prestamo;
import com.empresa.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {

	@Autowired
	private PrestamoRepository repository;

	@Override
	public List<Prestamo> listaPrestamo() {
		return repository.findAll();
	}
	@Override
	public Prestamo insertaActualizaPrestamo(Prestamo obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaPrestamo(int id) {
		repository.deleteById(id);
	}
}
