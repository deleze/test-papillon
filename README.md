# Digital Barriers - Papillon SDK test


## Install java and maven
Install JDK of Java 8 latest version.

[Install maven](https://maven.apache.org/install.html#) and be sure you have `mvn` in your path.

## Add PapillonCoreJava in maven

Compile the wrapper with Swig will produce .class

Make a jar with the classes with a command like the following :

``` 
PAPILLON_VERSION=4.4.0.42
jar vcf $PAPILLON_HOME/PapillonCoreJava-$PAPILLON_VERSION.jar -C . $(find . -name "*.class")
```

The `jar` command will cer following the following name `PapillonCoreJava-$PAPILLON_VERSION.jar`.

Now install the Paillon jar in your local repository (`~/.m2/repository`) with the maven command:

```
PAPILLON_VERSION=4.4.0.42
mvn install:install-file -Dfile=PapillonCoreJava-${PAPILLON_VERSION}.jar -DgroupId=ch.morphean.analytics.papillon -DartifactId=papillon-core-java -Dversion=${PAPILLON_VERSION} -Dpackaging=jar
```

## Add the dependency in pom.xml

See the dependency in the `pom.xml`.

```
		<dependency>
			<groupId>ch.morphean.analytics.papillon</groupId>
			<artifactId>papillon-core-java</artifactId>
			<version>4.4.0.42</version>
		</dependency>
```
## Build and start the app

```
mvn clean package

java -jar target/papillon-0.0.1-SNAPSHOT.jar 
```

## Info about the Spring APP
I create the spring boot app with [INITIALIZR](https://start.spring.io) and `Rest Repositories` as dependency.

 