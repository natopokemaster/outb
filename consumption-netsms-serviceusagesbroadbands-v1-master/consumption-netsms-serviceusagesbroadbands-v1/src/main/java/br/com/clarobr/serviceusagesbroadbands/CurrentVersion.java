package br.com.clarobr.serviceusagesbroadbands;

/**
 * Represents a service version id. Used as one of response properties of this
 * micro service.
 * 
 * @author Marcus R Pestana
 *
 */
public final class CurrentVersion {

	public static final String ARQ_REF_VERSION = "1.0.0-RELEASE";

	private CurrentVersion() {
		throw new UnsupportedOperationException("This class cannot be instantiated.");
	}

}
