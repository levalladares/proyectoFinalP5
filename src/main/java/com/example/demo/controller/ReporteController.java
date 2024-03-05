package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.dto.ReporteDto;
import com.example.demo.repository.modelo.dto.VehiculoDto;
import com.example.demo.service.IReservaService;

@Controller
@RequestMapping("/reportes")

public class ReporteController {

	@Autowired
	private IReservaService iReservaService;

	@GetMapping("/opciones")
	public String vistaReporte() {
		return "vistaReporte";
	}

	@GetMapping("/buscar")
	public String buscarR(ReporteDto dto, VehiculoDto dto2) {
		return "vistaBuscarReporte";
	}

	@GetMapping("/consultarRangoFechas")
	public String buscarRangoFechas(ReporteDto dto, Model model) {
		List<Reserva> reservas = this.iReservaService.buscarRangoFecha(LocalDateTime.parse(dto.getInicio()),
				LocalDateTime.parse(dto.getFin()));
		model.addAttribute("reservas", reservas);
		return "vistaRangoFechasReserva";
	}

}
