package model;

public class HealthCheckLogic {
	public void execute(Health health) {
		//BMI計算メソッド
		double weight = health.getWeight();
		double height = health.getHeight();
		double bmi = weight /(height / 100.0 * height /100.0);
		health.setBmi(bmi);
		
		//BMI指数から体型を判定
		String bodyType;
		if(bmi < 18.5) {
			bodyType = "痩せ型";
		}else if(bmi < 25) {
			bodyType = "普通";
		}else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
	}
}
