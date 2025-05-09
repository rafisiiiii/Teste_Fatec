
package com.fatec.projeto.projeto2025.Controllers;

import com.fatec.projeto.projeto2025.infrastructure.viacep.EnderecoDto;
import com.fatec.projeto.projeto2025.infrastructure.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class EnderecoController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public EnderecoDto buscarEndereco(@PathVariable String cep) {
        return viaCepService.buscarPorCep(cep);
    }
}

