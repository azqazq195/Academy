package anno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood")
public class MyFoodMgr {
	// @Qualifier("unFavoriteFood") : 특정 빈 객체를 설정할 때 사용
	@Autowired
	@Qualifier("favoriteFood1")
	private Food favoriteFood;
	@Autowired
	@Qualifier("unFavoriteFood1")
	private Food unFavoriteFood;
	
	@Override
	public String toString() {
		return "MyFoodMgr [favoriteFood=" + favoriteFood.toString() + ",\n unFavoriteFood=" + unFavoriteFood + "]";
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}
	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}	
}
