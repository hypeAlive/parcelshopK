package com.gls.parcelshop.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration


@Configuration
@EnableWebSecurity
@Order(Ordered.LOWEST_PRECEDENCE)
open class WebSecurityConfiguration {

    @Bean
    @Throws(Exception::class)
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable().cors().configurationSource {
            CorsConfiguration().apply {
                allowedOrigins = listOf("*")
                allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                allowedHeaders = listOf("*")
            }
        }.and().sessionManagement { configurer ->
            configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }.authorizeRequests { authorize ->
            authorize.antMatchers("/api/v1/parcels/**").permitAll()
            authorize.anyRequest().authenticated()
        }
        return http.build()
    }

}
