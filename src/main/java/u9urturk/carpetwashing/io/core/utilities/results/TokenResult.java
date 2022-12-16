package u9urturk.carpetwashing.io.core.utilities.results;

public class TokenResult extends Result {
	
	private String token;
	
	public TokenResult(String token,boolean success, String message) {
		super(success, message);
		this.token = token;
		// TODO Auto-generated constructor stub
	}
	
	public TokenResult(boolean success) {
		super(success);
		// TODO Auto-generated constructor stub
	}
	
	public String getToken() {
		return this.token;
	}

}
