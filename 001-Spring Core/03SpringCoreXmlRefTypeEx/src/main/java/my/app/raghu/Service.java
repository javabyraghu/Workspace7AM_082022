package my.app.raghu;

public class Service {

	private Repository repo;

	public Service() {
		super();
	}

	public Repository getRepo() {
		return repo;
	}

	public void setRepo(Repository repo) {
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "Service [repo=" + repo + "]";
	}
	
	
}
