package lu.its4u.openshift.rest.model;

/**
 * Movie model.
 * 
 * @author Jerome CRISTANTE
 *
 */
public class Movie {

	private Long id;

	private String name;

	private Double criticRating;

	public Double getCriticRating() {
		return criticRating;
	}

	public void setCriticRating(Double criticRating) {
		this.criticRating = criticRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Movie{name='" + name + '\'' + ", criticRating=" + criticRating + '}';
	}

}