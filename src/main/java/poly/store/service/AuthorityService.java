package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.store.entity.Authority;

public interface AuthorityService {

	<S extends Authority> List<S> findAll(Example<S> example, Sort sort);

	<S extends Authority> List<S> findAll(Example<S> example);

	void deleteAll();

	Authority getReferenceById(Integer id);

	void deleteAll(List<? extends Authority> entities);

	void deleteAllById(List<? extends Integer> ids);

	Authority getById(Integer id);

	void delete(Authority entity);

	Authority getOne(Integer id);

	void deleteById(Integer id);

	void deleteAllInBatch();

	long count();

	<S extends Authority, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(List<Integer> ids);

	<S extends Authority> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Authority> entities);

	<S extends Authority> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteInBatch(List<Authority> entities);

	Optional<Authority> findById(Integer id);

	<S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Authority> List<S> saveAllAndFlush(List<S> entities);

	<S extends Authority> S saveAndFlush(S entity);

	void flush();

	<S extends Authority> List<S> saveAll(List<S> entities);

	List<Authority> findAllById(List<Integer> ids);

	List<Authority> findAll(Sort sort);

	Page<Authority> findAll(Pageable pageable);

	List<Authority> findAll();

	<S extends Authority> Optional<S> findOne(Example<S> example);

	<S extends Authority> S save(S entity);

	List<Authority> findAuthoritiesOfAdministrators();

}
