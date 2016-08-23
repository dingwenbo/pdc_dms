package cn.newtouch.dms.vo;

/**
 * Interface Viewable
 * 该接口表明对象具有可转为视图的能力。
 * 
 * @author JiaLong.Wang
 *
 */
public interface Viewable<T> {
	
	void accept(T t);
	
	default void accept(T t, Object... objects) {
		accept(t);
	}
}
