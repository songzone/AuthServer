/**
 * 
 */
package cn.zhucongqi.kit;

import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import cn.zhucongqi.consts.ErrorConsts;
import cn.zhucongqi.exception.AuthProblemException;

import com.jfinal.kit.StrKit;

/**
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class AuthKit {

	private AuthKit() {

	}

	private static AuthProblemException handleInvalidReqAuthProblemException(
			String message) {
		return AuthProblemException.error(
				ErrorConsts.TokenResponse.INVALID_REQUEST).description(message);
	}

	public static boolean hasContentType(String requestContentType,
			String requiredContentType) {
		if (StrKit.isBlank(requiredContentType)
				|| StrKit.isBlank(requestContentType)) {
			return false;
		}
		StringTokenizer tokenizer = new StringTokenizer(requestContentType, ";");
		while (tokenizer.hasMoreTokens()) {
			if (requiredContentType.equals(tokenizer.nextToken())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * handle bad content type
	 * @param expectedContentType
	 * @return
	 */
	public static AuthProblemException handleBadContentTypeException(
			String expectedContentType) {
		StringBuilder errorMsg = new StringBuilder(
				"Bad request content type. Expecting: ")
				.append(expectedContentType);
		return AuthKit
				.handleInvalidReqAuthProblemException(errorMsg.toString());
	}

	/**
	 * handle miss parameter
	 * @param missingParams
	 * @return
	 */
	public static AuthProblemException handleMissingParameters(
			Set<String> missingParams) {
		StringBuilder sb = new StringBuilder("Missing parameters: ");
		if (missingParams != null && !missingParams.isEmpty()) {
			for (String missingParam : missingParams) {
				sb.append(missingParam).append(" ");
			}
		}
		return AuthKit.handleInvalidReqAuthProblemException(sb.toString()
				.trim());
	}

	/**
	 * handle invalid response type
	 * @param validValue
	 * @return
	 */
	public static AuthProblemException handleInvalidResponseTypeValueException(
			String validValue) {
		StringBuilder desc = new StringBuilder(
				"Invalid ResponseType! Valid ResponseType:").append(validValue);
		return AuthProblemException
				.error(ErrorConsts.CodeResponse.UNSUPPORTED_RESPONSE_TYPE)
				.description(desc.toString().trim())
				.responseStatus(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * handle invalid grant type
	 * @param validValue
	 * @return
	 */
	public static AuthProblemException handleInvalidGrantTypeValueException(
			String validValue) {
		StringBuilder desc = new StringBuilder(
				"Invalid GrantType! Valid GrantType:").append(validValue);
		return AuthProblemException
				.error(ErrorConsts.TokenResponse.UNSUPPORTED_GRANT_TYPE)
				.description(desc.toString().trim())
				.responseStatus(HttpServletResponse.SC_FORBIDDEN);
	}
}
