package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NetctossController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("toIndex.do")
	public String index(){
		return "index";
	}
	@RequestMapping(value="/downloadimg.do",
			produces="application/oter-stream")
	@ResponseBody
	public byte[] downloadimg(HttpServletResponse response) throws IOException{
		//参考：19.5.1 Content-Disposition
		response.setHeader("Content-Disposition", 
				"attachment;filename=\"demo.png\"");
		return createPng();
	}
	@RequestMapping(value="upload.do")
	@ResponseBody
	public void upload(
			MultipartFile usefile1,
			MultipartFile usefile2){
		//Spring MVC中可以利用MultipartFile
		//接收上载的文件!文件中的一切数据
		//都可以从MultipartFile对象中找到
		
		//获取上载的原始文件名
		//这里其实可以获取很多东西，比如文件名，类型，数据等
		
		String file1 = usefile1.getOriginalFilename();
		String file2 = usefile2.getOriginalFilename();
	}
	
	
	@RequestMapping(value="/excel.do",
			produces="application/oter-stream")
	@ResponseBody
	public byte[] excel(HttpServletResponse response) throws IOException{
		//参考：19.5.1 Content-Disposition
		response.setHeader("Content-Disposition", 
				"attachment;filename=\"demo.xls\"");
		return createExcel();
	}
	private byte[] createExcel() throws IOException {
		//创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = workbook.createSheet();
		//创建数据行
		HSSFRow row = sheet.createRow(0);
		//创建行中的格子
		HSSFCell cell = row.createCell(0);
		//为格子设置值
		cell.setCellValue("Hello World");
		//将Excel文件保存为byte数组
		ByteArrayOutputStream out = 
				new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		return out.toByteArray();
	}
	/*
	 * @ResponseBody注解会自动的处理控制器返回值
	 * 1、如果是JavaBean(数组，集合)返回JSON
	 * 2、如果是byte数组，则将byte数组直接装入
	 * 响应详细的body
	 */
	//produces="image/png"用于设置contentType
	@RequestMapping(value="user/image.do",
			produces="image/png")
	@ResponseBody
	public byte[] image() {
		try {
			return createPng();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private byte[] createPng() throws IOException{
		BufferedImage img = 
				new BufferedImage(200, 80,
				BufferedImage.TYPE_3BYTE_BGR);
		//在图片上绘制内容
		img.setRGB(100, 40, 0xffffff);
		//将图片编码为PNG
		//这个只是读取到内存中和文件流不同
		ByteArrayOutputStream out = 
				new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		byte[] png = out.toByteArray();
		out.close();
		return png;
	}
}
