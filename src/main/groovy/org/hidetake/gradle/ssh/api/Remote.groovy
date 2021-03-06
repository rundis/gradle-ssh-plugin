package org.hidetake.gradle.ssh.api

/**
 * Represents a remote host.
 * 
 * @author hidetake.org
 *
 */
class Remote {
	/**
	 * Name of this instance.
	 */
	final String name

	/**
	 * Remote user.
	 */
	String user

	/**
	 * Port.
	 */
	int port = 22

	/**
	 * Remote host.
	 */
	String host

	/**
	 * Password.
	 * Leave as null if public key authentication.
	 */
	String password

	/**
	 * Roles.
	 */
	final List<String> roles = []

	/**
	 * Identity key file.
	 * Leave as null if password authentication.
	 */
	File identity

    /**
     * Passphrase for private key
     * Leave as null if password authentication
     */
    String passphrase

	Remote(String name) {
		this.name = name
	}

	/**
	 * Add a role to this remote.
	 * 
	 * @param role
	 */
	void role(String role) {
		assert role != null, 'role name should not be null'
		roles.add(role)
	}

	/**
	 * Returns a string representation of this remote host.
	 */
	@Override
	String toString() {
		"remote '${name}'"
	}
}
