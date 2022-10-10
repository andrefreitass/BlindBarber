package br.com.blinde.barberShop.interfaceadapter.controller;

import br.com.blinde.barberShop.businessrule.exception.entities.ExceptionResponse;
import br.com.blinde.barberShop.businessrule.usecase.EmployeeUseCase;
import br.com.blinde.barberShop.interfaceadapter.domain.request.employee.EmployeeChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.employee.EmployeeIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeResponse;
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
@RequestMapping("/api/employee/v1")
@Tag(name = "Employee", description = "End Points Employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeUseCase useCase;

    @GetMapping("/{id}")
    @Operation(summary = "Finds a Employee", description = "Finds a Employee",
            tags = {"Employee"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = EmployeeResponse.class)
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
    public EmployeeResponse findById(@PathVariable(value = "id") Long id) {
        return useCase.findById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Finds all Employee", description = "Finds all Employee",
            tags = {"Employee"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EmployeeResponse.class))
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
    public List<EmployeeResponse> findAll() {
        return useCase.findAll();
    }

    @PostMapping("/")
    @Operation(summary = "Adds new Employee", description = "Adds new Employee",
            tags = {"Employee"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = EmployeeResponse.class)
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
    public EmployeeResponse create(@Valid @RequestBody EmployeeIncludeRequest request) {
        return useCase.create(request);
    }

    @PutMapping("/")
    @Operation(summary = "Update a Employee", description = "Update a Employee",
            tags = {"Employee"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = EmployeeResponse.class)
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
    public EmployeeResponse update(@Valid @RequestBody EmployeeChangesRequest request) {
        return useCase.update(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Employee", description = "Delete a Employee",
            tags = {"Employee"},
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
    @Operation(summary = "Finds a Employee", description = "Finds a Employee",
            tags = {"Employee"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = EmployeeResponse.class)
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
    public EmployeeResponse findByCpf(@PathVariable(value = "cpf") @Cpf String cpf) {
        return useCase.findByCpf(cpf);
    }
}