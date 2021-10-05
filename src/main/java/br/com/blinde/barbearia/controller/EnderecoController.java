package br.com.blinde.barbearia.controller;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.dto.request.endereco.EnderecoIncluirRequest;
import br.com.blinde.barbearia.dto.response.EnderecoResponse;
import br.com.blinde.barbearia.service.EnderecoService;
import br.com.blinde.barbearia.uteis.MontarRequestPaginacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/")
    public Page<EnderecoResponse> listaEndereco(@RequestParam(required = false) String nomeFuncionario,
                                                @RequestParam int pagina, @RequestParam int quantidadePagina,
                                                @RequestParam Sort.Direction ordenacao, @RequestParam String objetoOrdenacao) {

        Pageable paginacao = new MontarRequestPaginacao(pagina, quantidadePagina, ordenacao, objetoOrdenacao).requestPaginacao();
        return service.buscarListaEndereco(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarId(id));
    }

    @PostMapping("/")
    @Transactional
    public ResponseEntity<EnderecoResponse> incluirEndereco(@Valid @RequestBody EnderecoIncluirRequest endereco, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/api/v1/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(service.incluirEndereco(endereco));
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<EnderecoResponse> alterarEndereco(@Valid @RequestBody EnderecoAlterarRequest endereco) {
        return ResponseEntity.ok(service.alterarEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
