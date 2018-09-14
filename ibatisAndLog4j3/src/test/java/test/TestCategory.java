package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.ysfj.DAO.ICategoryDAO;
import com.ysfj.DAO.Impl.CategoryDAO;
import com.ysfj.entity.Category;
import com.ysfj.entity.Product;

public class TestCategory {
	@Test
	public void testSelectAllProduct() throws SQLException, IOException{
		Logger log = Logger.getLogger(TestCategory.class);
		Properties properties = new Properties();
		properties.load(
				new FileInputStream("src/main/resources/config/log4j.properties"));
		PropertyConfigurator.configure(properties);
		log.debug("hello");
		ICategoryDAO dao = new CategoryDAO();
		Category category = new Category();
		category.setcName("fruit");
		List<Product> list = dao.selectAllProduct(category);
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
