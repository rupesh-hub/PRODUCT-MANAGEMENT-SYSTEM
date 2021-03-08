package com.rupesh.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.rupesh.app.model.Employee;
import com.rupesh.app.model.EmployeePage;
import com.rupesh.app.model.EmployeeSearchCriteria;

@Repository
public class EmployeeCriteriaRepository {

	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;

	public EmployeeCriteriaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
	}

	public Page<Employee> findAllWithFilters(EmployeePage employeePage, EmployeeSearchCriteria searchCriteria) {
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
		Predicate predicate = getPredicate(searchCriteria, employeeRoot);
		criteriaQuery.where(predicate);
		setOrder(employeePage, criteriaQuery, employeeRoot);
		TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(employeePage.getPageNumber() * employeePage.getPageSize());
		typedQuery.setMaxResults(employeePage.getPageSize());
		Pageable pageable = getPageable(employeePage);
		long employeesCount = getEmployeesCount(predicate);
		return new PageImpl<>(typedQuery.getResultList(), pageable, employeesCount);
	}

	private Predicate getPredicate(EmployeeSearchCriteria searchCriteria, Root<Employee> employeeRoot) {
		List<Predicate> predicates = new ArrayList<>();
		if (Objects.nonNull(searchCriteria.getFirstName()))
			searchCriteria.setFirstName(this.convertor(searchCriteria.getFirstName()));
		if (Objects.nonNull(searchCriteria.getLastName()))
			searchCriteria.setLastName(this.convertor(searchCriteria.getLastName()));

		if (Objects.nonNull(searchCriteria.getLastName()))
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(employeeRoot.get("lastName")),
					"%" + searchCriteria.getLastName() + "%"));

		if (Objects.nonNull(searchCriteria.getFirstName()))
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(employeeRoot.get("firstName")),
					"%" + searchCriteria.getFirstName() + "%"));

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

	private void setOrder(EmployeePage employeePage, CriteriaQuery<Employee> criteriaQuery,
			Root<Employee> employeeRoot) {
		if (employeePage.getSortDirection().equals(Sort.Direction.ASC)) 
			criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(employeePage.getSortBy())));
		else
			criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(employeePage.getSortBy())));
	}

	private Pageable getPageable(EmployeePage employeePage) {
		Sort sort = Sort.by(employeePage.getSortDirection(), employeePage.getSortBy());
		return PageRequest.of(employeePage.getPageNumber(), employeePage.getPageSize(), sort);
	}

	private long getEmployeesCount(Predicate predicate) {
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<Employee> countRoot = countQuery.from(Employee.class);
		countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
		return entityManager.createQuery(countQuery).getSingleResult();
	}

	private String convertor(String value) {
		return value.toLowerCase();
	}
}