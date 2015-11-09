package th.co.aware.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import th.co.aware.bean.FoodBean;
import th.co.aware.dao.FoodDAO;

public class FoodServiceImpl implements FoodService{

	@Autowired
	FoodDAO foodDAO;
	
	@Override
	public int addFood(FoodBean food) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFood(FoodBean food) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFood(int foodId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FoodBean getFoodById(int foodId) {
		return foodDAO.getFoodById(foodId);
	}

	@Override
	public List<FoodBean> getFoodByType(String type) {
		return foodDAO.getFoodByType(type);
	}

	@Override
	public List<FoodBean> getAllFood() {
		return foodDAO.getAllFood();
	}

}
