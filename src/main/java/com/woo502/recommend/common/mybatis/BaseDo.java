package com.woo502.recommend.common.mybatis;

/**
 * 
 * @author Admin
 *
 */
public class BaseDo implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4360974749630002468L;
	
	/**
	 * 分表的后缀
	 */
	private String _sebTableIndex;

	public String get_sebTableIndex() {
		return _sebTableIndex;
	}

	public void set_sebTableIndex(String _sebTableIndex) {
		this._sebTableIndex = _sebTableIndex;
	}
}
