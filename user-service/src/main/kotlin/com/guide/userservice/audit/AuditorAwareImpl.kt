package com.guide.userservice.audit

import org.springframework.data.domain.AuditorAware
import java.util.Optional

class AuditorAwareImpl:AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.of("go")
    }
}