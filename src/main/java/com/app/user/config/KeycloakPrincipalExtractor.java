package com.app.user.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class KeycloakPrincipalExtractor extends JwtAuthenticationConverter {

    @Override
    protected Collection<GrantedAuthority> extractAuthorities(Map<String, Object> claims) {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) claims.get("realm_access.roles");
        return authorities;
    }
    
    @Override
    public Authentication extractAuthentication(Map<String, Object> claims) {
        return super.extractAuthentication(claims);
    }
}