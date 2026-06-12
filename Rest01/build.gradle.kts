plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Source: https://mvnrepository.com/artifact/org.jboss.resteasy/resteasy-core
    implementation("org.jboss.resteasy:resteasy-core:7.0.2.Final")


    // Source: https://mvnrepository.com/artifact/org.jboss.resteasy/resteasy-undertow
    implementation("org.jboss.resteasy:resteasy-undertow:7.0.2.Final")
}

tasks.test {
    useJUnitPlatform()
}