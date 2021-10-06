package br.com.blinde.barbearia.controller;

import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import br.com.blinde.barbearia.service.FuncionarioService;
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
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/")
    public Page<FuncionarioResponse> listaFuncionario( @RequestParam int pagina, @RequestParam int quantidadePagina,
                                                         @RequestParam Sort.Direction ordenacao,@RequestParam String objetoOrdenacao) {

        Pageable paginacao = new MontarRequestPaginacao(pagina,quantidadePagina,ordenacao,objetoOrdenacao).requestPaginacao();
        return service.buscarListaFuncionario(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscarId(@PathVariable Long id) {
       return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/")
    @Transactional
    public ResponseEntity<FuncionarioResponse> incluirFuncionario(@Valid @RequestBody FuncionarioIncluirRequest funcionario, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/api/v1/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(service.incluirFuncionario(funcionario));
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<FuncionarioResponse> alterarFuncionario(@Valid @RequestBody FuncionarioAlterarRequest funcionario) {
        return ResponseEntity.ok(service.alterarFuncionario(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
