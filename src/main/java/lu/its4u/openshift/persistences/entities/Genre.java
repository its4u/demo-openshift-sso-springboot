package lu.its4u.openshift.persistences.entities;

/**
 * Genre entity.
 * 
 * @author Jerome CRISTANTE
 *
 */
public class Genre {
	
	private String name;

	public Genre() {
	}

	public Genre(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Genre{" + "name='" + name + '\'' + '}';
	}

	public void setName(String name) {
		this.name = name;
	}
}