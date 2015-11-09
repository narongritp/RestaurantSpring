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
		return foodDAO.addFood(food);
	}

	@Override
	public int updateFood(FoodBean food) {
		return foodDAO.updateFood(food);
	}

	@Override
	public int deleteFood(int foodId) {
		return foodDAO.deleteFood(foodId);
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
