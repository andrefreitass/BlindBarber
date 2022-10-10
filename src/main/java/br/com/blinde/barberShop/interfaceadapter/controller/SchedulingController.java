package br.com.blinde.barberShop.interfaceadapter.controller;

import br.com.blinde.barberShop.businessrule.exception.entities.ExceptionResponse;
import br.com.blinde.barberShop.businessrule.usecase.SchedulingUseCase;
import br.com.blinde.barberShop.interfaceadapter.domain.request.schedule.ScheduleChangesRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.request.schedule.ScheduleIncludeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.ClientSchedulingResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.EmployeeSchedulingResponse;
import br.com.blinde.barberShop.interfaceadapter.domain.response.SchedulingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/scheduling/v1")
@Tag(name = "Scheduling", description = "End Points Scheduling")
@AllArgsConstructor
public class SchedulingController {

    private final SchedulingUseCase useCase;

    @GetMapping("/{id}")
    @Operation(summary = "Finds a Scheduling", description = "Finds a Scheduling",
            tags = {"Scheduling"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = SchedulingResponse.class)
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
    public SchedulingResponse findById(@PathVariable(value = "id") Long id) {
        return useCase.findById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Finds all Scheduling", description = "Finds all Scheduling",
            tags = {"Scheduling"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SchedulingResponse.class))
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
    public List<SchedulingResponse> findAll() {
        return useCase.findAll();
    }

    @PostMapping("/")
    @Operation(summary = "Adds new Scheduling", description = "Adds new Scheduling",
            tags = {"Scheduling"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = SchedulingResponse.class)
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
    public SchedulingResponse create(@Valid @RequestBody ScheduleIncludeRequest request) {
        return useCase.create(request);
    }

    @PutMapping("/")
    @Operation(summary = "Update a Scheduling", description = "Update a Scheduling",
            tags = {"Scheduling"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = SchedulingResponse.class)
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
    public SchedulingResponse update(@Valid @RequestBody ScheduleChangesRequest request) {
        return useCase.update(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Scheduling", description = "Delete a Scheduling",
            tags = {"Scheduling"},
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

    @GetMapping("/client/{cpf}/{date}")
    @Operation(summary = "Find a Scheduling cpf", description = "Find a Scheduling cpf",
            tags = {"Scheduling"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = SchedulingResponse.class)
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
    public List<ClientSchedulingResponse> findByCpfClient(@PathVariable(value = "cpf") String cpf,
                                                          @PathVariable(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return useCase.findByCpfClient(cpf, date);
    }

    @GetMapping("/employee/{cpf}/{date}")
    @Operation(summary = "Find a Scheduling cpf", description = "Find a Scheduling cpf",
            tags = {"Scheduling"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = SchedulingResponse.class)
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
    public List<EmployeeSchedulingResponse> findByCpfEmployee(@PathVariable(value = "cpf") String cpf,
                                                              @PathVariable(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return useCase.findByCpfEmployee(cpf, date);
    }
}