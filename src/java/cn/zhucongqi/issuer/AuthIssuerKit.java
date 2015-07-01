/**
 * 
 */

package cn.zhucongqi.issuer;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class AuthIssuerKit implements AuthIssuer {

    private ValueGenerator vg;
    
    public static AuthIssuerKit md5Issuer() {
    	return (new AuthIssuerKit(new MD5Generator()));
    }
    
    public static AuthIssuerKit uuidIssuer() {
    	return (new AuthIssuerKit(new UUIDValueGenerator()));
    }

    private AuthIssuerKit(ValueGenerator vg) {
        this.vg = vg;
    }

    public String accessToken() {
        return vg.generateValue();
    }

    public String refreshToken() {
        return vg.generateValue();
    }

    public String authorizationCode() {
        return vg.generateValue();
    }
}
