package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.store.entity.Role;

public interface RoleService {

	<S extends Role> List<S> findAll(Example<S> example, Sort sort);

	<S extends Role> List<S> findAll(Example<S> example);

	void deleteAll();

	Role getReferenceById(String id);

	void deleteAll(List<? extends Role> entities);

	void deleteAllById(List<? extends String> ids);

	Role getById(String id);

	void delete(Role entity);

	Role getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(List<String> ids);

	<S extends Role> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Role> entities);

	<S extends Role> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(List<Role> entities);

	Optional<Role> findById(String id);

	<S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Role> List<S> saveAllAndFlush(List<S> entities);

	<S extends Role> S saveAndFlush(S entity);

	void flush();

	<S extends Role> List<S> saveAll(List<S> entities);

	List<Role> findAllById(List<String> ids);

	List<Role> findAll(Sort sort);

	Page<Role> findAll(Pageable pageable);

	List<Role> findAll();

	<S extends Role> Optional<S> findOne(Example<S> example);

	<S extends Role> S save(S entity);

}
