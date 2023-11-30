package prob1;

public class Product {
	private String code;
	
	public Product(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return "code=" + code;
	}
}
