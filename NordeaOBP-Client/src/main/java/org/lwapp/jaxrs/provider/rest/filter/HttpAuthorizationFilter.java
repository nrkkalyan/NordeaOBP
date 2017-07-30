package org.lwapp.jaxrs.provider.rest.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = "/restapi/*", dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC, DispatcherType.ERROR, DispatcherType.INCLUDE })
public class HttpAuthorizationFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(HttpAuthorizationFilter.class);
    private static Properties properties = new Properties();

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

        LOG.info("RemoteAddr:{}", request.getRemoteAddr());
        LOG.info("RemoteHost:{}", request.getRemoteHost());
        LOG.info("RemotePort:{}", request.getRemotePort());

        final CustomHttpServletRequestWrapper httpRequest = new CustomHttpServletRequestWrapper((HttpServletRequest) request);
        final String secret = properties.getProperty("APIKEY") + ":" + properties.getProperty("APISECRET");
        httpRequest.addHeader("Authorization", Base64.getEncoder().encodeToString(secret.getBytes()));
        chain.doFilter(httpRequest, response);
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.loadProperties();
    }

    private void loadProperties() {
        if (properties.isEmpty()) {
            try (InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("securityconfig.properties")) {
                LOG.info("Loading the properties from securityconfig.properties file");
                properties.load(inStream);
                LOG.info("Loading the properties from securityconfig.properties file completed.");
            } catch (final IOException e) {
                throw new RuntimeException("Could not able to load config.properties file.", e);
            }
        }
    }
}