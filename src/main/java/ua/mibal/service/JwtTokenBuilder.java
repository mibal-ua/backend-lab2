/*
 * Copyright (c) 2024. Mykhailo Balakhon mailto:9mohapx9@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.mibal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.stereotype.Component;
import ua.mibal.controller.config.property.JwtTokenProps;

import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@RequiredArgsConstructor
@Component
public class JwtTokenBuilder {
    private final JwtTokenProps tokenProps;

    public JwtClaimsSet buildBy(UserDetails userDetails) {
        Instant now = Instant.now();
        String scope = getScopeFromAuthorities(userDetails.getAuthorities());
        return JwtClaimsSet.builder()
                .issuer(tokenProps.issuer())
                .issuedAt(now)
                .expiresAt(calculateExpiresAtFrom(now))
                .subject(userDetails.getUsername())
                .claim("scope", scope)
                .build();
    }

    private Instant calculateExpiresAtFrom(Instant now) {
        int validForDays = tokenProps.validForDays();
        return now.plus(validForDays, DAYS);
    }

    private String getScopeFromAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {
        return grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }
}
