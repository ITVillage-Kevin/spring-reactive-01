package com.itvillage;

import com.itvillage.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * 검색용 클라이언트 PC에서 들어오는 요청을 처리하는 본사 API Server
 */
@Slf4j
@RequestMapping(path = "/v1/books")
@RestController
public class SpringMvcHeadOfficeController {
    private final RestTemplate restTemplate;

    URI baseUri = UriComponentsBuilder.newInstance().scheme("http")
            .host("localhost")
            .port(7070)
            .path("/v1/books")
            .build()
            .encode()
            .toUri();

    public SpringMvcHeadOfficeController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBook(@PathVariable("book-id") long bookId) {
        URI getBookUri = UriComponentsBuilder.fromUri(baseUri)
                .path("/{book-id}")
                .build()
                .expand(bookId)
                .encode()
                .toUri(); // http://localhost:7070/v1/books/{book-id}

        ResponseEntity<Book> response = restTemplate.getForEntity(getBookUri, Book.class);
        Book book = response.getBody();

        return ResponseEntity.ok(book);
    }

}
