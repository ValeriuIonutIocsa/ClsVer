package com.personal.scripts.gen;

import java.io.DataInputStream;
import java.io.FileInputStream;

final class AppStartClsVer {

	private AppStartClsVer() {
	}

	public static void main(
			final String[] args) {

		System.out.println("--> starting ClsVer script");
		if (args.length < 1) {

			final String helpMessage = createHelpMessage();
			System.err.println("insufficient arguments" + System.lineSeparator() + helpMessage);
			System.exit(1);
		}

		if ("-help".equals(args[0])) {

			final String helpMessage = createHelpMessage();
			System.out.println(helpMessage);
			System.exit(0);
		}

		for (final String arg : args) {
			checkClassVersion(arg);
		}
	}

	private static String createHelpMessage() {

		return "usage: cls_ver <class_file_path>";
	}

	private static void checkClassVersion(
			final String filename) {

		try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filename))) {

			final int magic = dataInputStream.readInt();
			if (magic != 0xcafebabe) {
				System.err.println("ERROR - " + filename + " is not a valid class");

			} else {
				final int minor = dataInputStream.readUnsignedShort();
				final int major = dataInputStream.readUnsignedShort();
				System.out.println(filename + ": " + major + "." + minor);
			}

		} catch (final Exception exc) {
			exc.printStackTrace();
		}
	}
}
