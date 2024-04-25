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

import poly.store.dao.RoleDAO;
import poly.store.entity.Role;
import poly.store.service.RoleService;

@SuppressWarnings("deprecation")
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleDAO roleDAO;

	@Override
	public <S extends Role> S save(S entity) {
		return roleDAO.save(entity);
	}

	@Override
	public <S extends Role> Optional<S> findOne(Example<S> example) {
		return roleDAO.findOne(example);
	}

	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleDAO.findAll(pageable);
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return roleDAO.findAll(sort);
	}

	@Override
	public List<Role> findAllById(List<String> ids) {
		return roleDAO.findAllById(ids);
	}

	@Override
	public <S extends Role> List<S> saveAll(List<S> entities) {
		return roleDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		roleDAO.flush();
	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		return roleDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends Role> List<S> saveAllAndFlush(List<S> entities) {
		return roleDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleDAO.findAll(example, pageable);
	}

	@Override
	public Optional<Role> findById(String id) {
		return roleDAO.findById(id);
	}

	@Override
	public void deleteInBatch(List<Role> entities) {
		roleDAO.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return roleDAO.existsById(id);
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		return roleDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(List<Role> entities) {
		roleDAO.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		return roleDAO.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(List<String> ids) {
		roleDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return roleDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return roleDAO.count();
	}

	@Override
	public void deleteAllInBatch() {
		roleDAO.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		roleDAO.deleteById(id);
	}

	@Override
	public Role getOne(String id) {
		return roleDAO.getOne(id);
	}

	@Override
	public void delete(Role entity) {
		roleDAO.delete(entity);
	}

	@Override
	public Role getById(String id) {
		return roleDAO.getById(id);
	}

	@Override
	public void deleteAllById(List<? extends String> ids) {
		roleDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<? extends Role> entities) {
		roleDAO.deleteAll(entities);
	}

	@Override
	public Role getReferenceById(String id) {
		return roleDAO.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		roleDAO.deleteAll();
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		return roleDAO.findAll(example);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		return roleDAO.findAll(example, sort);
	}
	
}
