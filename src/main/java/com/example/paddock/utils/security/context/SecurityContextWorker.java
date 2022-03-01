package com.example.paddock.utils.security.context;

import org.springframework.stereotype.Component;

@Component
public class SecurityContextWorker {

    private final SecurityContextHolderFacade securityContextHolderFacade;

    public SecurityContextWorker(SecurityContextHolderFacade securityContextHolderFacade) {
        this.securityContextHolderFacade = securityContextHolderFacade;
    }

    private Object getPrincipalFromSecurityContext() {
        return securityContextHolderFacade.getSecurityContext()
                .getAuthentication()
                .getPrincipal();
    }
}
