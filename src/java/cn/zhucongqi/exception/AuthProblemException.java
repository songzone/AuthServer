/**
 * 
 */

package cn.zhucongqi.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.jfinal.kit.StrKit;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class AuthProblemException extends IllegalArgumentException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1536483571040822380L;
	private String error;
    private String description;

    private int responseStatus;

    private Map<String, String> parameters = new HashMap<String, String>();

    protected AuthProblemException(String error) {
        this(error, "");
    }

    protected AuthProblemException(String error, String description) {
        super(error + " " + description);
        this.description = description;
        this.error = error;
    }

    public static AuthProblemException error(String error) {
        return new AuthProblemException(error);
    }

    public static AuthProblemException error(String error, String description) {
        return new AuthProblemException(error, description);
    }

    public AuthProblemException description(String description) {
        this.description = description;
        return this;
    }

    public AuthProblemException responseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
        return this;
    }

    public AuthProblemException setParameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    public int getResponseStatus() {
        return responseStatus == 0 ? HttpServletResponse.SC_BAD_REQUEST : responseStatus;
    }

    public String get(String name) {
        return parameters.get(name);
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public String getMessage() {
        StringBuilder b = new StringBuilder();
        if (StrKit.notBlank(error)) {
            b.append(error);
        }

        if (StrKit.notBlank(description)) {
            b.append(", ").append(description);
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return "OAuthProblemException{" +
                "error='" + error + '\'' +
                ", description='" + description + '\'' +
                ", responseStatus=" + responseStatus +
                ", parameters=" + parameters +
                '}';
    }
}
