spring-xd-sqoop-job
===================

Simple Sqoop Job module for Spring-XD

## Build and Installation

Build the Hadoop job jar:

	mvn clean install

Set the environment variable `XD_HOME` to the Spring-XD installation directory

	export XD_HOME=<root-install-dir>/spring-xd/xd
	
Copy the result `xd-sqoop-module-0.0.1-SNAPSHOT-job.jar` into your `${XD_HOME}/lib`	
	
	cp target/xd-sqoop-module-0.0.1-SNAPSHOT-job.jar `${XD_HOME}/lib`

Copy the `sqoop.xml` module definition into `${XD_HOME}/modules/jobs`	
	
	cp src/main/resources/sqoop.xml ${XD_HOME}/modules/job

Copy the following Hadoop cluster configuration files into `${XD_HOME}/config`
	
	core-site.xml
	hdfs-site.xml
	mapred-site.xml
	yarn-site.xml

## Usage

#### [Sqoop Export][]
The export tool exports a set of files from HDFS back to an RDBMS. The target table must already exist in the database. The input files are read and parsed into a set of records according to the user-specified delimiters.

The default operation is to transform these into a set of INSERT statements that inject the records into the database. In "update mode," Sqoop will generate UPDATE statements that replace existing records in the database.


Sample data export from HDFS to remote MySQL database:

	xd:>job create --name sqoop_job --definition "sqoop --command='export 
	  --connect jdbc:mysql://your-db-hostname/target-db-name
	  --username db-username --password db-password 
	  --table target-table-name 
	  --export-dir /hdfs/source/folder/*.csv'"
	
	xd:>stream create --name sqt1 --definition "trigger > job:sqoop_job"
  
  
  
  
[Sqoop Export]: http://sqoop.apache.org/docs/1.4.2/SqoopUserGuide.html#_literal_sqoop_export_literal
