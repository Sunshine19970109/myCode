package cn.tedu.netctoss.dao;


import cn.tedu.netctoss.annotations.MyAnnotation;
import cn.tedu.netctoss.entity.Admin;
/**
 * �־ò�ӿ�
 * @author dell
 *
 */
@MyAnnotation
public interface AdminDAO {
	public Admin findByAdminCode(String adminCode);
}
