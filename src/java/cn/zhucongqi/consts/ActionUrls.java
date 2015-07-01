/**
 * 所有的ActionUrls
 */
package cn.zhucongqi.consts;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public final class ActionUrls {

	public static final String BASE_URL = "auth/";
	// authrize url
	public static final String AUTHORIZE_URL = BASE_URL + "authorize";
	// access token url
	public static final String ACCESS_TOKEN_URL = BASE_URL + "access_token";
	// refresh token url
	public static final String REFRESH_TOKEN_URL = BASE_URL + "refresh_token";
	
	private ActionUrls() {
		
	}
	
}
