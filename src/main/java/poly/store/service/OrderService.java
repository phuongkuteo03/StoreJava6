package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.fasterxml.jackson.databind.JsonNode;

import poly.store.entity.Order;

public interface OrderService {

	<S extends Order> List<S> findAll(Example<S> example, Sort sort);

	<S extends Order> List<S> findAll(Example<S> example);

	void deleteAll();

	Order getReferenceById(Long id);

	void deleteAll(List<? extends Order> entities);

	void deleteAllById(List<? extends Long> ids);

	Order getById(Long id);

	void delete(Order entity);

	Order getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(List<Long> ids);

	<S extends Order> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Order> entities);

	<S extends Order> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(List<Order> entities);

	Order findById(Long id);

	<S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Order> List<S> saveAllAndFlush(List<S> entities);

	<S extends Order> S saveAndFlush(S entity);

	void flush();

	<S extends Order> List<S> saveAll(List<S> entities);

	List<Order> findAllById(List<Long> ids);

	List<Order> findAll(Sort sort);

	Page<Order> findAll(Pageable pageable);

	List<Order> findAll();

	<S extends Order> Optional<S> findOne(Example<S> example);

	<S extends Order> S save(S entity);

	Order create(JsonNode orderData);

	List<Order> findByUsername(String username);

}
