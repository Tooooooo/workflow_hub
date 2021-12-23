Replace swagger 2 annotations with swagger 3 annotations (it is already included with springdoc-openapi-ui dependency). Package for swagger 3 annotations is io.swagger.v3.oas.annotations.

- @Api → @Tag
- @ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden
- @ApiImplicitParam → @Parameter
- @ApiImplicitParams → @Parameters
- @ApiModel → @Schema
- @ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)
- @ApiModelProperty → @Schema
- @ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")
- @ApiParam → @Parameter
- @ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")

This step is optional: Only if you have multiple Docket beans replace them with GroupedOpenApi beans.

