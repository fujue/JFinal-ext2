package cn.zcq.base.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseZcqCopyZz<M extends BaseZcqCopyZz<M>> extends Model<M> implements IBean {

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setUserAddress(java.lang.String userAddress) {
		set("user_address", userAddress);
	}

	public java.lang.String getUserAddress() {
		return get("user_address");
	}

}
