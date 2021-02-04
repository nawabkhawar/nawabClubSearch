package com.example.nawabClubSearch.processors;

import com.example.nawabClubSearch.dto.AwardRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;


@Component
public class HTTP {

    public Object postAwards(AwardRequest awardRequest) {
        /*just remove
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "https://script.google.com/macros/s/AKfycbzDg2b1A_hOH9IdGn7kFiBrIN_zx2w1UeKidWNL5XGKEU7PgFvb/exec";

        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");

        HttpHeaders headers = new HttpHeaders();
        //headers.set("X-COM-PERSIST", "true");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

       HttpEntity<AwardRequest> request = new HttpEntity<>(awardRequest, headers);
        /*
        ResponseEntity<Object[]> result = restTemplate.postForEntity(uri, request, Object[].class);*/

       // RestTemplate restTemplate = new RestTemplate();
        /*MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
dont' remove*/
       // HttpEntity<String> request =new HttpEntity<String>(awardRequest.toString(), headers);

        /*final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        final HttpClient httpClient = HttpClientBuilder.create()
                .setRedirectStrategy(new LaxRedirectStrategy())
                .build();
        factory.setHttpClient(httpClient);
        restTemplate.setRequestFactory(factory);

        ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity(baseUrl, request, String.class);

        return responseEntityStr.getBody(); justremove*/
        return 0;
    }
}
