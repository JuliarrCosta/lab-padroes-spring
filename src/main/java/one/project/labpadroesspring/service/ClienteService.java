package one.project.labpadroesspring.service;

import one.project.labpadroesspring.model.Cliente;

public interface ClienteService {
    //Strategy com todas operações CRUD
    //Read
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    //Create
    void inserir(Cliente cliente);
    //Update
    void atualizar(Long id, Cliente cliente);
    //Delete
    void excluir(Long id);
}
