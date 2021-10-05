package br.com.blinde.barbearia.mapper;

import br.com.blinde.barbearia.dto.request.endereco.EnderecoAlterarRequest;
import br.com.blinde.barbearia.dto.request.endereco.EnderecoIncluirRequest;
import br.com.blinde.barbearia.dto.response.EnderecoResponse;
import br.com.blinde.barbearia.dto.response.FuncionarioResponse;
import br.com.blinde.barbearia.entity.Endereco;
import br.com.blinde.barbearia.entity.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;


@Component
public class EnderecoMapper {

    private Endereco endereco = new Endereco();
    private EnderecoResponse enderecoResponse = new EnderecoResponse();


    public Endereco converterIncluirParaEndereco(EnderecoIncluirRequest source) {
        endereco.setId(source.getId());
        endereco.setCep(source.getCep());
        endereco.setLogradouro(source.getLogradouro());
        endereco.setComplemento(source.getComplemento());
        endereco.setBairro(source.getBairro());
        endereco.setLocalidade(source.getLocalidade());
        endereco.setUf(source.getUf());

        return endereco;
    }

    public EnderecoResponse converterEnderecoParaResponse(Endereco source) {
        enderecoResponse.setId(source.getId());
        enderecoResponse.setCep(source.getCep());
        enderecoResponse.setLogradouro(source.getLogradouro());
        enderecoResponse.setComplemento(source.getComplemento());
        enderecoResponse.setBairro(source.getBairro());
        enderecoResponse.setLocalidade(source.getLocalidade());
        enderecoResponse.setUf(source.getUf());

        return enderecoResponse;
    }

    public Endereco converterAlterarParaEndereco(EnderecoAlterarRequest source) {
        endereco.setId(source.getId());
        endereco.setCep(source.getCep());
        endereco.setLogradouro(source.getLogradouro());
        endereco.setComplemento(source.getComplemento());
        endereco.setBairro(source.getBairro());
        endereco.setLocalidade(source.getLocalidade());
        endereco.setUf(source.getUf());

        return endereco;
    }

    public static Page<EnderecoResponse> converter(Page<Endereco> enderecos) {
        return enderecos.map(EnderecoResponse::new);
    }
}
