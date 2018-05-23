package com.callcenter1.controller;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.callcenter1.model.RealizarLlamada;
import com.google.gson.Gson;
import com.callcenter1.model.EnCola;


import com.callcenter1.model.Empleado;


@Controller
@ComponentScan("com.callcenter1")
@EnableAutoConfiguration
public class Callcenter1Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Callcenter1Controller.class);
	
	//Metodo de inicio para mostrar a los Empleados del Callcenter Libres antes de iniciar el proceso
	
	@RequestMapping(value= "/" , method = RequestMethod.GET) 
	public  ModelAndView home(ModelAndView model) {
		
		// Pool de threads para creacion de la cola  
		
		logger.info("entre al controlador");
		model.setViewName("home");
		
		return model;
		
	}

	
	// Metodo que realiza el proceso general de recibir el numero de llamadas a generar
	
	@RequestMapping(value= "/encolar" , method = RequestMethod.POST)
	@ResponseBody
	public  String encolar(Empleado empleado, Long llamada) {
		
		logger.info("Datos desde vista=  {}", empleado);
		logger.info("Llamadas Recibidasa=  {}", llamada);
		
		 Long llamadas = llamada;
		 
		// Pool de threads crear la cola y realizar llamadas 
		
		final ExecutorService service = Executors.newFixedThreadPool(2);
		
	// Encolamiento de acuerdo a la prioridad
		
			final BlockingQueue<Integer> bqueue = new PriorityBlockingQueue<Integer>();
			
			service.execute(new EnCola(bqueue,llamadas));
			
			for (Integer i=1; i<= llamadas; i++)
	    		
				 	{
					service.execute(new RealizarLlamada(bqueue, llamadas, empleado));
				 	}
			
			return (new Gson().toJson(empleado));

    }
	
	// Metodo para mostrar el estado de la clase empleado a la vista
	
	@RequestMapping(value= "/estado" , method = RequestMethod.POST)
	@ResponseBody
	public  String estado(Empleado empleado) {
		
		
		return (new Gson().toJson(empleado));

    }

// Metodo para llevar el modelo Empleado a la vista 
	
	@ModelAttribute("empleado")
	public void addAttributes6(Model model)  {

		Empleado empleado = new Empleado();
		
		empleado.setOperario1("Operario1");
		empleado.setEstado_Operario1("LIBRE");
		empleado.setOperario2("Operario2");
		empleado.setEstado_Operario2("LIBRE");
		empleado.setOperario3("Operario3");
		empleado.setEstado_Operario3("LIBRE");
		empleado.setOperario4("Operario4");
		empleado.setEstado_Operario4("LIBRE");
		empleado.setOperario5("Operario5");
		empleado.setEstado_Operario5("LIBRE");
		empleado.setOperario6("Operario6");
		empleado.setEstado_Operario6("LIBRE");
		empleado.setOperario7("Operario7");
		empleado.setEstado_Operario7("LIBRE");
		empleado.setSupervisor1("Supervisor1");
		empleado.setEstado_Supervisor1("LIBRE");
		empleado.setSupervisor2("Supervidor2");
		empleado.setEstado_Supervisor2("LIBRE");
		empleado.setDirector("Director");
		empleado.setEstado_Director("LIBRE");
		
		logger.info("empleado = {}" , empleado);
		
	    model.addAttribute("empleado",empleado);
	}
}
