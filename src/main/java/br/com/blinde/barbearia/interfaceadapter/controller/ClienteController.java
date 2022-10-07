package br.com.blinde.barbearia.interfaceadapter.controller;

import br.com.blinde.barbearia.businessrule.exception.entities.ExceptionResponse;
import br.com.blinde.barbearia.businessrule.usecase.ClienteUseCase;
import br.com.blinde.barbearia.interfaceadapter.domain.request.ClienteAlterarRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.request.ClienteIncluirRequest;
import br.com.blinde.barbearia.interfaceadapter.domain.response.ClienteResponse;
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
public class ClienteController {

    private final ClienteUseCase useCase;

    @GetMapping("/{id}")
    @Operation(summary = "Finds a Client", description = "Finds a Client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClienteResponse.class)
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
    public ClienteResponse findById(@PathVariable(value = "id") Long id) {
        return useCase.findById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Finds all Client", description = "Finds all Client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
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
    public List<ClienteResponse> findAll() {
        return useCase.findAll();
    }

    @PostMapping("/")
    @Operation(summary = "Adds new client", description = "Adds new client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClienteResponse.class)
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
    public ClienteResponse create(@Valid @RequestBody ClienteIncluirRequest request) {
        return useCase.create(request);
    }

    @PutMapping("/")
    @Operation(summary = "Update a client", description = "Update a client",
            tags = {"Client"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = ClienteResponse.class)
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
    public ClienteResponse update(@Valid @RequestBody ClienteAlterarRequest request) {
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
}