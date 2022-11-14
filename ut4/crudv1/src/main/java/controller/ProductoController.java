package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import modelo.Producto;
import modelo.ProductoRepositorio;

/**
 * 
 * @author Juan Cebrian
 *
 */
@RestController 
@RequiredArgsConstructor
public class ProductoController {

	private final ProductoRepositorio productoRepositorio;


	/**
	 * Consulta
	 * 
	 * @return List<Producto>
	 */
	@GetMapping("/producto")
	public List<Producto> obtenerTodos() {
		return productoRepositorio.findAll();
	}

	/**
	 * Consulta
	 * 
	 * @param id
	 * @return Producto
	 */
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}

	/**
	 * Alta de productos
	 * 
	 * @param nuevo
	 * @return Producto
	 */
	@PostMapping("/producto")
	public Producto nuevoProducto(@RequestBody Producto nuevo) {
		return productoRepositorio.save(nuevo);
	}
	
	/**
	 * Modificación de Productos
	 * 
	 * @param editar
	 * @param id
	 * @return Producto
	 */
	@PutMapping("/producto/{id}")
	public Producto editarProducto(@RequestBody Producto editar, @PathVariable Long id) {
		if(productoRepositorio.existsById(id)) {
			editar.setId(id);
			return productoRepositorio.save(editar);
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/producto/{id}")
	public Producto borrarProducto(@PathVariable Long id) {
		if (productoRepositorio.existsById(id)) {
			Producto result = productoRepositorio.findById(id).get();
			productoRepositorio.deleteById(id);
			return result;
		} else {
			return null;
		}
		
	}
}