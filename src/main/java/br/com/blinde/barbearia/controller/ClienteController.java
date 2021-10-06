package br.com.blinde.barbearia.controller;

import br.com.blinde.barbearia.dto.request.cliente.ClienteAlterarAgendamentoRequest;
import br.com.blinde.barbearia.dto.request.cliente.ClienteAlterarRequest;
import br.com.blinde.barbearia.dto.request.cliente.ClienteIncluirRequest;
import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioAlterarRequest;
import br.com.blinde.barbearia.dto.request.funcionario.FuncionarioIncluirRequest;
import br.com.blinde.barbearia.dto.response.ClienteResponse;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import br.com.blinde.barbearia.service.ClienteService;
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
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/")
    public Page<ClienteResponse> listaCliente(@RequestParam int pagina, @RequestParam int quantidadePagina,
                                              @RequestParam Sort.Direction ordenacao, @RequestParam String objetoOrdenacao) {

        Pageable paginacao = new MontarRequestPaginacao(pagina,quantidadePagina,ordenacao,objetoOrdenacao).requestPaginacao();
        return service.buscarListaCliente(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/")
    @Transactional
    public ResponseEntity<ClienteResponse> incluirCliente(@Valid @RequestBody ClienteIncluirRequest cliente, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/api/v1/funcionarios/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(service.incluirCliente(cliente));
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<ClienteResponse> alterarCliente(@Valid @RequestBody ClienteAlterarRequest cliente) {
        return ResponseEntity.ok(service.alterarCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}