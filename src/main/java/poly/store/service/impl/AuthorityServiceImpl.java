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

import poly.store.dao.AccountDAO;
import poly.store.dao.AuthoriryDAO;
import poly.store.entity.Account;
import poly.store.entity.Authority;
import poly.store.service.AuthorityService;

@SuppressWarnings("deprecation")
@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthoriryDAO authoriryDAO;
	@Autowired
	AccountDAO accountDAO;

	@Override
	public <S extends Authority> S save(S entity) {
		return authoriryDAO.save(entity);
	}

	@Override
	public <S extends Authority> Optional<S> findOne(Example<S> example) {
		return authoriryDAO.findOne(example);
	}

	@Override
	public List<Authority> findAll() {
		return authoriryDAO.findAll();
	}

	@Override
	public Page<Authority> findAll(Pageable pageable) {
		return authoriryDAO.findAll(pageable);
	}

	@Override
	public List<Authority> findAll(Sort sort) {
		return authoriryDAO.findAll(sort);
	}

	@Override
	public List<Authority> findAllById(List<Integer> ids) {
		return authoriryDAO.findAllById(ids);
	}

	@Override
	public <S extends Authority> List<S> saveAll(List<S> entities) {
		return authoriryDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		authoriryDAO.flush();
	}

	@Override
	public <S extends Authority> S saveAndFlush(S entity) {
		return authoriryDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends Authority> List<S> saveAllAndFlush(List<S> entities) {
		return authoriryDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable) {
		return authoriryDAO.findAll(example, pageable);
	}

	@Override
	public Optional<Authority> findById(Integer id) {
		return authoriryDAO.findById(id);
	}

	@Override
	public void deleteInBatch(List<Authority> entities) {
		authoriryDAO.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return authoriryDAO.existsById(id);
	}

	@Override
	public <S extends Authority> long count(Example<S> example) {
		return authoriryDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(List<Authority> entities) {
		authoriryDAO.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Authority> boolean exists(Example<S> example) {
		return authoriryDAO.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(List<Integer> ids) {
		authoriryDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Authority, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return authoriryDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return authoriryDAO.count();
	}

	@Override
	public void deleteAllInBatch() {
		authoriryDAO.deleteAllInBatch();
	}

	@Override
	public void deleteById(Integer id) {
		authoriryDAO.deleteById(id);
	}

	@Override
	public Authority getOne(Integer id) {
		return authoriryDAO.getOne(id);
	}

	@Override
	public void delete(Authority entity) {
		authoriryDAO.delete(entity);
	}

	@Override
	public Authority getById(Integer id) {
		return authoriryDAO.getById(id);
	}

	@Override
	public void deleteAllById(List<? extends Integer> ids) {
		authoriryDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<? extends Authority> entities) {
		authoriryDAO.deleteAll(entities);
	}

	@Override
	public Authority getReferenceById(Integer id) {
		return authoriryDAO.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		authoriryDAO.deleteAll();
	}

	@Override
	public <S extends Authority> List<S> findAll(Example<S> example) {
		return authoriryDAO.findAll(example);
	}

	@Override
	public <S extends Authority> List<S> findAll(Example<S> example, Sort sort) {
		return authoriryDAO.findAll(example, sort);
	}

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountDAO.getAdministrators();
		return authoriryDAO.authoritiesOf(accounts);
	}

}
