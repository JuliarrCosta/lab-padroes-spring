package one.project.labpadroesspring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.project.labpadroesspring.model.Endereco;

@FeignClient(name="viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    //vai trazer o endereço populado através do cep 
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
    
}
