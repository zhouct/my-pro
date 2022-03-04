package com.zc.base.htmlparse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTest {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://gs.amac.org.cn/amac-infodisc/api/pof/personOrg";
//        String url = "https://gs.amac.org.cn/amac-infodisc/api/pof/person";
//        String url = "https://gs.amac.org.cn/amac-infodisc/api/pof/manager/query?page=1&size=10";
        String url = "https://gs.amac.org.cn/amac-infodisc/api/pof/fund?page=1&size=10";
        HttpsUrlValidator.retrieveResponseFromServer(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json");
        Map<String, Object> params = new HashMap<>();
//        params.put("orgType", "gmjjglgs");
        params.put("fundId", 2111021712118471L);
        HttpEntity httpEntity = new HttpEntity(params, httpHeaders);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, httpEntity, Map.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());

    }

}
