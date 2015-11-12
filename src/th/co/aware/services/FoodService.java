package th.co.aware.services;

import java.util.List;

import th.co.aware.bean.FoodBean;

public interface FoodService {
	public int addFood(FoodBean food);
	public int updateFood(FoodBean food);
	public int deleteFood(int foodId);
	public FoodBean getFoodById(int foodId);
	public List<FoodBean> getFoodByType(String type);
	public List<FoodBean> getAllFood();
	public List<String> getFoodType();
}
