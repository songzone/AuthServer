/**
 * JFinal 的配置信息
 */
package cn.zhucongqi.cfg;

import cn.zhucongqi.data.DataKit;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext2.config.JFinalConfigExt;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * 
 * @author BruceZCQ [zcq@zhucongqi.cn]
 * @version
 */
public class Config extends JFinalConfigExt {
	
	public void afterJFinalStarted(){
		//初始化数据
		DataKit.init();
	}

	@Override
	public void configMoreConstants(Constants me) {
		// do more Constants config
	}

	@Override
	public void configMoreRoutes(Routes me) {
		// config more routes
	}

	@Override
	public void configMorePlugins(Plugins me) {
		// config more plugins
	}

	@Override
	public void configTablesMapping(ActiveRecordPlugin arp) {
		// mapping table
	}

	@Override
	public void configMoreInterceptors(Interceptors me) {
		// config more interceptors
	}

	@Override
	public void configMoreHandlers(Handlers me) {
		// config more handlers
	}

}
