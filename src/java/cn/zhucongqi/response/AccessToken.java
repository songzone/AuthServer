/**
 * 
 */
package cn.zhucongqi.response;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.consts.Consts;


/**
 * access_token : The access token issued by the authorization server. <br/>
 * expires_in : The lifetime in seconds of the access token. <br/>
 * refresh_token : he refresh token, which can be used to obtain new
         access tokens using the same authorization grant. <br/>
 * scope : The scope of the access request; <br/>
 * state : The exact value received from the
         client. <br/>
         
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class AccessToken extends Response {
	
	public AccessToken(HttpServletRequest request) {
		super(request);
	}
	
	/**
	 * Set Access　Token
	 * @param accessToken
	 */
	public AccessToken setAccessToken(String accessToken) {
		this.params.put(Consts.AuthConsts.AUTH_ACCESS_TOKEN, accessToken);
		return this;
	}
	
	/**
	 * Set Expires In
	 * @param expiresIn
	 */
	public AccessToken setExpiresIn(String expiresIn) {
		this.params.put(Consts.AuthConsts.AUTH_EXPIRES_IN, expiresIn);
		return this;
	}
	
	/**
	 * Set Refresh Token
	 * @param refreshToken
	 */
	public AccessToken setRefreshToken(String refreshToken) {
		this.params.put(Consts.AuthConsts.AUTH_REFRESH_TOKEN, refreshToken);
		return this;
	}
	
}
