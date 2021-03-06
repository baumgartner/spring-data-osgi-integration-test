package at.badgateway.spring.data.osgi.tests;

import java.util.Set;
import java.util.jar.Manifest;

import org.eclipse.gemini.blueprint.test.AbstractConfigurableBundleCreatorTests;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

public abstract class PluginDependencyOsgiAbstractTests extends
		AbstractConfigurableBundleCreatorTests {

	private static final String TEST_FRRAMEWORK_BUNDLES_CONF = "/boot-bundles.properties";

	private Logger logger = LoggerFactory.getLogger(getClass());

	protected String[] getTestBundlesNames() {
		return new String[] {
				"org.eclipse.persistence, javax.persistence, 2.1.0",
				"org.springframework.data, spring-data-commons, 1.8.0.BUILD-SNAPSHOT",
				"org.springframework.data, spring-data-jpa, 1.6.0.BUILD-SNAPSHOT",
				"org.hsqldb, com.springsource.org.hsqldb, 1.8.0.10",
				"org.eclipse.persistence, org.eclipse.persistence.jpa.jpql, 2.5.1",
				"org.eclipse.persistence, org.eclipse.persistence.jpa, 2.5.1",
				"org.eclipse.persistence, org.eclipse.persistence.core, 2.5.1",
				"org.eclipse.persistence, org.eclipse.persistence.antlr, 2.5.1",
				"org.eclipse.persistence, org.eclipse.persistence.asm, 2.5.1",
				"org.apache.servicemix.bundles,org.apache.servicemix.bundles.aspectj,1.7.4_1",
				"joda-time, joda-time, 2.3" };

	}

	protected String[] getConfigLocations() {
		return new String[] { "context.xml" };
	}

	@Override
	public void onSetUp() {
		logger.info("onSetUp");
	}

	@Override
	public void onTearDown() {
		logger.info("onTearDown");
	}

	// protected String getManifestLocation() {
	// return "classpath:MY-MANIFEST.MF";
	// }

	protected Manifest getManifest() {
		Manifest mf = super.getManifest();
		String existingImports = mf.getMainAttributes().getValue(
				org.osgi.framework.Constants.IMPORT_PACKAGE);
		Set<String> imports = StringUtils
				.commaDelimitedListToSet(existingImports);

		imports.add("org.springframework.data.annotation");
		imports.add("org.springframework.dao");
		imports.add("org.springframework.orm.jpa");
		imports.add("org.springframework.orm.jpa.vendor");
		imports.add("org.eclipse.persistence.jpa");
		imports.add("javax.persistence.criteria");
		imports.add("javax.persistence.metamodel");
		imports.add("javax.persistence.spi");
		imports.add("javax.sql");
		imports.add("org.aspectj.lang");
		imports.add("org.eclipse.persistence.expressions");
		imports.add("org.eclipse.persistence.jpa");
		imports.add("org.eclipse.persistence.queries");
		imports.add("org.eclipse.persistence.internal.sessions");
		imports.add("org.eclipse.persistence.sessions");
		imports.add("org.eclipse.persistence.sessions.broker");
		imports.add("org.eclipse.persistence.sessions.server");
		imports.add("org.springframework.beans.factory.aspectj");
		imports.add("org.springframework.data.jpa.repository.support");
		imports.add("org.springframework.data.repository.core.support");
		imports.add("org.aspectj.lang");
		imports.add("org.springframework.aop");
		imports.add("org.springframework.aop.framework");
		imports.add("org.aopalliance.aop");
		imports.add("org.eclipse.persistence.jpa.jpql.parser");
		imports.add("org.springframework.data.jpa.domain.support");
		imports.add("org.springframework.data.repository");
		imports.add("org.joda.time");

		mf.getMainAttributes().putValue(Constants.IMPORT_PACKAGE,
				StringUtils.collectionToCommaDelimitedString(imports));

		return mf;
	}

	protected boolean createManifestOnlyFromTestClass() {
		return false;
	}

	@Override
	protected Resource getTestingFrameworkBundlesConfiguration() {
		return new InputStreamResource(
				PluginDependencyOsgiAbstractTests.class
						.getResourceAsStream(TEST_FRRAMEWORK_BUNDLES_CONF));

	}

}
