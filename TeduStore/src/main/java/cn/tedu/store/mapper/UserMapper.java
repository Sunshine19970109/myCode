package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.store.bean.User;

@Repository
/**
 * tedustore--UserMapper
 * @author 朱高宏
 *
 */
public interface UserMapper {
	/**
	 * 插入一个用户
	 * @param user
	 */
	public void insertUser(User user);
	/**
	 * 根据用户名来查询用户
	 * @param username
	 * @return 如果查到了就会把记录封装成User对象返回，
	 * 如果没有查到，那么就会返回空null
	 */
	public User selectByUsername(String username);
	/**
	 * 根据id查询用户User
	 * @param id
	 * @return 如果查询到了，就封装为一个User对象返回
	 */
	public User selectUserById(Integer id);
	/**
	 * 通过邮箱查询
	 * @param email
	 * @return 如果存在，那么返回行数
	 * 				如果不存在，返回0
	 */
	public Integer selectByEmail(String email);
	/**
	 * 
	 * @param phone
	 * @return 如果存在返回行数
	 * 				如果不存在返回0
	 */
	public Integer selectByPhone(String phone);
	/**修改用户信息的类
	 * @param user传入要修改的用户信息，密码的修改和其他信息的修改是分开的
	 * 单是这个修改的sql方法可以是一个，直接用mybatis提供的动态修改的方法来修改
	 */
	void updateUser(User user);
	/**
	 * 修改image
	 * @param id
	 * @param image
	 */
	void updateImage(@Param("id")Integer id,@Param("image")String image);
}
