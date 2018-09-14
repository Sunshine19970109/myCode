package cn.tedu.netctoss.dao;


import cn.tedu.netctoss.annotations.MyAnnotation;
import cn.tedu.netctoss.entity.Admin;
/**
 * ³Ö¾Ã²ã½Ó¿Ú
 * @author dell
 *
 */
@MyAnnotation
public interface AdminDAO {
	public Admin findByAdminCode(String adminCode);
}
