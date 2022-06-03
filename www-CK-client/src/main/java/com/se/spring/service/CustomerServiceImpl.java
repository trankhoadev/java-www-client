package com.se.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public CustomerServiceImpl(RestTemplate theRestTemplate, @Value("${rest.url}") String url) {
		restTemplate = theRestTemplate;
		crmRestUrl = url;
	}

	@Override
	public List<Customer> getCustomers() {
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		List<Customer> list = responseEntity.getBody();
		return list;
	}

	@Override
	public Customer getCustomer(int id) {
		Customer customer = restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		restTemplate.delete(crmRestUrl + "/" + id);

	}

	@Override
	public void saveCustomer(Customer customer) {
		int id = customer.getId();
		
		if(id==0)
			restTemplate.postForEntity(crmRestUrl, customer, String.class);
		else
			restTemplate.put(crmRestUrl, customer);

	}

}
