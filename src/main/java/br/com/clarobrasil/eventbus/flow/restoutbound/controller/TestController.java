package br.com.clarobrasil.eventbus.flow.restoutbound.controller;


import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.ApiGeeTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@RestController
@RequestMapping("/outbound")
@RequiredArgsConstructor
@Profile("dev")
public class TestController {

    private final ApiGeeTokenService apiGeeTokenService;

    @PostMapping
    public void testing() {
        String token = apiGeeTokenService.manageTokenAPIGEE();
        LogUtil.info(log, "Token: {}", token);
    }

}
