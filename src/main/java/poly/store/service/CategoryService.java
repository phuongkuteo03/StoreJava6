package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.store.entity.Category;

public interface CategoryService {

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> List<S> findAll(Example<S> example);

	void deleteAll();

	Category getReferenceById(String id);

	void deleteAll(List<? extends Category> entities);

	void deleteAllById(List<? extends String> ids);

	Category getById(String id);

	void delete(Category entity);

	Category getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(List<String> ids);

	<S extends Category> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Category> entities);

	<S extends Category> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(List<Category> entities);

	Optional<Category> findById(String id);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Category> List<S> saveAllAndFlush(List<S> entities);

	<S extends Category> S saveAndFlush(S entity);

	void flush();

	<S extends Category> List<S> saveAll(List<S> entities);

	List<Category> findAllById(List<String> ids);

	List<Category> findAll(Sort sort);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll();

	<S extends Category> Optional<S> findOne(Example<S> example);

	<S extends Category> S save(S entity);

}
