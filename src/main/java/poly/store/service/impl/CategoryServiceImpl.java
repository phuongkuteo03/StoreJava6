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

import poly.store.dao.CategoryDAO;
import poly.store.entity.Category;
import poly.store.service.CategoryService;

@SuppressWarnings("deprecation")
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public <S extends Category> S save(S entity) {
		return categoryDAO.save(entity);
	}

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryDAO.findOne(example);
	}

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryDAO.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryDAO.findAll(sort);
	}

	@Override
	public List<Category> findAllById(List<String> ids) {
		return categoryDAO.findAllById(ids);
	}

	@Override
	public <S extends Category> List<S> saveAll(List<S> entities) {
		return categoryDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		categoryDAO.flush();
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(List<S> entities) {
		return categoryDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoryDAO.findAll(example, pageable);
	}

	@Override
	public Optional<Category> findById(String id) {
		return categoryDAO.findById(id);
	}

	@Override
	public void deleteInBatch(List<Category> entities) {
		categoryDAO.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return categoryDAO.existsById(id);
	}

	@Override
	public <S extends Category> long count(Example<S> example) {
		return categoryDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(List<Category> entities) {
		categoryDAO.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return categoryDAO.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(List<String> ids) {
		categoryDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return categoryDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return categoryDAO.count();
	}

	@Override
	public void deleteAllInBatch() {
		categoryDAO.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		categoryDAO.deleteById(id);
	}

	@Override
	public Category getOne(String id) {
		return categoryDAO.getOne(id);
	}

	@Override
	public void delete(Category entity) {
		categoryDAO.delete(entity);
	}

	@Override
	public Category getById(String id) {
		return categoryDAO.getById(id);
	}

	@Override
	public void deleteAllById(List<? extends String> ids) {
		categoryDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<? extends Category> entities) {
		categoryDAO.deleteAll(entities);
	}

	@Override
	public Category getReferenceById(String id) {
		return categoryDAO.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		categoryDAO.deleteAll();
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example) {
		return categoryDAO.findAll(example);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return categoryDAO.findAll(example, sort);
	}
	
}
