# PojoTest
PojoTest is a test library designed to help me testing POJOs using a simple API. The implementation is using [POJO-TESTER](https://www.pojo.pl/ library).

## Getting started
### Prerequisites

* JDK >= 8
* JUnit >= 4.13
* Maven >= 3.6 
* SLF4J >= 1.7.30 (Optionnal - note that warning will appear if you're not using a version of it.)

### Installation

Checkout the latest version of PojoTest and run a maven install on it.

Import the library into your own pom.xml.

```Maven POM
<dependencies>
	<dependency>
		<groupId>org.jtbox.test</groupId>
		<artifactId>pojotest</artifactId>
		<version>1.0.0</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>${junit.version}</version>
		<scope>test</scope>
	</dependency>
</dependencies>
```

### Simple Test
Create and run a simple JUnit Test Class on a POJO of your own

```Java
public class AbstractPojoTesterTest extends AbstractPojoTester<AuthorDTO>{
	// nothing to do
}
```

Run your test, and enjoy ;)

## Features
### POJO Testing
*AbstractPojoTester* abstract class provides a way to add unit testing on: Getter, Setter and simple Constructor fo a specific POJO.

### POJO Building
*PojoBuilder* class provides a way to build your own set of random data corresponding to a POJO.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

I use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **JordanTerri** - *Initial work* - [JordanTerri](https://github.com/JordanTerri)
