/**
 * 
 */
package cn.zhucongqi.response;

import javax.servlet.http.HttpServletRequest;

import cn.zhucongqi.consts.Consts;

/**
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class CodeResponse extends Response {

	public CodeResponse(HttpServletRequest request) {
		super(request);
	}

	/**
	 * Set code
	 * @param code
	 */
	public CodeResponse setCode(String code) {
		this.params.put(Consts.AuthConsts.AUTH_CODE, code);
		return this;
	}
}
