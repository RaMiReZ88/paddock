package com.kolhoz.paddock.utils.security.context;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextHolderFacade implements com.kolhoz.utils.security.context.SecurityContextFacade {

    @Override
    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

    @Override
    public void setSecurityContext(SecurityContext securityContext) {
        SecurityContextHolder.setContext(securityContext);
    }
}
