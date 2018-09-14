package cn.tedu.netctoss.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.dao.CostDao;
import cn.tedu.netctoss.entity.Cost;
@Service("costService")
public class CostServiceImpl implements CostService {
	@Resource(name="costDAO")
	private CostDao costDAO;
	public List<Cost> findAll() {
		return costDAO.findAllCost();
	}
}
