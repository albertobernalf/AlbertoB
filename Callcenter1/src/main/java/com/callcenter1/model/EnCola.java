package com.callcenter1.model;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class EnCola implements Runnable {
 
	BlockingQueue<Integer> bqueue;
	private Long cantidad_llamadas;
	
	// Creamos clases de empleados, para encolar prioridades
	
	Tipo_Empleado director = new Tipo_Empleado("Director","L",3);
	Tipo_Empleado supervisor = new Tipo_Empleado("Supervidor","L",2);
	Tipo_Empleado operario = new Tipo_Empleado("Operario","L",1);
	
		
    // Constructor para cola de llamadas
	
	public EnCola(BlockingQueue<Integer> bqueue, Long cantidad_Llamadas) {
		this.bqueue = bqueue;
		this.cantidad_llamadas = cantidad_Llamadas;
	}
	

	@Override
	public void run() {

		 ArrayList<Integer> Elements = new ArrayList<>();

		 // Elemento prioridad de Operarios
		 
		 for (Integer m=1; m<= 7; m++)
		 {
		
			Elements.add(operario.getPrioridad());
			
		 }
		 
		 // Elemento prioridad de los Supervisores
		 
		 Elements.add(supervisor.getPrioridad());
		 Elements.add(supervisor.getPrioridad());
		 
		 // Elemento prioridad del Director
		 
		 Elements.add(director.getPrioridad());
		 
	// Adiciona 10 elementos a la cola, a la vez. Es decir todos los empleados dispuestos a recibir llamadas
		 
		 System.out.println("Elementos a encolar "  +  Elements);
		 
		 bqueue.addAll(Elements);
		 
		
	}

}
