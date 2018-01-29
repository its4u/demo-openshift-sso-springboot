package lu.its4u.openshift.persistences.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Movie entity.
 * 
 * @author Jerome CRISTANTE
 *
 */
@Entity
public class MovieEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	private String name;

	private Double criticRating;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCriticRating() {
		return criticRating;
	}

	public void setCriticRating(Double criticRating) {
		this.criticRating = criticRating;
	}

	@Override
	public String toString() {
		return "MovieEnvity{" + "id=" + id + ", name='" + name + '\'' + ", criticRating=" + criticRating + '}';
	}

}