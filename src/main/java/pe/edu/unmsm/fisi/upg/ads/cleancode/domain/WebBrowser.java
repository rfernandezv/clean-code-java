package pe.edu.unmsm.fisi.upg.ads.cleancode.domain;

public class WebBrowser {
	private BrowserName name;
	private int majorVersion;
        
        public WebBrowser(BrowserName browser, int majorVersion) {
		this.name = browser;
		this.majorVersion = majorVersion;
	}

	public enum BrowserName {
		Unknown, InternetExplorer, Firefox, Chrome, Opera, Safari, Dolphin, Konqueror, Linx
	}

	public BrowserName getName() {
		return name;
	}

	public void setName(BrowserName name) {
		this.name = name;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

}