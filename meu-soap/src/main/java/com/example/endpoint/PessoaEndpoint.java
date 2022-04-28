package com.example.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.GetPessoaByIdRequest;
import com.example.GetPessoaByIdResponse;
import com.example.GetPessoaByNameRequest;
import com.example.GetPessoaByNameResponse;
import com.example.repository.PessoaRepository;

@Endpoint
public class PessoaEndpoint {
	
	private static final String NAMESPACE_URI = "http://example.com";

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPessoaByIdRequest")
	@ResponsePayload
	public GetPessoaByIdResponse getPessoaById(@RequestPayload GetPessoaByIdRequest request) {
		GetPessoaByIdResponse response = new GetPessoaByIdResponse();
		response.setPessoa(pessoaRepository.getById(request.getId()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPessoaByNameRequest")
	@ResponsePayload
	public GetPessoaByNameResponse getPessoaByName(@RequestPayload GetPessoaByNameRequest request) {
		GetPessoaByNameResponse response = new GetPessoaByNameResponse();
		response.setPessoa(pessoaRepository.getByName(request.getName()));
		return response;
	}
}
