package com.masa.logistics.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RestTemplate
 * @Description 请求类
 * @Author tuess
 * @Version 1.0
 **/
public class HttpRequestUtil {
    public static JSONObject SendGet(String url, MultiValueMap<String, String> params) {
        Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.GET;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, method, requestEntity, String.class);
            return JSONObject.parseObject(response.getBody());
        } catch (Exception e) {
            logger.error("请求出错，[{}]", e.toString());
        }
        return null;
    }
}
