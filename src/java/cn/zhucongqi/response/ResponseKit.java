/**
 * 
 */
package cn.zhucongqi.response;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.exception.AuthProblemException;

/**
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class ResponseKit {
	
	public static CodeResponse codeRep(HttpServletRequest request) {
		return (new CodeResponse(request));
	}
	
	public static AccessToken tokenRep(HttpServletRequest request) {
		return (new AccessToken(request));
	}

	public static ErrorResponse errorRep(HttpServletRequest request, AuthProblemException e) {
		return (new ErrorResponse(request,e));
	}
}
