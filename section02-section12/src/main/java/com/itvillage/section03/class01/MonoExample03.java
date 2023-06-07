package com.itvillage.section03.class01;

import com.itvillage.utils.Logger;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

/**
 * Mono 활용 예제
 *  - worldtimeapi.org Open API를 이용해서 서울의 현재 시간을 조회한다.
 */
public class MonoExample03 {
    public static void main(String[] args) {
        URI worldTimeUri = UriComponentsBuilder.newInstance().scheme("http")
                .host("worldtimeapi.org")
                .port(80)
                .path("/api/timezone/Asia/Seoul")
                .build()
                .encode()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


        Mono.just(
                restTemplate.exchange(worldTimeUri, HttpMethod.GET, new HttpEntity<String>(headers), String.class)
        )
                .map(response -> {
                    DocumentContext jsonContext = JsonPath.parse(response.getBody());
                    String dateTime = jsonContext.read("$.datetime");
                    return dateTime;
                })
                .subscribe(
                        data -> Logger.info("# emitted data: " + data),
                        error -> {
                            Logger.onError(error);
                        },
                        () -> Logger.info("# emitted onComplete signal")
                );

    }
}
