package io.spring.learning;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.util.UUID;

@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfiguration
                .applyDefaultSecurity(http);
        return http
                .formLogin(Customizer.withDefaults())
                .build();
    }

    // @formatter:off
    @Bean
    public RegisteredClientRepository registeredClientRepository(
            PasswordEncoder passwordEncoder) {
        System.out.println(passwordEncoder.encode("secret"));
        RegisteredClient registeredClient =
                RegisteredClient.withId(UUID.randomUUID().toString())
                        .clientId("taco-admin-client")
                        .clientSecret(passwordEncoder.encode("secret"))
                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                        .redirectUri(
                                "http://127.0.0.1:9090/login/oauth2/code/taco-admin-client")
                        .scope("writeIngredients")
                        .scope("deleteIngredients")
                        .scope(OidcScopes.OPENID)
                        .clientSettings(clientSettings -> clientSettings.requireUserConsent(true))
                        .tokenSettings(
                                tokenSettings -> tokenSettings.idTokenSignatureAlgorithm(SignatureAlgorithm.RS256)
                                        .accessTokenTimeToLive(Duration.ofSeconds(30*60))
                                        .refreshTokenTimeToLive(Duration.ofSeconds(60 * 60))
                                        .reuseRefreshTokens(true)
                        )
                        .build();
        return new InMemoryRegisteredClientRepository(registeredClient);

    }
    // @formatter:on

    @Bean
    public ProviderSettings providerSettings() {
        return new ProviderSettings()
                .issuer("http://authserver:9000");

    }

    @Bean
    public JWKSource<SecurityContext> jwkSource()
            throws NoSuchAlgorithmException {
        RSAKey rsaKey = generateRsa();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    private static RSAKey generateRsa() throws NoSuchAlgorithmException {
        KeyPair keyPair = generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    private static KeyPair generateRsaKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    @Bean
    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
    }

}

// ZZRJld6u5w6eKkNfb3OWD9UT7dlplq9WlNkw0aeYz1V186FNgQcoOAYKeBkgzGcdCO1AVff3pdIo_OrIRR5sBEL7AXemSfJEJNiF8RG9yag86_XsWfdePJWIkEtFXtjj&state=nWw73NyK_7Z-uU3mJgPOW74x1HoiHNmn9Qf-pVAGovI%3D