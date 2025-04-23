package kz.sd.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kz.sd.filter.ModifyRequestHeaderGatewayFilterFactory

@Configuration
class GatewayConfig {

    @Bean
    fun modifyRequestHeaderGatewayFilterFactory(): ModifyRequestHeaderGatewayFilterFactory {
        return ModifyRequestHeaderGatewayFilterFactory()
    }
}