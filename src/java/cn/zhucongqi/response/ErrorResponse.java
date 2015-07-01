/**
 * 
 */
package cn.zhucongqi.response;

import javax.servlet.http.HttpServletRequest;
import cn.zhucongqi.consts.ErrorConsts;
import cn.zhucongqi.exception.AuthProblemException;

/**
 * error : ErrorConsts.CodeResponse <br/>
 * error_description : the erros repsonse description <br/>
 * scope : The scope of the access request; <br/>  
 * state : The exact value received from the
         client.
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class ErrorResponse extends Response {

	public ErrorResponse(HttpServletRequest request) {
		super(request);
	}

	public ErrorResponse(HttpServletRequest request, AuthProblemException e) {
		super(request);
		this.setError(e.getError());
		this.setErrorDescription(e.getDescription());
	}

	/**
	 * Set Error
	 * @param error
	 */
	public ErrorResponse setError(String error) {
		this.params.put(ErrorConsts.AUTH_ERROR, error);
		return this;
	}
	
	/**
	 * Set Error Description
	 * @param errorDecription
	 */
	public ErrorResponse setErrorDescription(String errorDecription) {
		this.params.put(ErrorConsts.AUTH_ERROR_DESCRIPTION, errorDecription);
		return this;
	}
}
