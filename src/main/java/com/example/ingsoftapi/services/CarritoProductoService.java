package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.CarritoProductoResponse;
import com.example.ingsoftapi.model.CarritoProducto;
import com.example.ingsoftapi.repository.CarritoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoProductoService {
    private final CarritoProductoRepository carritoproductoRepository;
    private CarritoProductoResponse carritoproductoResponse;

    @Autowired
    public CarritoProductoService(CarritoProductoRepository carritoproductoRepository) {
        this.carritoproductoRepository = carritoproductoRepository;
    }

    public ResponseEntity<Object> getCarritoProducto() {
        List<CarritoProducto> carritoproductoList = carritoproductoRepository.findAll();
        if (!carritoproductoList.isEmpty()) {
            carritoproductoResponse = new CarritoProductoResponse(carritoproductoList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(carritoproductoResponse.responseAll(), HttpStatus.OK);
        } else {
            carritoproductoResponse = new CarritoProductoResponse("No hay registros", 400, false);
            return new ResponseEntity<>(carritoproductoResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> carritoproductoInsert(CarritoProducto carritoproducto) {
        this.carritoproductoRepository.save(carritoproducto);
        carritoproductoResponse = new CarritoProductoResponse(carritoproducto, "Se pudo crear el registro", 200, true);
        return new ResponseEntity<>(carritoproductoResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> carritoproductoUpdate(final Long id, final CarritoProducto carritoproducto) {
        if (carritoproductoRepository.findById(id).isPresent()) {
            CarritoProducto carritoproductoUpdated = carritoproductoRepository.findById(id).get();
            carritoproductoUpdated.setId_carrito(carritoproducto.getId_carrito());
            carritoproductoUpdated.setId_producto(carritoproducto.getId_producto());
            carritoproductoRepository.save(carritoproductoUpdated);
            carritoproductoResponse = new CarritoProductoResponse(carritoproductoUpdated, "El carrito producto se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(carritoproductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            carritoproductoResponse = new CarritoProductoResponse("El carrito producto no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(carritoproductoResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> carritoproductoDelete(final Long id) {
        if (!this.carritoproductoRepository.findById(id).isEmpty()) {
            this.carritoproductoRepository.deleteById(id);
            carritoproductoResponse = new CarritoProductoResponse("Se ha eliminado el carrito producto", 200, true);
            return new ResponseEntity<>(carritoproductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            carritoproductoResponse = new CarritoProductoResponse("No se encontró el carrito producto que quieres borrar ", 400, false);
            return new ResponseEntity<>(carritoproductoResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
