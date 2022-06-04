package br.com.curtaocodigo.simplerestapidocexample.controller;

import br.com.curtaocodigo.simplerestapidocexample.doc.request.CreateUser;
import br.com.curtaocodigo.simplerestapidocexample.doc.request.PatchUser;
import br.com.curtaocodigo.simplerestapidocexample.doc.response.ArrayOfUsers;
import br.com.curtaocodigo.simplerestapidocexample.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@Api(value = "users", description = "the users API",tags = { "users", })
public interface UserController {

    @ApiOperation(value = "Cadastrar um novo usuário", nickname = "addUser", notes = "", authorizations = {
            @Authorization(value = "user_registration_auth", scopes = {
                    @AuthorizationScope(scope = "read:users", description = "ler usuários"),
                    @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário cadastrado com sucesso"),
            @ApiResponse(code = 422, message = "Informações inválidas de cadastro de usuário") })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    Long addUser(@ApiParam(value = "Usuário a ser cadastrado na requisição" ,required=true )  @Valid @RequestBody CreateUser body);


    @ApiOperation(value = "Remover um usuário", nickname = "deleteUser", notes = "", authorizations = {
            @Authorization(value = "user_registration_auth", scopes = {
                    @AuthorizationScope(scope = "read:users", description = "ler usuários"),
                    @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário removido com sucesso"),
            @ApiResponse(code = 400, message = "ID fornecido inválido"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @RequestMapping(value = "/users/{userId}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(@ApiParam(value = "ID para remover um usuário",required=true) @PathVariable("userId") Long userId);


    @ApiOperation(value = "Buscar usuário por ID", nickname = "getUserById", notes = "Returna um usuário", response = User.class, authorizations = {
            @Authorization(value = "api_key")
    }, tags={ "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário retornado com sucesso", response = User.class),
            @ApiResponse(code = 400, message = "ID fornecido inválido"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @RequestMapping(value = "/users/{userId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@ApiParam(value = "ID do usuário a retornar",required=true) @PathVariable("userId") Long userId);


    @ApiOperation(value = "Buscar usuários", nickname = "getUsers", notes = "Retorna usuários", response = ArrayOfUsers.class, authorizations = {
            @Authorization(value = "api_key")
    }, tags={ "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuários retornado com sucesso", response = ArrayOfUsers.class) })
    @RequestMapping(value = "/users",
            produces = { "application/json" },
            method = RequestMethod.GET)
    List<User> getUsers();


    @ApiOperation(value = "Atualizar um usuário", nickname = "updateUser", notes = "", authorizations = {
            @Authorization(value = "user_registration_auth", scopes = {
                    @AuthorizationScope(scope = "read:users", description = "ler usuários"),
                    @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
            @ApiResponse(code = 400, message = "ID fornecido inválido"),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
            @ApiResponse(code = 422, message = "Informações inválidas de atualização de usuário") })
    @RequestMapping(value = "/users/{userId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateUser(@ApiParam(value = "ID do usuário a atualizar",required=true) @PathVariable("userId") Long userId,@ApiParam(value = "Usuário a ser atualizado na requisição" ,required=true )  @Valid @RequestBody User body);


    @ApiOperation(value = "Atualizar informações específicas do usuário", nickname = "updateUserInfo", notes = "Serao atualizados apenas o nome e a idade", authorizations = {
            @Authorization(value = "user_registration_auth", scopes = {
                    @AuthorizationScope(scope = "read:users", description = "ler usuários"),
                    @AuthorizationScope(scope = "write:users", description = "modificar usuários")
            })
    }, tags={ "users", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
            @ApiResponse(code = 400, message = "ID fornecido inválido"),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
            @ApiResponse(code = 422, message = "Informações inválidas de atualização de usuário") })
    @RequestMapping(value = "/users/{userId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PATCH)
    ResponseEntity<Void> updateUserInfo(@ApiParam(value = "ID do usuário a atualizar",required=true) @PathVariable("userId") Long userId,@ApiParam(value = "Usuário a ser atualizado na requisição" ,required=true )  @Valid @RequestBody PatchUser body);

}
