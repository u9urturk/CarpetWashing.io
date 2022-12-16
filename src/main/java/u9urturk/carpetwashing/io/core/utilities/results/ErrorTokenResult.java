package u9urturk.carpetwashing.io.core.utilities.results;

public class ErrorTokenResult extends TokenResult {

	public ErrorTokenResult(String token, String message) {
		super(token, false, message);
		// TODO Auto-generated constructor stub
	}
	
	public ErrorTokenResult( String message) {
		super(null, false, message);
		// TODO Auto-generated constructor stub
	}

}
