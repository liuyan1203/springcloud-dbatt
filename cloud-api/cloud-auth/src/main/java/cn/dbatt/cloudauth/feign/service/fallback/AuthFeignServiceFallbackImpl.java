package cn.dbatt.cloudauth.feign.service.fallback;

import cn.dbatt.cloudauth.feign.service.AuthFeignService;
import org.springframework.stereotype.Component;

/**
 * @ClassName AuthFeignServiceFallbackImpl
 * @Description: TODO
 * @Author yanliu
 * @Date 2019/11/15
 * @Version V1.0
 **/
@Component
public class AuthFeignServiceFallbackImpl implements AuthFeignService {

    @Override
    public String hello(String name) {
        return "hello " + name + ", this is cloud-auth, but request error";
    }
}