package br.com.blinde.barberShop.interfaceadapter.controller;

import br.com.blinde.barberShop.businessrule.exception.entities.ExceptionResponse;
import br.com.blinde.barberShop.businessrule.usecase.ClientUseCase;
import br.com.blinde.barberShop.interfaceadapter.domain.request.client.ClientChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.client.ClientIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientResponse;
import br.com.blinde.barberShop.interfaceadapter.util.bean.Cpf;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client/v1")
@Tag(name = "Client", description = "End Points Clients")
@AllArgsConstructor
public class ClientController {

    private final ClientUseCase useCase;

    @GetMapping("/{id}")
    @Operation(summary = "Finds a Client", description = "Finds a Client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClientResponse.class)
                            )}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )})
            }
    )
    public ClientResponse findById(@PathVariable(value = "id") Long id) {
        return useCase.findById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Finds all Client", description = "Finds all Client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ClientResponse.class))
                            )}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )})
            }
    )
    public List<ClientResponse> findAll() {
        return useCase.findAll();
    }

    @PostMapping("/")
    @Operation(summary = "Adds new client", description = "Adds new client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClientResponse.class)
                            )}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )})
            }
    )
    public ClientResponse create(@Valid @RequestBody ClientIncludeRequest request) {
        return useCase.create(request);
    }

    @PutMapping("/")
    @Operation(summary = "Update a client", description = "Update a client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClientResponse.class)
                            )}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )})
            }
    )
    public ClientResponse update(@Valid @RequestBody ClientChangesRequest request) {
        return useCase.update(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client", description = "Delete a client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),

                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )})
            }
    )
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
        useCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/document/{cpf}")
    @Operation(summary = "Find a Client cpf", description = "Find a Client cpf",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClientResponse.class)
                            )}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )}),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
                            schema = @Schema(implementation = ExceptionResponse.class)
                    )})
            }
    )
    public ClientResponse findByCpf(@PathVariable(value = "cpf") @Cpf String cpf) {
        return useCase.findByCpf(cpf);
    }

}