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
		//�ο���19.5.1 Content-Disposition
		response.setHeader("Content-Disposition", 
				"attachment;filename=\"demo.png\"");
		return createPng();
	}
	@RequestMapping(value="upload.do")
	@ResponseBody
	public void upload(
			MultipartFile usefile1,
			MultipartFile usefile2){
		//Spring MVC�п�������MultipartFile
		//�������ص��ļ�!�ļ��е�һ������
		//�����Դ�MultipartFile�������ҵ�
		
		//��ȡ���ص�ԭʼ�ļ���
		//������ʵ���Ի�ȡ�ܶණ���������ļ��������ͣ����ݵ�
		
		String file1 = usefile1.getOriginalFilename();
		String file2 = usefile2.getOriginalFilename();
	}
	
	
	@RequestMapping(value="/excel.do",
			produces="application/oter-stream")
	@ResponseBody
	public byte[] excel(HttpServletResponse response) throws IOException{
		//�ο���19.5.1 Content-Disposition
		response.setHeader("Content-Disposition", 
				"attachment;filename=\"demo.xls\"");
		return createExcel();
	}
	private byte[] createExcel() throws IOException {
		//����������
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����������
		HSSFSheet sheet = workbook.createSheet();
		//����������
		HSSFRow row = sheet.createRow(0);
		//�������еĸ���
		HSSFCell cell = row.createCell(0);
		//Ϊ��������ֵ
		cell.setCellValue("Hello World");
		//��Excel�ļ�����Ϊbyte����
		ByteArrayOutputStream out = 
				new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		return out.toByteArray();
	}
	/*
	 * @ResponseBodyע����Զ��Ĵ������������ֵ
	 * 1�������JavaBean(���飬����)����JSON
	 * 2�������byte���飬��byte����ֱ��װ��
	 * ��Ӧ��ϸ��body
	 */
	//produces="image/png"��������contentType
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
		//��ͼƬ�ϻ�������
		img.setRGB(100, 40, 0xffffff);
		//��ͼƬ����ΪPNG
		//���ֻ�Ƕ�ȡ���ڴ��к��ļ�����ͬ
		ByteArrayOutputStream out = 
				new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		byte[] png = out.toByteArray();
		out.close();
		return png;
	}
}
