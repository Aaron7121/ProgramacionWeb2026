plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jboss.resteasy:resteasy-core:7.0.2.Final")


   // implementation("org.jboss.resteasy:resteasy-undertow:7.0.2.Final")
   testImplementation("org.jboss.resteasy:resteasy-undertow-cdi:7.0.2.Final")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:7.0.2.Final")
    implementation("org.jboss.weld:weld-core-impl:6.0.4.Final")
    implementation("org.hibernate.orm:hibernate-core:7.4.1.Final")

    // Source: https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.11")
}

tasks.test {
    useJUnitPlatform()
}