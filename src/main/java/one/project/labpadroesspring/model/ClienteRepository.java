package one.project.labpadroesspring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//O crud repository é uma strategy que provê todos os metodos de acesso

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
