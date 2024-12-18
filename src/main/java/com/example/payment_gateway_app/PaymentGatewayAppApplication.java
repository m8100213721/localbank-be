package com.example.payment_gateway_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@EnableCaching
public class PaymentGatewayAppApplication {
    /*
     * The Simple Payment Gateway Banking Application allows
     * users to make and receive payments securely.
     * This system can be used by merchants to facilitate online transactions and
     * by customers to make payments using their bank accounts.
     * The application should handle user authentication, transaction processing, and transaction history.

     * */
    public static void main(String[] args) {
        SpringApplication.run(PaymentGatewayAppApplication.class, args);
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

}
