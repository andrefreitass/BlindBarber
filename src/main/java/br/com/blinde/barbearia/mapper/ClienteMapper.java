package br.com.blinde.barbearia.mapper;

import br.com.blinde.barbearia.dto.request.cliente.ClienteAlterarRequest;
import br.com.blinde.barbearia.dto.request.cliente.ClienteIncluirRequest;
import br.com.blinde.barbearia.dto.response.ClienteResponse;
import br.com.blinde.barbearia.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    private ClienteResponse response = new ClienteResponse();
    private Cliente cliente = new Cliente();

    public ClienteResponse converterClienteParaResponse(Cliente source){
        response.setId(source.getId());
        response.setNome(source.getNome());
        response.setSobreNome(source.getSobreNome());
        response.setCpf(source.getCpf());
        response.setDataNascimento(source.getDataNascimento());
        response.setTelefone(source.getTelefone());
        response.setEndereco(enderecoMapper.converterEnderecoParaResponse(source.getEndereco()));
        response.setSexo(source.getSexo());

        return response;
    }


    public Cliente converterIncluirParaCliente(ClienteIncluirRequest source){
        cliente.setId(source.getId());
        cliente.setNome(source.getNome());
        cliente.setSobreNome(source.getSobreNome());
        cliente.setCpf(source.getCpf());
        cliente.setDataNascimento(source.getDataNascimento());
        cliente.setTelefone(source.getTelefone());
        cliente.setEndereco(enderecoMapper.converterIncluirParaEndereco(source.getEndereco()));
        cliente.setSexo(source.getSexo());

        return cliente;

    }

    public Cliente converterAlterarParaCliente(ClienteAlterarRequest source) {
        cliente.setId(source.getId());
        cliente.setNome(source.getNome());
        cliente.setSobreNome(source.getSobreNome());
        cliente.setCpf(source.getCpf());
        cliente.setDataNascimento(source.getDataNascimento());
        cliente.setTelefone(source.getTelefone());
        cliente.setEndereco(enderecoMapper.converterAlterarParaEndereco(source.getEndereco()));
        cliente.setSexo(source.getSexo());

        return cliente;
    }

    public static Page<ClienteResponse> converter(Page<Cliente> clientes) {
        return clientes.map(ClienteResponse::new);
    }
}