package cn.dbatt.cloudadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdminController
 * @Description: TODO
 * @Author yanliu
 * @Date 2019/11/14
 * @Version V1.0
 **/
@RestController
public class AdminController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is cloud-admin";
    }

}