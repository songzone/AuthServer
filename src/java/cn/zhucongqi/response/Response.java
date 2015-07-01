/**
 * 
 */
package cn.zhucongqi.response;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import cn.zhucongqi.consts.Consts;
import com.jfinal.kit.StrKit;

/**
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public abstract class Response {
	
	protected HashMap<String, String> params = null;
	
	public Response(HttpServletRequest request) {
		this.params = new HashMap<String, String>();
		
		String state = request.getParameter(Consts.AuthConsts.AUTH_STATE);
		if (StrKit.notBlank(state)) {
			this.setState(state);
		}
		
		String scope = request.getParameter(Consts.AuthConsts.AUTH_SCOPE);
		if (StrKit.notBlank(scope)) {
			this.setScope(scope);
		}
	}
	
	private void setState(String state) {
		this.params.put(Consts.AuthConsts.AUTH_STATE, state);
	}
	
	private void setScope(String scope) {
		this.params.put(Consts.AuthConsts.AUTH_SCOPE, scope);
	}
	
	public Object param() {
		return params;
	}
}
