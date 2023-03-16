package org.iesvdm.videoclub.repository;

import org.iesvdm.videoclub.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    List<Categoria> findByNombreContainingIgnoreCase(String nombre);

    List<Categoria> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    List<Categoria> findByNombreContainingIgnoreCaseOrderByNombreDesc(String nombre);

    List<Categoria> findAllByOrderByNombreAsc();

    List<Categoria> findAllByOrderByNombreDesc();
    @Query(value = "select Count(PC.idPelicula) from Categoria C left join C.peliculas PC group by C.id")
    List<Integer> queryCategoriaConteoPeliculas();
}
