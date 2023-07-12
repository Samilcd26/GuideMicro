package com.guide.userservice.beans

import com.guide.userservice.audit.AuditorAwareImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware


@Configuration
class AuditorAwareBean {

    @Bean
    public fun auditorAware(): AuditorAware
    <String>? {
        return AuditorAwareImpl()
    }
}