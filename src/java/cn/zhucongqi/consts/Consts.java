/**
 * 所有系统中用到的常量
 */
package cn.zhucongqi.consts;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public final class Consts {

	private Consts() {
		
	}
	
	/**
	 * HttpMethod
	 * @author BruceZCQ [zcq@zhucongqi.cn]
	 * @version
	 */
    public static final class HttpMethod {
        public static final String POST = "POST";
        public static final String GET = "GET";
        public static final String DELETE = "DELETE";
        public static final String PUT = "PUT";
    }

    /**
     * HeaderType
     * @author BruceZCQ [zcq@zhucongqi.cn]
     * @version
     */
    public static final class HeaderType {
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
        public static final String AUTHORIZATION = "Authorization";
    }
    
    /**
     * ContentType
     * @author BruceZCQ [zcq@zhucongqi.cn]
     * @version
     */
    public static final class ContentType {
        public static final String URL_ENCODED = "application/x-www-form-urlencoded";
        public static final String JSON = "application/json";
    }
    
    /**
     * AuthConsts
     * @author BruceZCQ [zcq@zhucongqi.cn]
     * @version
     */
    public static final class AuthConsts {
    	public static final String AUTH_RESPONSE_TYPE = "response_type";
        public static final String AUTH_CLIENT_ID = "client_id";
        public static final String AUTH_CLIENT_SECRET = "client_secret";
        public static final String AUTH_USERNAME = "username";
        public static final String AUTH_PASSWORD = "password";
        public static final String AUTH_SCOPE = "scope";
        public static final String AUTH_STATE = "state";
        public static final String AUTH_GRANT_TYPE = "grant_type";
        public static final String AUTH_CODE = "code";
        public static final String AUTH_ACCESS_TOKEN = "access_token";
        public static final String AUTH_EXPIRES_IN = "expires_in";
        public static final String AUTH_REFRESH_TOKEN = "refresh_token";
    }
    
    /**
     * GrantTypeConsts <br/>
     * @author BruceZCQ [zcq@zhucongqi.cn]
     * @version
     */
    public static final class GrantType {
    	// authorization & code validate
    	public static final String ACCESS_TOKEN = "access_token";
    	public static final String REFRESH_TOKEN = "refresh_token";
    }
    
    /**
     * ResponseTypeConsts <br/>
     * @author BruceZCQ [zcq@zhucongqi.cn]
     * @version
     */
    public static final class ResponseType {
    	public static final String CODE = "code";
    	public static final String TOKEN = "token";
    }
}
