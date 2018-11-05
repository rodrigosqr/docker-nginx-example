package com.iftm.portalferias.portalferias;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("portalferias")
public class PortalFeriasProperty {

	private String originPermitida = "http://localhost:8071";

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
}
