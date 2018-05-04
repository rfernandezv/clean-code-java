package pe.edu.unmsm.fisi.upg.ads.cleancode.domain;

import java.util.List;
import pe.edu.unmsm.fisi.upg.ads.cleancode.domain.WebBrowser.BrowserName;

import pe.edu.unmsm.fisi.upg.ads.cleancode.exceptions.HandlerException;

public class Speaker {
	private String firstName;
	private String lastName;
	private String email;
	private int experience;
	private boolean hasBlog;
	private String blogURL;
	private WebBrowser browser;
	private List<String> certifications;
	private String employer;
	private int registrationFee;
	private List<Session> sessions;

	public Integer register(IRepository repository) throws Exception {
		Integer speakerId = null;
                
		validateDataRegister();
                
                this.registrationFee = assigRegistrationFee(this.experience);
                speakerId = repository.saveSpeaker(this);
			
        	return speakerId;
	}
        
        public void validateDataRegister() throws Exception {
            boolean haveStandard;
            boolean isApproved = false;
            int minimumExperience = 10;
            int minimumCertification = 3;
            int maximumVersionWebBrowser = 9;
                
            if (this.firstName.isEmpty()) throw new IllegalArgumentException("First Name is required");
            if (this.lastName.isEmpty()) throw new IllegalArgumentException("Last name is required.");
            if (this.email.isEmpty()) throw new IllegalArgumentException("Email is required.");	 
            if (this.sessions.isEmpty()) throw new IllegalArgumentException("Can't register speaker with no sessions to present.");
            
            haveStandard = ((this.experience > minimumExperience || this.hasBlog || this.certifications.size() > minimumCertification || Company.containsCompany(this.employer)));

            if (!haveStandard) {
                String emailDomain = getDomainFromEmail(this.email);
                haveStandard = !Domain.domains.contains(emailDomain) && (!(browser.getName() == BrowserName.InternetExplorer && browser.getMajorVersion() < maximumVersionWebBrowser));
            }
            if (!haveStandard) throw new HandlerException("Speaker doesn't meet our abitrary and capricious standards.");
            for (Session session : sessions) {
                validateApprovedSession(session);
                if(session.isApproved()){
                   isApproved = true; 
                }
            }
            if(!isApproved) throw new HandlerException("No sessions approved.");
        }
        
        public void validateApprovedSession(Session session){
            session.setApproved(true);
            for (String tech : Technology.technologies) {                
                if (session.getTitle().contains(tech) || session.getDescription().contains(tech)) {
                        session.setApproved(false);
                        break;
                }
            }
        }
        
        public String getDomainFromEmail(String emailParameter){
            String[] splitted = emailParameter.split("@");
            return splitted[splitted.length - 1];
        }        
        
        public int assigRegistrationFee(int experienceParameter){
            if (experienceParameter <= 1) {
                return 500;
            }
            if (experienceParameter >= 2 && experienceParameter <= 3) {
                return 250;
            }
            if (experienceParameter >= 4 && experienceParameter <= 5) {
                return 100;
            }
            if (experienceParameter >= 6 && experienceParameter <= 9) {
                return 50;
            }
            return 0;
        }

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isHasBlog() {
		return hasBlog;
	}

	public void setHasBlog(boolean hasBlog) {
		this.hasBlog = hasBlog;
	}

	public String getBlogURL() {
		return blogURL;
	}

	public void setBlogURL(String blogURL) {
		this.blogURL = blogURL;
	}

	public WebBrowser getBrowser() {
		return browser;
	}

	public void setBrowser(WebBrowser browser) {
		this.browser = browser;
	}

	public List<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<String> certifications) {
		this.certifications = certifications;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public int getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(int registrationFee) {
		this.registrationFee = registrationFee;
	}
}