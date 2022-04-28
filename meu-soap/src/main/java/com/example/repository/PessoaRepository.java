package com.example.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.example.Pessoa;

@Component
public class PessoaRepository {

	private static final Map<String, Pessoa> pessoaByName = new HashMap<String, Pessoa>();
	private static final Map<BigInteger, Pessoa> pessoaById = new HashMap<BigInteger, Pessoa>();
	
	@PostConstruct
	public void initData() {
		Pessoa p1 = new Pessoa();
		p1.setId(BigInteger.ONE);
		p1.setName("Joao");
		XMLGregorianCalendar xmlCal = null, xmlCal2 = null;
		try {
			xmlCal = DatatypeFactory
					.newInstance()
					.newXMLGregorianCalendarDate(1980, 2, 1, 0);
			
			xmlCal2 = DatatypeFactory
					.newInstance()
					.newXMLGregorianCalendarDate(1985, 7, 20, -180);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.setBirthday(xmlCal);
		
		pessoaByName.put(p1.getName(), p1);
		pessoaById.put(p1.getId(), p1);
		
		Pessoa p2 = new Pessoa();
		p2.setId(BigInteger.TWO);
		p2.setName("Maria");
		p2.setBirthday(xmlCal2);
		
		pessoaByName.put(p2.getName(), p2);
		pessoaById.put(p2.getId(), p2);
	}
	
	public Pessoa getByName(String name) {
		return pessoaByName.get(name);
	}
	
	public Pessoa getById(BigInteger id) {
		return pessoaById.get(id);
	}
}
