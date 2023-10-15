package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.ProductoResponse;
import com.example.ingsoftapi.domain.TiendaResponse;
import com.example.ingsoftapi.model.Producto;
import com.example.ingsoftapi.model.Tienda;
import com.example.ingsoftapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ProductoService   {

    private final ProductoRepository productoRepository;
    ProductoResponse response;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ResponseEntity<Object> getProducto() {
        List<Producto> productos = productoRepository.findAll();
        if(!productos.isEmpty()){
            response = new ProductoResponse(productos,"Productos",200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }else {
            response = new ProductoResponse("No se ecnontraron productos", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newProducto(Producto producto) {
        this.productoRepository.save(producto);
        response = new ProductoResponse(producto, "Creacion exitosa", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateProducto(Integer id, Producto producto) {
        if (productoRepository.findById(Long.valueOf(id)).isPresent()) {
            Producto existingProduct = productoRepository.findById(Long.valueOf(id)).get();
            existingProduct.setNombre(producto.getNombre());
            existingProduct.setDescripcion(producto.getDescripcion());
            existingProduct.setPrecio(producto.getPrecio());
            existingProduct.setCantidad(producto.getCantidad());
            existingProduct.setPhoto(producto.getPhoto());
            existingProduct.setCategoria_id(producto.getCategoria_id());
            existingProduct.setTipo_id(producto.getTipo_id());
            existingProduct.setTienda_id(producto.getTienda_id());
            productoRepository.save(existingProduct);
            response = new ProductoResponse(existingProduct, "Actualización exitosa", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ProductoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> eliminar(Integer id) {
            if (!this.productoRepository.findById(Long.valueOf(id)).isEmpty()) {
            this.productoRepository.deleteById(Long.valueOf(id));
            response = new ProductoResponse("Eliminacion exitosa:", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ProductoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        if (productoRepository.findById(Long.valueOf(id)).isPresent()) {
            Producto producto = productoRepository.findById(Long.valueOf(id)).get();
            response = new ProductoResponse(producto, "ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ProductoResponse("No existe la producto con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}

