package com.nines.demo.functionalinterface.reactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author tanyujie
 * @classname Demo
 * @description WebFlux使用的响应式流并不是用JDK9平台的，而是一个叫做Reactor响应式流库。
 *              所以，入门WebFlux其实更多是了解怎么使用Reactor的API，下面我们来看看~
 *              Mono(返回0或1个元素)
 *              Flux(返回0-n个元素)
 * @date 2022/6/7 9:26
 * @since 1.0
 */
@RestController
@RequestMapping("/flux")
@SpringBootApplication
public class Demo {

    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }

    /**
     * 阻塞5秒钟
     */
    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignored) {
        }
        return "some string";
    }

    /**
     * 普通的SpringMVC方法
     */
    @GetMapping("/1")
    private String get1() {
        System.out.println("get1 start");
        String result = createStr();
        System.out.println("get1 end.");
        return result;
    }

    /**
     * WebFlux(返回的是Mono)
     */
    @GetMapping("/2")
    private Mono<String> get2() {
        System.out.println("get2 start");
        Mono<String> result = Mono.fromSupplier(this::createStr);
        System.out.println("get2 end.");
        return result;
    }

    /**
     * Flux : 返回0-n个元素
     * 注：需要指定MediaType
     * @return
     */
    @GetMapping(value = "/3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        return Flux
                .fromStream(IntStream.range(1, 5).mapToObj(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ignored) {
                    }
                    return "flux data--" + i;
                }));
    }


}
