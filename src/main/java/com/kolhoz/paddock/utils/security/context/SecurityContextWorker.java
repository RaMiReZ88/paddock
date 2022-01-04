package com.kolhoz.paddock.utils.security.context;

import org.springframework.stereotype.Component;


@Component
public class SecurityContextWorker {

    private final com.kolhoz.paddock.utils.security.context.SecurityContextHolderFacade securityContextHolderFacade;

    public SecurityContextWorker(com.kolhoz.paddock.utils.security.context.SecurityContextHolderFacade securityContextHolderFacade) {
        this.securityContextHolderFacade = securityContextHolderFacade;
    }

    private Object getPrincipalFromSecurityContext() {
        return securityContextHolderFacade.getSecurityContext()
                .getAuthentication()
                .getPrincipal();
    }
}
