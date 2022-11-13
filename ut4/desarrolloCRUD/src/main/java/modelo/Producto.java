package modelo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @EntityScan
public class Producto {
	
	@Generated
	private Long id;
	
	private String nombre;
	
	private float precio;

}
