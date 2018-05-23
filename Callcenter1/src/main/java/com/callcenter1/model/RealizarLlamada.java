package com.callcenter1.model;

import java.util.concurrent.BlockingQueue;

//Clase para realizar la llamada a travez de Threads, Actualiza el estado de los empleados en el Call Center


import com.callcenter1.model.Empleado;

public class RealizarLlamada  implements Runnable {
	
	 private Long cantidad;
	 BlockingQueue<Integer> bqueue;
	 private Empleado empleado;
	 private static String Marca;
	 private static Integer prior;
	 
	 

	 // Constructor de la llamada , cola,  numero de llamadas y la clase empleado
	 
	 public RealizarLlamada(BlockingQueue<Integer> bqueue, Long cantidad, Empleado empleado) {
			this.bqueue = bqueue;
			this.cantidad = cantidad;
			this.empleado = empleado;
		}



	public static String getMarca() {
		return Marca;
	}



	public static void setMarca(String marca) {
		Marca = marca;
	}

	


	public static int getPrior() {
		return prior;
	}



	public static void setPrior(int i) {
		RealizarLlamada.prior = i;
	}



	@Override
	public void run() {
		
		Thread thread = new Thread(() -> {
		    System.out.println("Polling...");
		    while (true) {
		        try {
		            Integer poll = bqueue.take();
		            System.out.println("Take de la cola : " + poll);
		            
		            // Bucle determina que empleado ocupara la llamada
  			      
  			      for (Integer m=1; m<= 1; m++)
  		    		 {
  		    		 
  		    		 if (empleado.getEstado_Operario1() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario1("OCUPADO");
  		    		     RealizarLlamada.setMarca("Operario1");
  		    			 System.out.println("coloco MARCA operario1 : .... " + RealizarLlamada.getMarca());
  		    			RealizarLlamada.setPrior(1);
  		    			break;
  		    		 }
  		    		 

  		    		 if (empleado.getEstado_Operario2() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario2("OCUPADO");
  		    			   RealizarLlamada.setMarca("Operario2");
  		    			   System.out.println("coloco MARCA operario2 : .... " + RealizarLlamada.getMarca());
  		    			 RealizarLlamada.setPrior(1);
  		    				break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Operario3() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario3("OCUPADO");
  		    			 RealizarLlamada.setMarca("Operario3");
  		    			System.out.println("coloco MARCA operario3 : .... " + RealizarLlamada.getMarca());
 		    			 RealizarLlamada.setPrior(1);
  		         			break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Operario4() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario4("OCUPADO");
  		    			 RealizarLlamada.setMarca("Operario4");
  		    			System.out.println("coloco MARCA operario4 : .... " + RealizarLlamada.getMarca());
 		    			 RealizarLlamada.setPrior(1);
  		         			break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Operario5() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario5("OCUPADO");
  		    			 RealizarLlamada.setMarca("Operario5");
  		    			System.out.println("coloco MARCA operario5 : .... " + RealizarLlamada.getMarca());
 		    			 RealizarLlamada.setPrior(1);
  		         			break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Operario6() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario6("OCUPADO");
  		    			 RealizarLlamada.setMarca("Operario6");
  		    			System.out.println("coloco MARCA operario6 : .... " + RealizarLlamada.getMarca());
 		    			 RealizarLlamada.setPrior(1);
  		         			break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Operario7() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Operario7("OCUPADO");
  		    			 RealizarLlamada.setMarca("Operario7");
  		    			System.out.println("coloco MARCA operario7 : .... " + RealizarLlamada.getMarca());
 		    			 RealizarLlamada.setPrior(1);
  		         			break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Supervisor1() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Supervisor1("OCUPADO");
  		    			 RealizarLlamada.setMarca("Supervisor1");
  		    			System.out.println("coloco MARCA supervisor1 : .... " + RealizarLlamada.getMarca());
 		    			 RealizarLlamada.setPrior(2);
  		         			break;
  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Supervisor2() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Supervisor2("OCUPADO");
  		    			 RealizarLlamada.setMarca("Supervisor2");
  		    			System.out.println("coloco MARCA supervisor2 : .... " + RealizarLlamada.getMarca());
		    			 RealizarLlamada.setPrior(2);
		         			break;

  		    		 }

  		    		 
  		    		 if (empleado.getEstado_Director() == "LIBRE")
  		    		 {
  		    			 empleado.setEstado_Director("OCUPADO");
  		    			 RealizarLlamada.setMarca("Director");
  		    			System.out.println("coloco MARCA director : .... " + RealizarLlamada.getMarca());
		    			 RealizarLlamada.setPrior(3);
		         			break;
  		         			
  		    		 }

  		    		 }

  			      
		        } 
		        catch (InterruptedException e) { 
		            e.printStackTrace();
		        }
		    }
		});
		 
		thread.start();
		Long tiempo = procesa();
		
		 System.out.println("Adding to queue " + RealizarLlamada.getPrior());
		 
		
		// El bucle Libera al operario de la llamada una vez el hilo termine  
		 for (Integer m=1; m< 2; m++)
		 {
		 
			 if (RealizarLlamada.getMarca() == "Operario1")
		 {
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario1 " + empleado.getEstado_Operario1());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario1("LIBRE");
    			 RealizarLlamada.setMarca("");
    		
    			break;
		 }
		 

			 if (RealizarLlamada.getMarca() == "Operario2")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario2 " + empleado.getEstado_Operario2());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario2("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Operario3")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario3" + empleado.getEstado_Operario3());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario3("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Operario4")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario4 " + empleado.getEstado_Operario4());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario4("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Operario5")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario5 " + empleado.getEstado_Operario5());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario5("LIBRE");
    			RealizarLlamada.setMarca("");
    		
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Operario6")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario6 " + empleado.getEstado_Operario6());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario6("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Operario7")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Operario7 " + empleado.getEstado_Operario7());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Operario7("LIBRE");
    			RealizarLlamada.setMarca("");
    		
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Supervisor1")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Supervidor " + empleado.getEstado_Supervisor1());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Supervisor1("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Supervisor2")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Supervisor " + empleado.getEstado_Supervisor2());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Supervisor2("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 }

		 
			 if (RealizarLlamada.getMarca() == "Director")
		 {
		
					for (Integer x = 1 ; x<= 10*tiempo ; x++)
					{
						System.out.println("Contestando llamada " + Thread.currentThread().getName());
					}

    			System.out.println("Adding to queue Director " + empleado.getEstado_Director());
    			bqueue.add( RealizarLlamada.getPrior());
    			empleado.setEstado_Director("LIBRE");
    			RealizarLlamada.setMarca("");
    			
    			break;
		 	}
		
		 }

		
		 
		
		
	}
	
	
	// Metodo que asigna un numero entero random de segundos desde 5 a 10
	
    private Long procesa() {
    	
    	 Long tiempo =  (long) (Math.floor(Math.random() * (10 - 5)) + 5);
    	   System.out.println("Generacion duracion random de llamada "  +  tiempo);
    	   return(tiempo);
    }

	@Override
	public String toString() {
		return "RealizarLlamada [cantidad=" + cantidad + ", bqueue=" + bqueue + ", empleado=" + empleado + "]";
	}

}
