package lu.its4u.openshift.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lu.its4u.openshift.persistence.repositories.MovieRepository;
import lu.its4u.openshift.persistences.entities.MovieEntity;
import lu.its4u.openshift.rest.model.Movie;

/**
 * Rest API for movies management.
 * 
 * @author jerome.cristante
 *
 */
@RestController
@RequestMapping("/api")
public class MovieController {

	/**
	 * Movies repositories.
	 */
	@Autowired
	private MovieRepository movieRepository;

	/**
	 * Create a movie.
	 * 
	 * @param movie
	 *            Movie to create
	 * @return created movie
	 */
	@RequestMapping(path = "/movies", method = RequestMethod.POST)
	public @ResponseBody MovieEntity createMovie(@RequestBody Movie movie) {
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setName(movie.getName());
		movieEntity.setCriticRating(5.0);
		return movieRepository.save(movieEntity);
	}

	/**
	 * Get all movies.
	 * 
	 * @return all movies
	 */
	@RequestMapping(path = "movies", method = RequestMethod.GET)
	public @ResponseBody Iterable<Movie> getMovies() {
		Iterable<MovieEntity> movieEntities = movieRepository.findAll();

		List<Movie> movies = new ArrayList<>();
		for (MovieEntity movieEntity : movieEntities) {
			Movie movie = new Movie();
			movie.setId(movieEntity.getId());
			movie.setName(movieEntity.getName());
			movie.setCriticRating(movieEntity.getCriticRating());
			movies.add(movie);
		}

		return movies;
	}

	/**
	 * Consul a movie with given ID.
	 * 
	 * @param movieId
	 *            Id of the movie
	 * @return Movie
	 */
	@RequestMapping(path = "/movies/{movieId}", method = RequestMethod.GET)
	public @ResponseBody MovieEntity consultMovie(@PathVariable String movieId) {
		return movieRepository.findOne(Long.valueOf(movieId));
	}

	/**
	 * Delete movie with given ID.
	 * 
	 * @param movieId
	 *            Id of the movie
	 */
	@RequestMapping(path = "/movies/{movieId}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteMovie(@PathVariable String movieId) {
		movieRepository.delete(Long.valueOf(movieId));
	}

	/**
	 * Update movie with given ID
	 * 
	 * @param movieId
	 *            Id of the movie
	 * @param movie
	 *            Movie
	 * @return Update movie
	 */
	@RequestMapping(path = "/movies/{movieId}", method = RequestMethod.PUT)
	public @ResponseBody MovieEntity updateMovie(@PathVariable String movieId, @RequestBody Movie movie) {

		MovieEntity movieEntity = movieRepository.findOne(Long.valueOf(movieId));
		movieEntity.setName(movie.getName());
		movieEntity.setCriticRating(movie.getCriticRating());

		return movieRepository.save(movieEntity);
	}

	/**
	 * Get top 5 movies with highest rating.
	 * 
	 * @return top 5 movies with highest rating.
	 */
	@RequestMapping(path = "/moviesTop5", method = RequestMethod.GET)
	public @ResponseBody Iterable<Movie> getTopMovies() {

		Iterable<MovieEntity> movieEntities = movieRepository.findTop5ByOrderByCriticRatingDesc();

		List<Movie> movies = new ArrayList<>();
		for (MovieEntity movieEntity : movieEntities) {
			Movie movie = new Movie();
			movie.setId(movieEntity.getId());
			movie.setName(movieEntity.getName());
			movie.setCriticRating(movieEntity.getCriticRating());
			movies.add(movie);
		}

		return movies;
	}

	/**
	 * Search movies by name (like function).
	 * 
	 * @param name
	 *            Name to search
	 * @return Movies matching given name
	 */
	@RequestMapping(path = "/moviesByName/{name}", method = RequestMethod.GET)
	public @ResponseBody Iterable<Movie> searchMovieByName(@PathVariable String name) {

		Iterable<MovieEntity> movieEntities = movieRepository.findByNameLike(name);

		List<Movie> movies = new ArrayList<>();
		for (MovieEntity movieEntity : movieEntities) {
			Movie movie = new Movie();
			movie.setId(movieEntity.getId());
			movie.setName(movieEntity.getName());
			movie.setCriticRating(movieEntity.getCriticRating());
			movies.add(movie);
		}

		return movies;
	}

}