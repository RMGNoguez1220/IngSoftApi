package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.UsuarioResponse;
import com.example.ingsoftapi.domain.VendedorResponse;
import com.example.ingsoftapi.model.Vendedor;
import com.example.ingsoftapi.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {


    private final VendedorRepository vendedorRepository;
    private VendedorResponse vendedorResponse;

    @Autowired
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public ResponseEntity<Object> getVendedor() {
        List<Vendedor> vendedorList = vendedorRepository.findAll();
        if (!vendedorList.isEmpty()) {
            vendedorResponse = new VendedorResponse(vendedorList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(vendedorResponse.responseAll(), HttpStatus.OK);
        } else {
            vendedorResponse = new VendedorResponse("No hay registros", 400, false);
            return new ResponseEntity<>(vendedorResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> vendedorInsert(Vendedor vendedor) {
        this.vendedorRepository.save(vendedor);
        vendedorResponse = new VendedorResponse(vendedor, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> vendedorUpdate(final Long id, final Vendedor vendedor) {
        if (vendedorRepository.findById(id).isPresent()) {
            Vendedor vendedorUpdated = vendedorRepository.findById(id).get();
            vendedorUpdated.setNombre_tienda(vendedor.getNombre_tienda());
            vendedorUpdated.setDescripcion_tienda(vendedor.getDescripcion_tienda());
            vendedorUpdated.setCategoria(vendedor.getCategoria());
            vendedorRepository.save(vendedorUpdated);
            vendedorResponse = new VendedorResponse(vendedorUpdated, "El vendedor se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        } else {
            vendedorResponse = new VendedorResponse("El vendedor no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> vendedorDelete(final Long id) {
        if (!this.vendedorRepository.findById(id).isEmpty()) {
            this.vendedorRepository.deleteById(id);
            vendedorResponse = new VendedorResponse("Se ha eliminado el Vendedor", 200, true);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        } else {
            vendedorResponse = new VendedorResponse("No se encontró el vendedor que quieres borrar ", 400, false);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
