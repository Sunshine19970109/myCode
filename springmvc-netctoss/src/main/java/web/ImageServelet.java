package web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServelet
 */
public class ImageServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServelet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//������Ƭ
		byte[] png = createPng();
		response.setContentType("image/png");
		response.setContentLength(png.length);
		//����Ϣbody�з�����Ϣ����
		response.getOutputStream().write(png);
	}
	/**
	 * ����һ��ͼƬ�����ұ���Ϊpng��ʽ�����ر����Ժ������
	 * @return
	 * @throws IOException 
	 */
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
