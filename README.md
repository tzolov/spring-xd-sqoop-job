spring-xd-sqoop-job
===================

Simple Sqoop Job module for Spring-XD

## Build and Installation

Build the Hadoop job jar:

	mvn clean install

Set the environment variable `XD_HOME` to the installation directory <root-install-dir>\spring-xd\xd

	export XD_HOME=<root-install-dir>/spring-xd/xd
	
Copy the result `xd-sqoop-module-0.0.1-SNAPSHOT-job.jar` into your ${XD_HOME}/lib	
	
	cp target/xd-sqoop-module-0.0.1-SNAPSHOT-job.jar ${XD_HOME}/lib/

Copy the `sqoop.xml` module definition into ${XD_HOME}/modules/jobs	
	
	cp src/main/resources/sqoop.xml ${XD_HOME}/modules/job

Copy the following Hadoop cluster configuration files into ${XD_HOME}/config
	
	core-site.xml
	hdfs-site.xml
	mapred-site.xml
	yarn-site.xml

## Usage

#### Sqoop-Export

Export data from HDFS to remote MySQL DB

	xd:>job create --name sqoop_job --definition "sqoop --command='export 
	  --connect jdbc:mysql://your-db-hostname/target-db-name
	  --username db-username --password db-password 
	  --table target-table-name 
	  --export-dir /hdfs/source/folder/*.csv'"
	
	xd:>stream create --name sqt1 --definition "trigger > job:sqoop_job"
  
