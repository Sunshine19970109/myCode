package cn.tedu.netctoss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.annotations.MyAnnotation;
import cn.tedu.netctoss.entity.Cost;
@MyAnnotation
@Repository("costDAO")
public interface CostDao {
	public List<Cost> findAllCost();
}
