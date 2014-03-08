package at.badgateway.hellomongo.support;

import org.springframework.data.domain.AuditorAware;

public class Auditor implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "AuditorString";
	}

}
