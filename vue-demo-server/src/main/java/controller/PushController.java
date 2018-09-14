package controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Client;
import entity.News;
import entity.ResponseResult;
import entity.User;
import service.PushService;

@Controller
@RequestMapping("/push")
public class PushController {
	@Resource(name="userPushService")
	private PushService userPushService;
	
	@Resource(name="newsPushService")
	private PushService newsPushServiceImpl;
	
	@RequestMapping("/userPush.do")
	@ResponseBody
	/**
	 * �û�����
	 * @param info
	 * @return
	 */
	public ResponseResult<User> userPush(String name,String password){
		User info = new User(name,password);
		System.out.println(info);
		ResponseResult<User> result = null;
		try {
			userPushService.push(info);
			result = new ResponseResult<User>(1, "�����û���Ϣ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseResult<User>(0, e.getMessage());
		}	
		return result;
	}
	
	/**
	 * ��������
	 */
	@RequestMapping("/newsPush.do")
	@ResponseBody
	public ResponseResult<News> newsPush(String title,String content,String author){
//		try {
//			//������Ա�������
//			//content = new String(content.getBytes("ISO8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
		News news = new News(title, content, author);
		System.out.println(news);
		System.out.println(news);
		ResponseResult<News> result =null;
		try {
			newsPushServiceImpl.push(news);
			result = new ResponseResult<News>(1, "�������ųɹ�");
			result.setData(news);
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseResult<News>(0,"��������ʧ��");
		}
		return result;
	}
	
	/**
	 * �ͻ�����
	 */
	@RequestMapping("/clientPush.do")
	@ResponseBody
	public ResponseResult<Client> clientPush(Client news){
		return null;
	}
}