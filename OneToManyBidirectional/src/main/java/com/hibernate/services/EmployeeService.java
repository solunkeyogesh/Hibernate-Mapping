package com.hibernate.services;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibernate.model.Address;
import com.hibernate.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private SessionFactory sessionFactory;

	public Boolean createEmployeeRecord(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
		return Boolean.TRUE;
	}

	public Employee getAddressRecord(Address address)  {
		Session session = this.sessionFactory.getCurrentSession();
		Address newArddres = session.get(Address.class, address.getAddressId());
		System.out.println(newArddres);
		if (address != null) {
			System.out.println(newArddres.getEmployee());
		}
		Employee employee=newArddres.getEmployee();
	 
		return employee;
	}

}
