package com.example.ingsoftapi.services;

import com.example.ingsoftapi.model.Producto;
import com.example.ingsoftapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private ProductoResponse productoResponse;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ResponseEntity<Object> getProductos() {
        List<Producto> productoList = productoRepository.findAll();
        if (!productoList.isEmpty()) {
            productoResponse = new ProductoResponse(productoList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(productoResponse.responseAll(), HttpStatus.OK);
        } else {
            productoResponse = new ProductoResponse("No hay registros", 400, false);
            return new ResponseEntity<>(productoResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> insertProducto(Producto producto) {
        this.productoRepository.save(producto);
        productoResponse = new ProductoResponse(producto, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateProducto(final Long id, final Producto producto) {
        if (productoRepository.findById(id).isPresent()) {
            Producto userUpdated = productoRepository.findById(id).get();
            userUpdated.setNombre_producto(producto.getNombre_producto());
            userUpdated.setDescripcion_producto(producto.getDescripcion_producto());
            userUpdated.setPrecio(producto.getPrecio());
            userUpdated.setCategoria(producto.getCategoria());
            userUpdated.setStock(producto.getStock());
            productoRepository.save(userUpdated);
            productoResponse = new ProductoResponse(userUpdated, "El producto se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        } else {
            productoResponse = new ProductoResponse("El producto no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> productDelete(final Long id) {
        if (!this.productoRepository.findById(id).isEmpty()) {
            this.productoRepository.deleteById(id);
            productoResponse = new ProductoResponse("Se ha eliminado el usuario", 200, true);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        } else {
            productoResponse = new ProductoResponse("No se encontró el usuario que quieres borrar ", 400, false);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        }
    }
}