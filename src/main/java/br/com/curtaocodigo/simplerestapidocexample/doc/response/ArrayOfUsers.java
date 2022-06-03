package br.com.curtaocodigo.simplerestapidocexample.doc.response;

import br.com.curtaocodigo.simplerestapidocexample.model.User;
import java.util.ArrayList;
import org.springframework.validation.annotation.Validated;

/**
 * ArrayOfUsers
 */
@Validated
public class ArrayOfUsers extends ArrayList<User>  {

}