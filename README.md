spring-xd-sqoop-job
===================

Simple Sqoop Job module for Spring-XD

## Build and Installation

Build the Hadoop job jar:

	mvn clean install
	
Copy xd-sqoop-module-0.0.1-SNAPSHOT-job.jar into your ${XD_HOME}/xd/lib	
	
	cp target/xd-sqoop-module-0.0.1-SNAPSHOT-job.jar ${XD_HOME}/xd/lib/

Copy the (sqoop.xml) module definition into ${XD_HOME}/xd/modules/jobs	
	
	cp src/main/resources/sqoop.xml ${XD_HOME}/xd/modules/job

Copy the following Hadoop cluster configuration files into ${XD_HOME}/xd/config
	
	core-site.xml
	hdfs-site.xml
	mapred-site.xml
	yarn-site.xml

## Usage

#### Sqoop-Export

Export data from HDFS to remote MySQL DB

	xd:>job create --name sqoop_job --definition "sqoop --params='export --connect jdbc:mysql://your-db-hostname/target-db-name\
	--username db-username --password db-password --table target-table-name --export-dir /hdfs/source/folder/*.csv'"
	xd:>stream create --name sqt1 --definition "trigger > job:sqoop_job"
  
