package br.com.clarobr.contractprospectservice.observability;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Component;

/**
 * Classe responsavel por realizar os requisitos nao funcionais de observability
 * como Readiness / Liveness checks e configurações adicionais de monitoramento
 *
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Autowired
    JdbcTemplate template;

	@Override
	public Health health() {
		int errorCode = check(); // perform a specific health check
		if (errorCode != 1) {
			return Health.down().withDetail("Error Code", 500).build();
		}
		return Health.up().build();
	}

	public int check() {
		List<Object> results = template.query("select 1 from dual",
				new SingleColumnRowMapper<>());
		return results.size();
	}

}