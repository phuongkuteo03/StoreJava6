package poly.store.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.store.dao.OrderDetailDAO;
import poly.store.entity.OrderDetail;
import poly.store.service.OrderDetailService;

@SuppressWarnings("deprecation")
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return orderDetailDAO.save(entity);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return orderDetailDAO.findOne(example);
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return orderDetailDAO.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return orderDetailDAO.findAll(sort);
	}

	@Override
	public List<OrderDetail> findAllById(List<Long> ids) {
		return orderDetailDAO.findAllById(ids);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(List<S> entities) {
		return orderDetailDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		orderDetailDAO.flush();
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return orderDetailDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAllAndFlush(List<S> entities) {
		return orderDetailDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDetailDAO.findAll(example, pageable);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return orderDetailDAO.findById(id);
	}

	@Override
	public void deleteInBatch(List<OrderDetail> entities) {
		orderDetailDAO.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return orderDetailDAO.existsById(id);
	}

	@Override
	public <S extends OrderDetail> long count(Example<S> example) {
		return orderDetailDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(List<OrderDetail> entities) {
		orderDetailDAO.deleteAllInBatch(entities);
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return orderDetailDAO.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(List<Long> ids) {
		orderDetailDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderDetailDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return orderDetailDAO.count();
	}

	@Override
	public void deleteAllInBatch() {
		orderDetailDAO.deleteAllInBatch();
	}

	@Override
	public void deleteById(Long id) {
		orderDetailDAO.deleteById(id);
	}

	@Override
	public OrderDetail getOne(Long id) {
		return orderDetailDAO.getOne(id);
	}

	@Override
	public void delete(OrderDetail entity) {
		orderDetailDAO.delete(entity);
	}

	@Override
	public OrderDetail getById(Long id) {
		return orderDetailDAO.getById(id);
	}

	@Override
	public void deleteAllById(List<? extends Long> ids) {
		orderDetailDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<? extends OrderDetail> entities) {
		orderDetailDAO.deleteAll(entities);
	}

	@Override
	public OrderDetail getReferenceById(Long id) {
		return orderDetailDAO.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		orderDetailDAO.deleteAll();
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return orderDetailDAO.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return orderDetailDAO.findAll(example, sort);
	}
	
}
