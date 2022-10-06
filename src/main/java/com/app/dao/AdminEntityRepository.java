package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.CustomerEntity;
@Repository
public class AdminEntityRepository {
@Autowired
private EntityManager mgr;

//select c.clubId.id from CustomerEntity c join c.planId pt join c.clubId group by c.clubId.id order by c.clubId.id
public List<Long> NumberofCustomerInFrachise(){
	String jpql="select count(c.clubId.id) from CustomerEntity c group by c.clubId.id order by c.clubId.id";
			return mgr.createQuery(jpql, Long.class).getResultList();
}

public List<String> Nameforcustomerinfrachise(){
	String jpql="select c.clubId.clubName from CustomerEntity c group by c.clubId.id order by c.clubId.id";
			return mgr.createQuery(jpql, String.class).getResultList();
}

public List<CustomerEntity> Allcustomer(){
	String jpql="select c from CustomerEntity c";
			return mgr.createQuery(jpql, CustomerEntity.class).getResultList();
}
public List<String> planName(){
	String jpql = "select c.planId.planName from CustomerEntity c group by c.planId.id order by c.planId.id";
	return mgr.createQuery(jpql,String.class ).getResultList();
}

public List<Long> customerInPlanCount(){
	String jpql = "select count(c.planId.planName) from CustomerEntity c group by c.planId.id order by c.planId.id";
	return mgr.createQuery(jpql, Long.class).getResultList();
}
public List<CustomerEntity> customCustomer(long l,long m){
	String jpql="select c from CustomerEntity c where c.planId.id=:pid and c.clubId.id=:cid";
	return mgr.createQuery(jpql, CustomerEntity.class).setParameter("pid",m).setParameter("cid", l).getResultList();
}
public List<CustomerEntity> customCustomerClub(long cid){
	String jpql="select c from CustomerEntity c where c.clubId.id=:cid";
	return mgr.createQuery(jpql, CustomerEntity.class).setParameter("cid",cid).getResultList();
}
public List<CustomerEntity> customCustomerPlan(long pid){
	String jpql="select c from CustomerEntity c where c.planId.id=:pid";
	return mgr.createQuery(jpql, CustomerEntity.class).setParameter("pid",pid).getResultList();
}
}
