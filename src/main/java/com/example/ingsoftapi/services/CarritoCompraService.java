package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.CarritoCompraResponse;
import com.example.ingsoftapi.model.CarritoCompra;
import com.example.ingsoftapi.repository.CarritoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoCompraService {
    private final CarritoCompraRepository carritocompraRepository;
    private CarritoCompraResponse carritocompraResponse;

    @Autowired
    public CarritoCompraService(CarritoCompraRepository carritocompraRepository) {
        this.carritocompraRepository = carritocompraRepository;
    }

    public ResponseEntity<Object> getCarritoCompra() {
        List<CarritoCompra> carritocompraList = carritocompraRepository.findAll();
        if (!carritocompraList.isEmpty()) {
            carritocompraResponse = new CarritoCompraResponse(carritocompraList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(carritocompraResponse.responseAll(), HttpStatus.OK);
        } else {
            carritocompraResponse = new CarritoCompraResponse("No hay registros", 400, false);
            return new ResponseEntity<>(carritocompraResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> carritocompraInsert(CarritoCompra carritocompra) {
        this.carritocompraRepository.save(carritocompra);
        carritocompraResponse = new CarritoCompraResponse(carritocompra, "Se pudo crear el registro", 200, true);
        return new ResponseEntity<>(carritocompraResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> carritocompraUpdate(final Long id, final CarritoCompra carritocompra) {
        if (carritocompraRepository.findById(id).isPresent()) {
            CarritoCompra carritocompraUpdated = carritocompraRepository.findById(id).get();
            carritocompraUpdated.setId_carrito(carritocompra.getId_carrito());
            carritocompraUpdated.setId_usuario(carritocompra.getId_usuario());
            carritocompraRepository.save(carritocompraUpdated);
            carritocompraResponse = new CarritoCompraResponse(carritocompraUpdated, "El carrito compra se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(carritocompraResponse.responseInsert(), HttpStatus.OK);
        } else {
            carritocompraResponse = new CarritoCompraResponse("El carrito compra no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(carritocompraResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> carritocompraDelete(final Long id) {
        if (!this.carritocompraRepository.findById(id).isEmpty()) {
            this.carritocompraRepository.deleteById(id);
            carritocompraResponse = new CarritoCompraResponse("Se ha eliminado el carrito compra", 200, true);
            return new ResponseEntity<>(carritocompraResponse.responseInsert(), HttpStatus.OK);
        } else {
            carritocompraResponse = new CarritoCompraResponse("No se encontró el carrito compra que quieres borrar ", 400, false);
            return new ResponseEntity<>(carritocompraResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
