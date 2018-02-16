package univ.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import univ.domain.Product;

public class RestfulClient {

	RestTemplate restTemplate;
	String urlP = "http://localhost:5050/productos";
	String urlV = "http://localhost:5050/viajes";

	public RestfulClient() {
		restTemplate = restTemplate();

	}

	public List<?> getEntities() {

		ResponseEntity<PagedResources<?>> responseEntity = restTemplate.exchange(urlP, HttpMethod.GET, null,
				new ParameterizedTypeReference<PagedResources<?>>() {
				});

		PagedResources<?> resources = responseEntity.getBody();
		List<?> promotions = new ArrayList<>(resources.getContent());
		System.out.println(promotions);
		
		

		ResponseEntity<PagedResources<?>> responseEntityV = restTemplate.exchange(urlV, HttpMethod.GET, null,
				new ParameterizedTypeReference<PagedResources<?>>() {
				});
		PagedResources<?> resourcesV = responseEntityV.getBody();
		List<?> promotionsV = new ArrayList<>(resourcesV.getContent());
		System.out.println(promotionsV);
		
		return Arrays.asList(promotions,promotionsV);
	}

	private RestTemplate restTemplate() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new Jackson2HalModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);
		return new RestTemplate(Arrays.asList(converter));
	}

}
