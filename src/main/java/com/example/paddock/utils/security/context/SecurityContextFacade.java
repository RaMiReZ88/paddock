package com.example.paddock.utils.security.context;

import org.springframework.security.core.context.SecurityContext;

public interface SecurityContextFacade {

    SecurityContext getSecurityContext();

    void setSecurityContext(SecurityContext securityContext);

}
