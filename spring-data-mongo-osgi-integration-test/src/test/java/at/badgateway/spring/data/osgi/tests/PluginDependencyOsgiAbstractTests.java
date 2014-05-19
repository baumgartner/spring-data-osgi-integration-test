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
				"org.springframework.data, spring-data-commons, 1.8.0.BUILD-SNAPSHOT",
				"org.springframework.data, spring-data-mongodb, 1.5.0.BUILD-SNAPSHOT",
				"org.mongodb, mongo-java-driver, 2.12.1",
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

		imports.add("com.mongodb");
		imports.add("org.aopalliance.aop");
		imports.add("org.bson.types");
		imports.add("org.joda.time");
		imports.add("org.springframework.aop");
		imports.add("org.springframework.aop.framework");
		imports.add("org.springframework.data.annotation");
		imports.add("org.springframework.data.domain");
		imports.add("org.springframework.data.mongodb.config");
		imports.add("org.springframework.data.mongodb.core");
		imports.add("org.springframework.data.mongodb.repository.support");
		imports.add("org.springframework.data.repository");
		imports.add("org.springframework.data.repository.core.support");

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
