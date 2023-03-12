package com.personal.scripts.gen;

import org.junit.jupiter.api.Test;

class AppStartClsVerTest {

	@Test
	void testMain() {

		final String[] args;
		final int input = Integer.parseInt("1");
		if (input == 1) {
			args = new String[] { "C:\\IVI\\Prog\\JavaGradle\\Scripts\\General\\ClsVer\\" +
					"Projects\\Personal\\ClsVer\\ClsVer\\out\\test\\classes\\" +
					"com\\personal\\scripts\\gen\\AppStartClsVerTest.class" };

		} else if (input == 101) {
			args = new String[] {};
		} else if (input == 102) {
			args = new String[] { "-help" };

		} else {
			throw new RuntimeException();
		}

		AppStartClsVer.main(args);
	}
}
