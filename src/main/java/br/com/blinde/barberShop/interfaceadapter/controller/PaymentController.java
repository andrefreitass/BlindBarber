package br.com.blinde.barberShop.interfaceadapter.controller;

import br.com.blinde.barberShop.businessrule.exception.entities.ExceptionResponse;
import br.com.blinde.barberShop.businessrule.usecase.PaymentUseCase;
import br.com.blinde.barberShop.interfaceadapter.domain.request.payment.PaymentChangeRequest;
import br.com.blinde.barberShop.interfaceadapter.domain.response.PaymentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment/v1")
@Tag(name = "Payment", description = "End Points Payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentUseCase useCase;

    @GetMapping("/{id}")
    @Operation(summary = "Finds a Payment", description = "Finds a Payment",
            tags = {"Payment"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = PaymentResponse.class)
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
    public PaymentResponse findById(@PathVariable(value = "id") Long id) {
        return useCase.findById(id);
    }

    @GetMapping("/")
    @Operation(summary = "Finds all Payment", description = "Finds all Payment",
            tags = {"Payment"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = PaymentResponse.class))
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
    public List<PaymentResponse> findAll() {
        return useCase.findAll();
    }

    @PutMapping("/")
    @Operation(summary = "Update a Payment", description = "Update a Payment",
            tags = {"Payment"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = PaymentResponse.class)
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
    public PaymentResponse update(@Valid @RequestBody PaymentChangeRequest request) {
        return useCase.update(request);
    }
}