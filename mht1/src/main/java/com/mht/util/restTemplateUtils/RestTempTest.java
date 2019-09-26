package com.mht.util.restTemplateUtils;

import java.util.UUID;

public class RestTempTest {
    public static void main(String[] args) {

        System.out.println(Math.abs(UUID.randomUUID().toString().replace("-","").hashCode()));
//        RestTemplate restTemplate = RestTemplateUtil.getInstance();
//        String appid = "wx656e16786802d6e3";
//        String secret = "eb393db7d01895eab106631daecba977";
//        String code = "071OLt5K0P6xY92blx7K0DKv5K0OLt5A";
//        HashMap<String, String> map = new HashMap<>();
//
//        String response = new String();
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx656e16786802d6e3&secret=eb393db7d01895eab106631daecba977&js_code=021CmDcg02Voqw1IYNeg0Qvxcg0CmDc6&grant_type=authorization_code";
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
//        String s1 = forEntity.toString();
//        String s = forEntity.toString();
//        String body = forEntity.getBody();
//        Notice notice = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=wx656e16786802d6e3&secret=eb393db7d01895eab106631daecba977&js_code=011TFTE6192XeM1VGcF61KueF61TFTEp&grant_type=authorization_code"
//                , Notice.class);
//        System.out.println(notice);



    }


}
