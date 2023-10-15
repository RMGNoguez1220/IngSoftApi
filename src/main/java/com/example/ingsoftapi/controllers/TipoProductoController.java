package com.example.ingsoftapi.controllers;


import com.example.ingsoftapi.models.TipoProducto;
import com.example.ingsoftapi.services.TipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tipoProducto")
public class TipoProductoController {
    private final TipoProductoServices tipoProductoServices;

    @Autowired
    public TipoProductoController(TipoProductoServices tipoProductoServices){
        this.tipoProductoServices = tipoProductoServices;
    }

    @GetMapping("/all")
    public ResponseEntity<Object>getTipoProducto(){
        return tipoProductoServices.getTipoProducto();
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getTipoProducto(@PathVariable Long id){
        return this.tipoProductoServices.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarTipoProducto(@RequestBody TipoProducto tipoProducto){
        return this.tipoProductoServices.newTipoProducto(tipoProducto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarTipoProducto(@PathVariable Long id,@RequestBody TipoProducto tipoProducto){
        return this.tipoProductoServices.updateTipoProducto(id,tipoProducto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.tipoProductoServices.eliminar(id);

    }
}
