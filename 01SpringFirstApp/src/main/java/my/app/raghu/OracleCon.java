package my.app.raghu;

public class OracleCon {
	private String driver;
	private String url;
	
	public OracleCon() {
		super();
	}
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "OracleCon [driver=" + driver + ", url=" + url + "]";
	}
	
	
}
