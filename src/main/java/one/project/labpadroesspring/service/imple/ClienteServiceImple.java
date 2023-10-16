package one.project.labpadroesspring.service.imple;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.project.labpadroesspring.model.Cliente;
import one.project.labpadroesspring.model.Endereco;
import one.project.labpadroesspring.model.ClienteRepository;
import one.project.labpadroesspring.model.EnderecoRepository;
import one.project.labpadroesspring.service.ClienteService;
import one.project.labpadroesspring.service.ViaCepService;

@Service
public class ClienteServiceImple implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
     
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();

    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
   
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    
    }
    private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}
    
}
