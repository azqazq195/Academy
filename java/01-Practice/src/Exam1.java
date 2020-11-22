import java.util.Map;
import java.util.HashMap;

public class Exam1 {
	public static void main(String[] args) {
		Map<String, Double> productPrice = new HashMap<>();
		
		productPrice.put("Rice", 6.9);
		Double rice = productPrice.get("Rice");
		System.out.println(rice);
	}
}
