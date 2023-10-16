package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vendedorService {


    private final VendedorRepository vendedorRepository;
    private VendedorResponse vendedorResponse;

    @Autowired
    public vendedorService(VendedorRepository vendedorRepository) {
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

    public ResponseEntity<Object> insertVendedor(Vendedor vendedor) {
        this.vendedorRepository.save(vendedor);
        vendedorResponse = new UsuarioResponse(vendedor, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateVendedor(final Long id, final Vendedor vendedor) {
        if (vendedorRepository.findById(id).isPresent()) {
            Vendedor vendedorUpdated = vendedorRepository.findById(id).get();
            vendedorUpdated.setNombre_tienda(vendedor.getNombre_tienda());
            vendedorUpdated.setDescripcion_tienda(vendedor.getDescripcion_tienda());
            vendedorUpdated.setCategoria(vendedor.getCategoria());
            vendedorUpdated.setId_usuario(vendedor.getId_usuario());
            vendedorRepository.save(vendedorUpdated);
            vendedorResponse = new UsuarioResponse(vendedorUpdated, "El vendedor se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        } else {
            vendedorResponse = new UsuarioResponse("El vendedor no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> VendedorDelete(final Long id) {
        if (!this.vendedorRepository.findById(id).isEmpty()) {
            this.vendedorRepository.deleteById(id);
            vendedorResponse = new UsuarioResponse("Se ha eliminado el Vendedor", 200, true);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        } else {
            vendedorResponse = new UsuarioResponse("No se encontró el vendedor que quieres borrar ", 400, false);
            return new ResponseEntity<>(vendedorResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
