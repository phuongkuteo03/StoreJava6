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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import poly.store.dao.AccountDAO;
import poly.store.entity.Account;
import poly.store.service.AccountService;

@SuppressWarnings("deprecation")
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public <S extends Account> S save(S entity) {
		return accountDAO.save(entity);
	}

	@Override
	public <S extends Account> Optional<S> findOne(Example<S> example) {
		return accountDAO.findOne(example);
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountDAO.findAll(pageable);
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountDAO.findAll(sort);
	}

	@Override
	public List<Account> findAllById(List<String> ids) {
		return accountDAO.findAllById(ids);
	}

	@Override
	public <S extends Account> List<S> saveAll(List<S> entities) {
		return accountDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		accountDAO.flush();
	}

	@Override
	public <S extends Account> S saveAndFlush(S entity) {
		return accountDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends Account> List<S> saveAllAndFlush(List<S> entities) {
		return accountDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		return accountDAO.findAll(example, pageable);
	}

	@Override
	public Account findById(String id) {
		return accountDAO.findById(id).get();
	}

	@Override
	public void deleteInBatch(List<Account> entities) {
		accountDAO.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return accountDAO.existsById(id);
	}

	@Override
	public <S extends Account> long count(Example<S> example) {
		return accountDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(List<Account> entities) {
		accountDAO.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Account> boolean exists(Example<S> example) {
		return accountDAO.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(List<String> ids) {
		accountDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return accountDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return accountDAO.count();
	}

	@Override
	public void deleteAllInBatch() {
		accountDAO.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		accountDAO.deleteById(id);
	}

	@Override
	public Account getOne(String id) {
		return accountDAO.getOne(id);
	}

	@Override
	public void delete(Account entity) {
		accountDAO.delete(entity);
	}

	@Override
	public Account getById(String id) {
		return accountDAO.getById(id);
	}

	@Override
	public void deleteAllById(List<? extends String> ids) {
		accountDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<? extends Account> entities) {
		accountDAO.deleteAll(entities);
	}

	@Override
	public Account getReferenceById(String id) {
		return accountDAO.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		accountDAO.deleteAll();
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		return accountDAO.findAll(example);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		return accountDAO.findAll(example, sort);
	}

	@Override
	public List<Account> getAdministrators() {
		return accountDAO.getAdministrators();
	}

	@Override
	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
//		String fullname = oauth2.getPrincipal().getAttribute("name");
		String email = oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());

		UserDetails user = User.withUsername(email)
				.password(pe.encode(password)).roles("CUST").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
