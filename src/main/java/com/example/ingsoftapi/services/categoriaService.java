package com.example.ingsoftapi.services;

import com.example.ingsoftapi.models.categoria;
import com.example.ingsoftapi.repository.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoriaService {
    private final categoriaRepository Categoriarepository;

    categoriaResponse response;

    @Autowired
    public categoriaService(categoriaRepository CategoriaRepository){
        this.Categoriarepository = CategoriaRepository;
    }


    public ResponseEntity<Object> getCategoria(){
        List<categoria> categorias = Categoriarepository.findAll();
        if (!categorias.isEmpty()) {
            response = new categoriaResponse(categorias, "Obtención de todas los Categorias", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new categoriaResponse("No se encontraron Categorias", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newCategoria(categoria Categoria){
    this.Categoriarepository.save(Categoria);
    response=new categoriaResponse(Categoria,"Se pudo crear la Categoria",200,true );
    return new ResponseEntity<>(response.response(),HttpStatus.OK);
    };

    public  ResponseEntity<Object> updateCategoria(Long id, categoria Categoria) {
        if (Categoriarepository.findById(id).isPresent()) {
            categoria existingCategoria = Categoriarepository.findById(id).get();
            existingCategoria.setCategoria(Categoria.getCategoria());
            Categoriarepository.save(existingCategoria);
            response = new categoriaResponse(existingCategoria, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new categoriaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object>  eliminar(Long id){
        //Verificar si esta vacio
        if(!this.Categoriarepository.findById(id).isEmpty()){
            this.Categoriarepository.deleteById(id);
            response = new categoriaResponse("Si se pudo eliminar el ID: "+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new categoriaResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(Long id){
        if (Categoriarepository.findById(id).isPresent()) {
            categoria Categoria = Categoriarepository.findById(id).get();
            response = new categoriaResponse(Categoria, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new categoriaResponse("No existe la Categoria con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

}
