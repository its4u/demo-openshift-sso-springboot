package lu.its4u.openshift.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lu.its4u.openshift.persistences.entities.MovieEntity;

/**
 * Movie repository.
 * 
 * @author Jerome CRISTANTE
 *
 */
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {

	/**
	 * Find all movies with given name (like function).
	 * 
	 * @param name
	 *            Name to find
	 * @return List of movies
	 */
	List<MovieEntity> findByNameLike(String name);

	/**
	 * Get top 5 movies with highest rating.
	 * 
	 * @return List of Movies
	 */
	List<MovieEntity> findTop5ByOrderByCriticRatingDesc();

}