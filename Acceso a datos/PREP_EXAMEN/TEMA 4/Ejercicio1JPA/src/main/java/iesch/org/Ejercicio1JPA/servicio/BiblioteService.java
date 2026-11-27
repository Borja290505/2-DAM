package iesch.org.Ejercicio1JPA.servicio;

import iesch.org.Ejercicio1JPA.modelo.Categoria;
import iesch.org.Ejercicio1JPA.modelo.Libro;
import iesch.org.Ejercicio1JPA.repositorio.CategoriaRepositorio;
import iesch.org.Ejercicio1JPA.repositorio.LibroRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiblioteService {
    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    @Autowired
    LibroRepositorio libroRepositorio;

    public Categoria crearCategoria(String s){
        Categoria categoria = Categoria.builder().nombre(s).build();
        return categoriaRepositorio.save(categoria);
    }

    public Libro crearLibro(String titulo, String autor, long l){
        Libro libro = Libro.builder().titulo(titulo).autor(autor).categoria(categoriaRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("No existe la categoria" + l))).build();
        return libroRepositorio.save(libro);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepositorio.findAll();
    }

    public List<Libro> listarLibros(Long catId){
        return catId == null ? libroRepositorio.findAll() : libroRepositorio.findByCategoriaId(catId);
    }

    @Transactional
    public void cambiarCategoria(Long libro, long catNueva){
        Libro libro1 = libroRepositorio.findById(libro).orElseThrow(()->new IllegalArgumentException("No hay ningun libro con ese ID"));
        libro1.setCategoria(categoriaRepositorio.findById(catNueva).orElseThrow(()->new IllegalArgumentException("No existe una categoria con ese ID")));

        libroRepositorio.save(libro1);
    }

    @Transactional
    public void borrarLibro(Long libro){
        Libro libro1 = libroRepositorio.findById(libro).orElseThrow(()->new IllegalArgumentException("No hay ningun libro con ese ID"));
        libroRepositorio.delete(libro1);
    }

    @Transactional
    public void borrarCategoria(Long categoria){
        Categoria categoria1 = categoriaRepositorio.findById(categoria).orElseThrow(()->new IllegalArgumentException("No existe la categoria con id "));
        categoriaRepositorio.delete(categoria1);
    }

}
