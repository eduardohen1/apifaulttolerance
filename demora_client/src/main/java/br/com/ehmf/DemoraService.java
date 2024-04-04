package br.com.ehmf;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

@RegisterRestClient(baseUri = "http://localhost:8081/devagar")
public interface DemoraService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Timeout(
            value = 2000L
    )
    @Retry(
            maxRetries = 5,
            delay = 3000,
            retryOn = TimeoutException.class
    )// se der timeout, tenta de novo 5 vezes, com intervalo de 3 segundos
    @Fallback(
            fallbackMethod = "fallback"
    )
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.75,
            delay = 3000,
            successThreshold = 2
    )
    String getDevagar();


    default String fallback(){
        return "Deu ruim... mas fallback funcionou! " + LocalDateTime.now();
    }

}
