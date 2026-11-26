package org.iesch.demoSpringDataMongoProductos.repositorio;

import org.iesch.demoSpringDataMongoProductos.modelos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,String> {
}
