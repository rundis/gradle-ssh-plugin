package org.hidetake.gradle.ssh

import java.util.Map;

import org.gradle.api.Plugin
import org.gradle.api.Project;

/**
 * Gradle SSH plugin.
 * 
 * @author hidetake.org
 *
 */
class SshPlugin implements Plugin<Project> {
	@Override
	void apply(Project project) {
		project.extensions.create('ssh', SshPluginExtension)
		project.extensions.remotes = project.container(Remote) { String name ->
			new Remote(name: name)
		}
	}
}

/**
 * Global configuration.
 * 
 * @author hidetake.org
 *
 */
class SshPluginExtension {
	def Remote remote = new Remote()
	def Map config = [:]

	/**
	 * Configure default remote.
	 *
	 * @param configurationClosure
	 */
	void remote(Closure configurationClosure) {
		remote.with(configurationClosure)
	}

	/**
	 * Add default configuration for JSch. For example:
	 * <pre>
	 * config(StrictHostKeyChecking: 'no')
	 * </pre>
	 * 
	 * @param pairs key value pairs of configuration
	 */
	void config(Map pairs) {
		config.putAll(pairs)
	}
}