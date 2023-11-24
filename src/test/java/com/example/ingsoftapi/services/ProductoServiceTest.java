package com.example.ingsoftapi.services;

import com.example.ingsoftapi.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.ingsoftapi.model.Producto;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductoServiceTest {

    @Mock
    private  ProductoRepository productoRepository;
    @InjectMocks
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        producto = new Producto();
        producto.setPrecio(1100);
        producto.setNombre_producto("Yo androide");
        producto.setId_producto(new Long(90));
    }

    @Test
    void getProducto() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));
        assertNotNull(productoService.getProducto());
    }
}