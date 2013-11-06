package com.gopivotal.xd.sqoop;

import org.apache.sqoop.Sqoop;

public class SqoopRunner {

	// sqoop export --connect jdbc:mysql://192.168.178.13/sqoop_test --username gpadmin --password gpadmin --table cdr_orig --export-dir /xd/ti/data/out/prepared/dvcallreceived.csv

	public static void main(String[] args) {
		String[] args2 = new String[] { "export", "--connect",
				"jdbc:mysql://192.168.178.13/sqoop_test", "--username", "gpadmin", "--password", "gpadmin",
				"--table", "cdr_orig", "--export-dir",
				"/xd/ti/data/out/prepared/dvcallreceived.csv", "" };
		String[] args3 = args[0].split(" ");
		final int ret = Sqoop.runTool(args3);
		if (ret != 0) {
			throw new RuntimeException("Sqoop failed - return code "
					+ Integer.toString(ret));
		}
	}


}
