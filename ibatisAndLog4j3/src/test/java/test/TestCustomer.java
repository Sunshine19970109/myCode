package test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.ysfj.DAO.ICustomerDAO;
import com.ysfj.DAO.Impl.CustomerDAO;
import com.ysfj.entity.Customer;
import com.ysfj.entity.QueryConditionArray;
import com.ysfj.entity.QueryConditionList;

public class TestCustomer {
	public static void main(String[] args) {
		
	}
	@Test
	public void testSelectByNameAndCreatedDate() throws SQLException, ParseException{
		ICustomerDAO dao = new CustomerDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2017-02-21");
		System.out.println(date);
		Integer[] ids = new Integer[]{8,9,10,11,12};
		List<Customer> list = 
			dao.selectByNameAndCreatedDate("he", date, ids);
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	//insertCustomer
	@Test
	public void testInsertCustomerr() throws SQLException, ParseException{
		ICustomerDAO dao = new CustomerDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2017-2-17");
		System.out.println(date);
		Customer customer = new Customer(
			"hello", "13132105223@163.com", "Ìì½ò", date);
		dao.insertCustomer(customer);
	}
	@Test
	public void testSelectByIds() throws SQLException{
		ICustomerDAO dao = new CustomerDAO();
		QueryConditionArray array = new QueryConditionArray(
				new Integer[]{5,6}, "selectByIds");
		List<Customer> list = dao.selectByIds(array);
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	@Test
	public void testSelectByIdsList() throws SQLException{
		ICustomerDAO dao = new CustomerDAO();
		Customer c1 = new Customer();
		c1.setId(7);
		Customer c2 = new Customer();
		c2.setId(8);
		List<Customer> lcus = new ArrayList<Customer>();
		lcus.add(c1);lcus.add(c2);
		QueryConditionList  list = new QueryConditionList(lcus, "selectByIdsList");
		List<Customer> res = dao.selectByIdsList(list);
		for (Customer customer : res) {
			System.out.println(customer);
		}
	}
}
