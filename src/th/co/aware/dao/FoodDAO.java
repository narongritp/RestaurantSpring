package th.co.aware.dao;

import java.util.List;

import th.co.aware.bean.FoodBean;

public interface FoodDAO {
	public int addFood(FoodBean food);
	public int updateFood(FoodBean food);
	public int deleteFood(int foodId);
	public FoodBean getFoodById(int foodId);
	public List<String> getFoodType();
	public List<FoodBean> getFoodByType(String type);
	public List<FoodBean> getAllFood();
}
