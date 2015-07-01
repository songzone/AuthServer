/**
 * 
 */
package cn.zhucongqi.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.consts.Consts;
import cn.zhucongqi.consts.ErrorConsts;
import cn.zhucongqi.exception.AuthProblemException;
import cn.zhucongqi.kit.AuthKit;

import com.jfinal.kit.StrKit;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 * @param <T>
 */
public abstract class AuthValidator<T extends HttpServletRequest> {

    protected List<String> requiredParams = new ArrayList<String>();
    protected HashMap<String, String> paramMustValues = new HashMap<String, String>();
    
    public AuthValidator() {
        requiredParams.add(Consts.AuthConsts.AUTH_SCOPE);
        requiredParams.add(Consts.AuthConsts.AUTH_STATE);
        this.paramMustValues();
    }

    public abstract void paramMustValues();
    /**
     * validate method
     * @param request
     * @throws AuthProblemException
     */
    protected void validateMethod(HttpServletRequest request) throws AuthProblemException {
        String method = request.getMethod();
        if (!method.equals(Consts.HttpMethod.GET) && !method.equals(Consts.HttpMethod.POST)) {
            throw AuthProblemException.error(ErrorConsts.CodeResponse.INVALID_REQUEST)
                .description("Method not correct.");
        }
    }

    /**
     * validate content type
     * @param request
     * @throws AuthProblemException
     */
    protected void validateContentType(T request) throws AuthProblemException {
        String contentType = request.getContentType();
        final String expectedContentType = Consts.ContentType.URL_ENCODED;
        if (!AuthKit.hasContentType(contentType, expectedContentType)) {
            throw AuthKit.handleBadContentTypeException(expectedContentType);
        }
    }

    /**
     * validate parameter
     * @param request
     * @throws AuthProblemException
     */
    protected void validateRequiredParameters(T request) throws AuthProblemException {
        final Set<String> missingParameters = new HashSet<String>();
        for (String requiredParam : requiredParams) {
            String val = request.getParameter(requiredParam);
            if (StrKit.isBlank(val)) {
                missingParameters.add(requiredParam);
            }
        }
        if (!missingParameters.isEmpty()) {
            throw AuthKit.handleMissingParameters(missingParameters);
        }
    }
    
    /**
     * validate paramter values
     * @param request
     * @throws AuthProblemException
     */
    protected void validateRequiredParameterValues(T request) throws AuthProblemException {
    	final Set<String> keys = paramMustValues.keySet();
    	for (String key : keys) {
			String param = request.getParameter(key);
			String mustValue = paramMustValues.get(key);
			if (StrKit.notBlank(param) && !mustValue.equals(param)) {
				if (key.equals(Consts.AuthConsts.AUTH_RESPONSE_TYPE)) {
					throw AuthKit.handleInvalidResponseTypeValueException(mustValue);
				} else if (key.endsWith(Consts.AuthConsts.AUTH_GRANT_TYPE)) {
					throw AuthKit.handleInvalidGrantTypeValueException(mustValue);
				}
			}
		}
    }
    
    /**
     * validateClientCredentials
     * @param request
     * @throws AuthProblemException
     */
    protected void validateClientCredentials(T request)
			throws AuthProblemException {
		Set<String> missingParameters = new HashSet<String>();
		if (StrKit.isBlank(request
				.getParameter(Consts.AuthConsts.AUTH_CLIENT_ID))) {
			missingParameters.add(Consts.AuthConsts.AUTH_CLIENT_ID);
		}
		if (StrKit.isBlank(request
				.getParameter(Consts.AuthConsts.AUTH_CLIENT_SECRET))) {
			missingParameters.add(Consts.AuthConsts.AUTH_CLIENT_SECRET);
		}

		if (!missingParameters.isEmpty()) {
			throw AuthKit.handleMissingParameters(missingParameters);
		}
	}

    /**
     * validate request
     * 
     * @param request
     * @throws AuthProblemException
     */
    public void validate(T request) throws AuthProblemException {
        this.validateContentType(request);
        this.validateMethod(request);
        this.validateRequiredParameters(request);
        this.validateRequiredParameterValues(request);
    }
}
