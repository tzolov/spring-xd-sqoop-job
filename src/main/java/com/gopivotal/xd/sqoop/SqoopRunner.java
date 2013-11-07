package com.gopivotal.xd.sqoop;

import org.apache.sqoop.Sqoop;

public class SqoopRunner {

	// sqoop export --connect jdbc:mysql://192.168.178.13/sqoop_test --username
	// gpadmin --password gpadmin --table cdr_orig --export-dir
	// /xd/ti/data/out/prepared/dvcallreceived.csv

	public static void main(String[] args) {

		String[] sqoopArguments = args[0].split(" ");

		final int ret = Sqoop.runTool(sqoopArguments);

		if (ret != 0) {
			throw new RuntimeException("Sqoop failed - return code "
					+ Integer.toString(ret));
		}
	}
}
