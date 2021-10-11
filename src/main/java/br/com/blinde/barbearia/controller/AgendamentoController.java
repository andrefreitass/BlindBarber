package br.com.blinde.barbearia.controller;

import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoAlterarRequest;
import br.com.blinde.barbearia.dto.request.agendamentos.AgendamentoIncluirRequest;
import br.com.blinde.barbearia.dto.response.AgendamentoResponse;
import br.com.blinde.barbearia.service.AgendamentoService;
import br.com.blinde.barbearia.uteis.MontarRequestPaginacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/")
    public Page<AgendamentoResponse> listaAgendamentos(@RequestParam int pagina, @RequestParam int quantidadePagina,
                                                       @RequestParam Sort.Direction ordenacao, @RequestParam String objetoOrdenacao) {

        Pageable paginacao = new MontarRequestPaginacao(pagina, quantidadePagina, ordenacao, objetoOrdenacao).requestPaginacao();
        return service.buscarListaAgendamentos(paginacao);
    }


    @PostMapping("/")
    @Transactional
    public ResponseEntity<AgendamentoResponse> incluirAgendamento(/*@Valid*/ @RequestBody AgendamentoIncluirRequest agendamento, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/api/v1/agendamentos/{id}").buildAndExpand(agendamento.getCliente().getId()).toUri();
        return ResponseEntity.created(uri).body(service.incluirAgendamento(agendamento));
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<AgendamentoResponse> alterarAgendamento(/*@Valid*/ @RequestBody AgendamentoAlterarRequest agendamento) {
        return ResponseEntity.ok().body(service.alterarAgendamento(agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
