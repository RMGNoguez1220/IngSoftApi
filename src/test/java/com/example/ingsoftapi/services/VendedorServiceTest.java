package com.example.ingsoftapi.services;

import com.example.ingsoftapi.model.Producto;
import com.example.ingsoftapi.model.Vendedor;
import com.example.ingsoftapi.repository.ProductoRepository;
import com.example.ingsoftapi.repository.VendedorRepository;
import com.zaxxer.hikari.util.FastList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class VendedorServiceTest {
    @Mock
    private VendedorRepository vendedorRepository;
    @InjectMocks
    private VendedorService vendedorService;

    private Vendedor vendedor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        vendedor = new Vendedor();
        vendedor.setCategoria("electronica");
        vendedor.setNombre_tienda("tienda 1");
        vendedor.setId_vendedor(new Long(22));
    }

    @Test
    void getVendedor() {
        when(vendedorRepository.findAll()).thenReturn(Arrays.asList(vendedor));
        assertNotNull(vendedorService.getVendedor());
    }
}