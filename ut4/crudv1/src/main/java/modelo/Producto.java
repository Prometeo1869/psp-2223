package modelo;


import javax.persistence.GeneratedValue;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @EntityScan
public class Producto {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
	private float precio;

}
