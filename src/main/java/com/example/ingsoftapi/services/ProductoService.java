package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.ProductoResponse;
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

    public ResponseEntity<Object> getProducto() {
        List<Producto> productoList = productoRepository.findAll();
        if (!productoList.isEmpty()) {
            productoResponse = new ProductoResponse(productoList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(productoResponse.responseAll(), HttpStatus.OK);
        } else {
            productoResponse = new ProductoResponse("No hay registros", 400, false);
            return new ResponseEntity<>(productoResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> productoInsert(Producto producto) {
        this.productoRepository.save(producto);
        productoResponse = new ProductoResponse(producto, "Se pudo crear el producto", 200, true);
        return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> productoUpdate(final Long id, final Producto producto) {
        if (productoRepository.findById(id).isPresent()) {
            Producto productoUpdated = productoRepository.findById(id).get();
            productoUpdated.setNombre_producto(producto.getNombre_producto());
            productoUpdated.setDescripcion_producto(producto.getDescripcion_producto());
            productoUpdated.setPrecio(producto.getPrecio());
            productoUpdated.setCategoria(producto.getCategoria());
            productoUpdated.setStock(producto.getStock());
            productoRepository.save(productoUpdated);
            productoResponse = new ProductoResponse(productoUpdated, "El producto se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        } else {
            productoResponse = new ProductoResponse("El producto no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> productoDelete(final Long id) {
        if (!this.productoRepository.findById(id).isEmpty()) {
            this.productoRepository.deleteById(id);
            productoResponse = new ProductoResponse("Se ha eliminado el producto", 200, true);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        } else {
            productoResponse = new ProductoResponse("No se encontró el producto que quieres borrar ", 400, false);
            return new ResponseEntity<>(productoResponse.responseInsert(), HttpStatus.OK);
        }
    }
}