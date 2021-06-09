package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Prestamo;

public interface PrestamoService {

	public abstract List<Prestamo> listaPrestamo();
	public abstract Prestamo insertaActualizaPrestamo(Prestamo obj);
	public abstract void eliminaPrestamo(int id);
}
