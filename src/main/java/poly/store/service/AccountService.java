package poly.store.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import poly.store.entity.Account;

public interface AccountService {

	<S extends Account> List<S> findAll(Example<S> example, Sort sort);

	<S extends Account> List<S> findAll(Example<S> example);

	void deleteAll();

	Account getReferenceById(String id);

	void deleteAll(List<? extends Account> entities);

	void deleteAllById(List<? extends String> ids);

	Account getById(String id);

	void delete(Account entity);

	Account getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(List<String> ids);

	<S extends Account> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Account> entities);

	<S extends Account> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(List<Account> entities);

	Account findById(String id);

	<S extends Account> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Account> List<S> saveAllAndFlush(List<S> entities);

	<S extends Account> S saveAndFlush(S entity);

	void flush();

	<S extends Account> List<S> saveAll(List<S> entities);

	List<Account> findAllById(List<String> ids);

	List<Account> findAll(Sort sort);

	Page<Account> findAll(Pageable pageable);

	List<Account> findAll();

	<S extends Account> Optional<S> findOne(Example<S> example);

	<S extends Account> S save(S entity);

	List<Account> getAdministrators();
	
	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2);
}
