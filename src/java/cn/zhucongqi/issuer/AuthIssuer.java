/**
 * 
 */

package cn.zhucongqi.issuer;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public interface AuthIssuer {
	
    public String accessToken();

    public String authorizationCode();

    public String refreshToken();
}
