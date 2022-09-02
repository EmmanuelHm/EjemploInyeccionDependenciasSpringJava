package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

@Component

//Para peticiones independientes de los usuarios (Actualiza el componente en cada peticion)
@RequestScope 

//Para guardar datos en sesion (Guarda datos hasta que se cierre el navegador)
//@SessionScope

//@ApplicationScope
public class Factura implements Serializable{
	
	//Generar un ID para para la sesion y el Serializable 
	private static final long serialVersionUID = 946004357128146951L;

	//Atributos (Con/Sin servicios9
	
		//Valor en application.propertie
		@Value("${factura.descripcion}")
		private String descripcion;
		
		//Servicio
		@Autowired
		private Cliente cliente;
		
		//Servicio
		@Autowired
		@Qualifier("itemsFacturaOficina")
		private List<ItemFactura> items;
		
	//LifeCycle (Ciclo de vida)
	
		//Cuando se contruye el objeto
		@PostConstruct
		public void inicializar() {
			cliente.setNombre( cliente.getNombre().concat(" ").concat("Ricardo") );
			descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
		}
	
		//Cuando se destruye el objeto
		//Este metodod no se aplica si estamos utilizando SessionScope
		@PreDestroy
		public void destruir() {
			System.out.println( "Factura destruida: ".concat(descripcion) );
		}
	
	
	// Getters & Setters
	
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		
		public List<ItemFactura> getItems() {
			return items;
		}
		public void setItems(List<ItemFactura> items) {
			this.items = items;
		}
	
}