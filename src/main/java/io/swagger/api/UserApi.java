/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import org.springframework.core.io.Resource;
import io.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-05-27T12:19:00.614Z")

@Validated
@Api(value = "user", description = "the user API")
@RequestMapping(value = "/v1")
public interface UserApi {

    @ApiOperation(value = "Cadastrar um novo usuário", nickname = "addUser", notes = "", authorizations = {
        @Authorization(value = "user_registration_auth", scopes = {
            @AuthorizationScope(scope = "read:users", description = "ler usuários"),
            @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Usuário cadastrado com sucesso"),
        @ApiResponse(code = 422, message = "Informações inválidas de cadastro de usuário") })
    @RequestMapping(value = "/user",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addUser(@ApiParam(value = "Usuário a ser cadastrado na requisição" ,required=true )  @Valid @RequestBody User body);


    @ApiOperation(value = "Remover um usuário", nickname = "deleteUser", notes = "", authorizations = {
        @Authorization(value = "user_registration_auth", scopes = {
            @AuthorizationScope(scope = "read:users", description = "ler usuários"),
            @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário removido com sucesso"),
        @ApiResponse(code = 400, message = "ID fornecido inválido"),
        @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@ApiParam(value = "ID para remover um usuário",required=true) @PathVariable("userId") Long userId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey);


    @ApiOperation(value = "Buscar usuário por ID", nickname = "getUserById", notes = "Returna um usuário", response = User.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário retornado com sucesso", response = User.class),
        @ApiResponse(code = 400, message = "ID fornecido inválido"),
        @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@ApiParam(value = "ID do usuário a retornar",required=true) @PathVariable("userId") Long userId);


    @ApiOperation(value = "Atualizar um usuário", nickname = "updateUser", notes = "", authorizations = {
        @Authorization(value = "user_registration_auth", scopes = {
            @AuthorizationScope(scope = "read:users", description = "ler usuários"),
            @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
        @ApiResponse(code = 400, message = "ID fornecido inválido"),
        @ApiResponse(code = 404, message = "Usuário não encontrado"),
        @ApiResponse(code = 422, message = "Informações inválidas de atualização de usuário") })
    @RequestMapping(value = "/user",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@ApiParam(value = "Usuário a ser atualizado na requisição" ,required=true )  @Valid @RequestBody User body);


    @ApiOperation(value = "Atualizar informações específicas do usuário", nickname = "updateUserWithForm", notes = "", authorizations = {
        @Authorization(value = "user_registration_auth", scopes = {
            @AuthorizationScope(scope = "read:users", description = "ler usuários"),
            @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
        @ApiResponse(code = 400, message = "ID fornecido inválido"),
        @ApiResponse(code = 404, message = "Usuário não encontrado"),
        @ApiResponse(code = 422, message = "Informações inválidas de atualização de usuário") })
    @RequestMapping(value = "/user/{userId}",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.PATCH)
    ResponseEntity<Void> updateUserWithForm(@ApiParam(value = "ID do usuário que será atualizado",required=true) @PathVariable("userId") Long userId,@ApiParam(value = "Nome do usuário que será atualizado") @RequestParam(value="name", required=false)  String name,@ApiParam(value = "Status do usuário que será atualizado") @RequestParam(value="status", required=false)  String status);


    @ApiOperation(value = "Upload de arquivo de imagem do usuário", nickname = "uploadFile", notes = "", authorizations = {
        @Authorization(value = "user_registration_auth", scopes = {
            @AuthorizationScope(scope = "read:users", description = "ler usuários"),
            @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
        @ApiResponse(code = 400, message = "ID fornecido inválido"),
        @ApiResponse(code = 404, message = "Usuário não encontrado"),
        @ApiResponse(code = 422, message = "Informações inválidas de atualização de usuário") })
    @RequestMapping(value = "/user/{userId}/uploadImage",
        produces = { "application/json" }, 
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<Void> uploadFile(@ApiParam(value = "ID do usuário",required=true) @PathVariable("userId") Long userId,@ApiParam(value = "Dados adicionais a serem informados ao servidor") @RequestParam(value="additionalMetadata", required=false)  String additionalMetadata,@ApiParam(value = "Arquivo de upload") @Valid @RequestPart(value="file", required=false) MultipartFile file);

}