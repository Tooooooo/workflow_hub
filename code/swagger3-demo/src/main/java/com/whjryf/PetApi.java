/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.29).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.whjryf;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Tag(name="pet",description="三大快速的ask的 ")
public interface PetApi {

    @Operation(summary = "Add a new pet to the store", description = "Add a new pet to the store", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/xml", schema = @Schema(implementation = Pet.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/pet",
            produces = { "application/xml", "application/json" },
            consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" },
            method = RequestMethod.POST)
    ResponseEntity<Pet> addPet(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Create a new pet in the store", required=true) @Valid @RequestBody Pet body);


    @Operation(summary = "Deletes a pet", description = "", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid pet value") })
    @RequestMapping(value = "/pet/{petId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePet(@Parameter(in = ParameterIn.PATH, description = "Pet id to delete", required=true, schema=@Schema()) @PathVariable("petId") Long petId, @Parameter(in = ParameterIn.HEADER, description = "" ,schema=@Schema()) @RequestHeader(value="api_key", required=false) String apiKey);


    @Operation(summary = "Finds Pets by status", description = "Multiple status values can be provided with comma separated strings", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/xml", array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),

            @ApiResponse(responseCode = "400", description = "Invalid status value") })
    @RequestMapping(value = "/pet/findByStatus",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Pet>> findPetsByStatus(@Parameter(in = ParameterIn.QUERY, description = "Status values that need to be considered for filter" ,schema=@Schema(allowableValues={ "available", "pending", "sold" }
            , defaultValue="available")) @Valid @RequestParam(value = "status", required = false, defaultValue="available") String status);


    @Operation(summary = "Finds Pets by tags", description = "Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/xml", array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),

            @ApiResponse(responseCode = "400", description = "Invalid tag value") })
    @RequestMapping(value = "/pet/findByTags",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Pet>> findPetsByTags(@Parameter(in = ParameterIn.QUERY, description = "Tags to filter by" ,schema=@Schema()) @Valid @RequestParam(value = "tags", required = false) List<String> tags);


    @Operation(summary = "Find pet by ID", description = "Returns a single pet", security = {
            @SecurityRequirement(name = "api_key"),
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/xml", schema = @Schema(implementation = Pet.class))),

            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "Pet not found") })
    @RequestMapping(value = "/pet/{petId}",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Pet> getPetById(@Parameter(in = ParameterIn.PATH, description = "ID of pet to return", required=true, schema=@Schema()) @PathVariable("petId") Long petId);


    @Operation(summary = "Update an existing pet", description = "Update an existing pet by Id", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/xml", schema = @Schema(implementation = Pet.class))),

            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

            @ApiResponse(responseCode = "404", description = "Pet not found"),

            @ApiResponse(responseCode = "405", description = "Validation exception") })
    @RequestMapping(value = "/pet",
            produces = { "application/xml", "application/json" },
            consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" },
            method = RequestMethod.PUT)
    ResponseEntity<Pet> updatePet(@Parameter(in = ParameterIn.DEFAULT, description = "Update an existent pet in the store", required=true, schema=@Schema()) @Valid @RequestBody Pet body);


    @Operation(summary = "Updates a pet in the store with form data", description = "", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/pet/{petId}",
            method = RequestMethod.POST)
    ResponseEntity<Void> updatePetWithForm(@Parameter(in = ParameterIn.PATH, description = "ID of pet that needs to be updated", required=true, schema=@Schema()) @PathVariable("petId") Long petId, @Parameter(in = ParameterIn.QUERY, description = "Name of pet that needs to be updated" ,schema=@Schema()) @Valid @RequestParam(value = "name", required = false) String name, @Parameter(in = ParameterIn.QUERY, description = "Status of pet that needs to be updated" ,schema=@Schema()) @Valid @RequestParam(value = "status", required = false) String status);


    @Operation(summary = "uploads an image", description = "", security = {
            @SecurityRequirement(name = "petstore_auth", scopes = {
                    "write:pets",
                    "read:pets"        })    }, tags={ "pet" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ModelApiResponse.class))) })
    @RequestMapping(value = "/pet/{petId}/uploadImage",
            produces = { "application/json" },
            consumes = { "application/octet-stream" },
            method = RequestMethod.POST)
    ResponseEntity<ModelApiResponse> uploadFile(@Parameter(in = ParameterIn.PATH, description = "ID of pet to update", required=true, schema=@Schema()) @PathVariable("petId") Long petId, @Parameter(in = ParameterIn.QUERY, description = "Additional Metadata" ,schema=@Schema()) @Valid @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata, @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Object body);

}

