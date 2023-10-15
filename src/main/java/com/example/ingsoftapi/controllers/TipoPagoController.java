package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.models.TipoPago;
import com.example.ingsoftapi.services.TipoPagoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/tipoPago")
public class TipoPagoController {

    private final TipoPagoServices tipoPagoServices;

    public TipoPagoController(TipoPagoServices tipoPagoServices){
        this.tipoPagoServices= tipoPagoServices;
    }

    @GetMapping("/all")
    public ResponseEntity<Object>getTipoPago(){
        return tipoPagoServices.getTipoPago();
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getTipoPago(@PathVariable Long id){
        return this.tipoPagoServices.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarTipoPago(@RequestBody TipoPago tipoPago){
        return this.tipoPagoServices.newTipoPago(tipoPago);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarTipoPago(@PathVariable Long id,@RequestBody TipoPago tipoPago){
        return this.tipoPagoServices.updateTipoPago(id,tipoPago);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.tipoPagoServices.eliminar(id);

    }
}