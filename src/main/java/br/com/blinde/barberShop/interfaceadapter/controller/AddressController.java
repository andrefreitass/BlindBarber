//package br.com.blinde.barberShop.interfaceadapter.controller;
//
//import br.com.blinde.barberShop.businessrule.exception.entities.ExceptionResponse;
//import br.com.blinde.barberShop.businessrule.usecase.AddressUseCase;
//import br.com.blinde.barberShop.interfaceadapter.domain.request.address.AddressChangesRequest;
//import br.com.blinde.barberShop.interfaceadapter.domain.request.address.AddressIncludeRequest;
//import br.com.blinde.barberShop.interfaceadapter.domain.response.AddressResponse;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/address/v1")
//@Tag(name = "Address", description = "End Points Address")
//@AllArgsConstructor
//public class AddressController {
//
//    private final AddressUseCase useCase;
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Finds a Address", description = "Finds a Address",
//            tags = {"Address"},
//            responses = {
//                    @ApiResponse(description = "Sucess", responseCode = "200",
//                            content = {@Content(schema = @Schema(implementation = AddressResponse.class)
//                            )}),
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )})
//            }
//    )
//    public AddressResponse findById(@PathVariable(value = "id") Long id) {
//        return useCase.findById(id);
//    }
//
//    @GetMapping("/")
//    @Operation(summary = "Finds all Address", description = "Finds all Address",
//            tags = {"Address"},
//            responses = {
//                    @ApiResponse(description = "Sucess", responseCode = "200",
//                            content = {@Content(
//                                    mediaType = "application/json",
//                                    array = @ArraySchema(schema = @Schema(implementation = AddressResponse.class))
//                            )}),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )})
//            }
//    )
//    public List<AddressResponse> findAll() {
//        return useCase.findAll();
//    }
//
//    @PostMapping("/")
//    @Operation(summary = "Adds new Address", description = "Adds new Address",
//            tags = {"Address"},
//            responses = {
//                    @ApiResponse(description = "Sucess", responseCode = "200",
//                            content = {@Content(schema = @Schema(implementation = AddressResponse.class)
//                            )}),
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )})
//            }
//    )
//    public AddressResponse create(@Valid @RequestBody AddressIncludeRequest request) {
//        return useCase.create(request);
//    }
//
//    @PutMapping("/")
//    @Operation(summary = "Update a Address", description = "Update a Address",
//            tags = {"Address"},
//            responses = {
//                    @ApiResponse(description = "Sucess", responseCode = "200",
//                            content = {@Content(schema = @Schema(implementation = AddressResponse.class)
//                            )}),
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )})
//            }
//    )
//    public AddressResponse update(@Valid @RequestBody AddressChangesRequest request) {
//        return useCase.update(request);
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete a Address", description = "Delete a Address",
//            tags = {"Address"},
//            responses = {
//                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
//
//                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )}),
//                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {@Content(
//                            schema = @Schema(implementation = ExceptionResponse.class)
//                    )})
//            }
//    )
//    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id) {
//        useCase.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}