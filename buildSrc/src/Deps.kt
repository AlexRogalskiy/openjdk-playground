import org.gradle.kotlin.dsl.*
import org.gradle.plugin.use.*

/**
 * Platform versions (Global)
 */
val javaVersion = "javaVersion".systemProp.toInt()
val kotlinVersion = "KotlinVersion".systemProp
val kotlinJvmTarget = "kotlinJvmTarget".systemProp
val kotlinLangVersion = "kotlinLangVersion".systemProp
val gradleRelease = "gradleRelease".systemProp
val githubProject = "githubProject".systemProp

/**
 * Dependency versions.
 */
object Versions {
    const val coroutines = "1.3.9"
    const val kotlinxSerialization = "1.0.0-RC"
    const val kotlinxAtomicfu = "0.14.4"
    const val kotlinxReflectLite = "1.0.0"
    const val kotlinImmutableColl = "0.3.2"
    const val kotlinIO = "0.1.4"
    const val ktor = "1.3.2-1.4.0-rc"
    const val micronaut = "2.0.0"

    const val jsr305 = "3.0.2"
    const val clikt = "2.8.0"
    const val colormath = "1.4.0"
    const val mordant = "1.2.1"
    const val moshi = "1.9.2"
    const val okhttp = "4.8.1"
    const val okio = "2.2.0"
    const val certifikit = "0.2.0"
    const val ok2Curl = "0.4.5"
    const val retrofit = "2.9.0"
    const val turbine = "0.1.1"
    const val commonsCodec = "1.11"
    const val rsocket = "0.11.16"
    const val failsafe = "2.3.3"
    const val typetools = "0.6.2"
    const val assertj = "3.11.1"
    const val kotlinPowerAssert = "0.3.0"
    const val graal = "20.0.0"
    const val junit = "5.6.2"
    const val truth = "1.0.1"
    const val mockito = "2.26.0"
    const val awaitility = "3.1.6"
    const val kotest = "3.4.2"
    const val sshj = "0.26.0"
    const val jol = "0.9"
    const val slf4j = "1.7.30"
    const val mockitoKotlin = "2.1.0"
    const val conscrypt = "1.4.1"
    const val tink = "1.2.1"
    const val asm = "7.3.1"
    const val byteBuddy = "1.9.7"
    const val loggingRetrofit = "0.10.0"
    const val bouncyCastle = "1.60"
    const val brotli = "0.1.2"
    const val commonsIO = "2.6"
    const val jnrJffi = "1.2.18"
    const val jnrUnixSocket = "0.21"
    const val jimfs = "1.1"
    const val netty = "4.1.32.Final"
    const val retrofitCoroutinesAdapter = "0.9.2"
    const val retrofitSerializationAdapter = "0.6.0"
    const val retrofitReactorAdapter = "2.1.0"
    const val kaml = "0.17.0"
    const val ztExec = "1.10"
    const val jline = "3.9.0"
    const val picnic = "0.3.1"
    const val eclipseCollections = "9.2.0"
    const val trov4j = "1.0.20181211"
    const val japicmp = "0.13.0"
    const val jjwt = "0.10.5"
    const val jkeychain = "1.0.0"
    const val openpdf = "1.2.9"
    const val orsonpdf = "1.8"
    const val jfreesvg = "3.3"
    const val jibCore = "0.1.1"
    const val swaggerUI = "3.10.0"
    const val swaggerCodegenCli = "3.0.0"
    const val smbj = "0.9.1"
    const val asn1 = "0.1.0"
    const val caffeine = "2.6.2"
    const val cache2k = "1.2.0.Final"
    const val kolor = "0.0.2"
    const val ktlint = "0.37.0"
    const val mockk = "1.10.0"
    const val reactiveStreams = "1.0.2"
    const val reactor = "3.2.5.RELEASE"
    const val ff4j = "1.3.0"
    const val jmh = "1.21"
    const val petitparser = "2.3.1"
    const val shrinkwrap = "3.1.4"
    const val mockserver = "5.10.0"
    const val openapiGen = "4.3.1"
    const val methanol = "1.2.0"
    const val rocker = "1.3.0"
    const val jgrapht = "1.5.0"
    const val googleAuto = "1.0-rc7"
    const val jgitver = "0.12.0"

    // Plugins
    const val shadow = "6.0.0"
    const val micronautPlugin = "1.0.0.M9"
    const val googleJib = "2.5.0"
    const val protobuf = "0.8.13"
    const val sonarqube = "2.7"
    const val nemerosaVersioning = "2.8.2"
    const val springboot = "2.2.6.RELEASE"
    const val springDepMgmt = "1.0.9.RELEASE"
    const val buildSrcVersions = "0.3.2"
    const val changelog = "0.4.0"
    const val spotless = "5.1.1"
    const val spotlessChangelog = "2.0.0"
    const val ktlintPlugin = "9.3.0"
    const val detekt = "1.11.0-RC1"
    const val detektCompilerPlugin = "0.3.1"
    const val spotbugs = "4.3.0"
    const val googleJavaFormat = "1.8"
    const val benmanesVersions = "0.29.0"
    const val buildScanPlugin = "2.0.2"
    const val gitPublishPlugin = "1.0.1"
    const val swaggerGen = "2.16.0"
    const val gitProperties = "2.2.3"
    const val githubRelease = "2.2.12"
    const val gradleRelease = "2.8.1"
    const val mavenPublishAuth = "2.0.2"
    const val javafxPlugin = "0.0.7"
    const val jmhPlugin = "0.4.8"
    const val mrjar = "0.0.16"
    const val jgitPlugin = "0.10.0-rc03"
    const val reckon = "0.12.0"
    const val mkdocs = "2.0.1"
    const val orchid = "0.21.1"
}

object Deps {
    val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    val kotlinTest = "org.jetbrains.kotlin:kotlin-test:$kotlinVersion"
    val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"

    const val kotlinxSerializationCore =
        "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
    const val kotlinxSerializationproperties =
        "org.jetbrains.kotlinx:kotlinx-serialization-properties:${Versions.kotlinxSerialization}"
    const val kotlinxSerializationProtobuf =
        "org.jetbrains.kotlinx:kotlinx-serialization-protobuf:${Versions.kotlinxSerialization}"
    const val kotlinxSerializationYaml = "com.charleskorn.kaml:kaml:${Versions.kaml}"
    const val kotlinxReflectLite =
        "org.jetbrains.kotlinx:kotlinx.reflect.lite:${Versions.kotlinxReflectLite}"
    const val kotlinxAtomicfu = "org.jetbrains.kotlinx:atomicfu:${Versions.kotlinxAtomicfu}"

    const val kotlinIO = "org.jetbrains.kotlinx:kotlinx-io-jvm:${Versions.kotlinIO}"
    const val kotlinImmutableColl =
        "org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:${Versions.kotlinImmutableColl}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesJdk8 =
        "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.coroutines}"
    const val coroutinesReactor = "org.jetbrains.kotlinx:coroutines-reactor:${Versions.coroutines}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val coroutinesDebug =
        "org.jetbrains.kotlinx:kotlinx-coroutines-debug:${Versions.coroutines}"

    const val okio = "com.squareup.okio:okio:${Versions.okio}"
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpMockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val okhttpSse = "com.squareup.okhttp3:okhttp-sse:${Versions.okhttp}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val okhttpTLS = "com.squareup.okhttp3:okhttp-tls:${Versions.okhttp}"
    const val okhttpUDS = "com.squareup.okhttp3.sample:unixdomainsockets:${Versions.okhttp}"
    const val okhttpDigest = "com.baulsupp:okhttp-digest:0.4.0"
    const val okhttpDoh = "com.squareup.okhttp3:okhttp-dnsoverhttps:${Versions.okhttp}"
    const val ok2Curl = "com.github.mrmike:ok2curl:${Versions.ok2Curl}"
    const val certifikit = "app.cash.certifikit:certifikit:${Versions.certifikit}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofitLogging =
        "com.nightlynexus.logging-retrofit:logging:${Versions.loggingRetrofit}"
    const val retrofitReactorAdapter =
        "com.jakewharton.retrofit:retrofit2-reactor-adapter:${Versions.retrofitReactorAdapter}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"
    const val retrofitSerializationAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitSerializationAdapter}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"

    const val micronautBom = "io.micronaut:micronaut-bom:${Versions.micronaut}"
    const val methanol = "com.github.mizosoft.methanol:methanol:${Versions.methanol}"
    const val bouncyCastle = "org.bouncycastle:bcprov-jdk15on:${Versions.bouncyCastle}"
    const val conscryptUber = "org.conscrypt:conscrypt-openjdk-uber:${Versions.conscrypt}"
    const val tink = "com.google.crypto.tink:tink:${Versions.tink}"
    const val sshj = "com.hierynomus:sshj:${Versions.sshj}"
    const val smbj = "com.hierynomus:smbj:${Versions.smbj}"
    const val asn1 = "com.hierynomus:asn-one:${Versions.asn1}"

    const val autoService = "com.google.auto.service:auto-service:${Versions.googleAuto}"

    const val slf4jApi = "org.slf4j:slf4j-api:${Versions.slf4j}"
    const val slf4jSimple = "org.slf4j:slf4j-simple:${Versions.slf4j}"
    const val slf4jNop = "org.slf4j:slf4j-nop:${Versions.slf4j}"

    const val caffeine = "com.github.ben-manes.caffeine:caffeine:${Versions.caffeine}"
    const val cache2kApi = "org.cache2k:cache2k-api:${Versions.cache2k}"
    const val cache2kCore = "org.cache2k:cache2k-core:${Versions.cache2k}"

    const val jibCore = "com.google.cloud.tools:jib-core:${Versions.jibCore}"
    const val failsafe = "net.jodah:failsafe:${Versions.failsafe}"
    const val typetools = "net.jodah:typetools:${Versions.typetools}"
    const val nettyResolveDns = "io.netty:netty-resolver-dns:${Versions.netty}"
    const val jffi = "com.github.jnr:jffi:${Versions.jnrJffi}"
    const val jnrUnixSocket = "com.github.jnr:jnr-unixsocket:${Versions.jnrUnixSocket}"
    const val commonsIO = "commons-io:commons-io:${Versions.commonsIO}"
    const val commonsCodec = "commons-codec:commons-codec:${Versions.commonsCodec}"
    const val jjwt = "io.jsonwebtoken:jjwt-api:${Versions.jjwt}"
    const val jjwtImpl = "io.jsonwebtoken:jjwt-impl:${Versions.jjwt}"
    const val jjwtJackson = "io.jsonwebtoken:jjwt-jackson:${Versions.jjwt}"
    const val jkeychain = "pt.davidafsilva.apple:jkeychain:${Versions.jkeychain}"
    const val jfreesvg = "org.jfree:jfreesvg:${Versions.jfreesvg}"
    const val orsonpdf = "com.orsonpdf:orsonpdf:${Versions.orsonpdf}"
    const val openpdf = "com.github.librepdf:openpdf:${Versions.openpdf}"
    const val jimfs = "com.google.jimfs:jimfs:${Versions.jimfs}"
    const val jsr305 = "com.google.code.findbugs:jsr305:${Versions.jsr305}"
    const val petitparser = "com.github.petitparser:petitparser-core:${Versions.petitparser}"
    const val rocker = "com.fizzed:rocker:${Versions.rocker}"
    const val jgrapht = "org.jgrapht:jgrapht-core:${Versions.jgrapht}"

    const val clikt = "com.github.ajalt:clikt:${Versions.clikt}"
    const val mordant = "com.github.ajalt:mordant:${Versions.mordant}"
    const val colormath = "com.github.ajalt:colormath:${Versions.colormath}"
    const val picnic = "com.jakewharton.picnic:picnic:${Versions.picnic}"

    const val jline = "org.jline:jline:${Versions.jline}"
    const val jlineTerminal = "org.jline:jline-terminal:${Versions.jline}"
    const val jlineReader = "org.jline:jline-reader:${Versions.jline}"
    const val ztExec = "org.zeroturnaround:zt-exec:${Versions.ztExec}"
    const val brotli = "org.brotli:dec:${Versions.brotli}"

    const val asm = "org.ow2.asm:asm:${Versions.asm}"
    const val asmUtil = "org.ow2.asm:asm-util:${Versions.asm}"
    const val byteBuddy = "net.bytebuddy:byte-buddy:${Versions.byteBuddy}"
    const val jol = "org.openjdk.jol:jol-core:${Versions.jol}"
    const val japicmp = "com.github.siom79.japicmp:japicmp:${Versions.japicmp}"
    const val kolor = "com.andreapivetta.kolor:kolor:${Versions.kolor}"

    const val reactiveStreams = "org.reactivestreams:reactive-streams:${Versions.reactiveStreams}"
    const val reactiveStreamsFlowAdapters =
        "org.reactivestreams:reactive-streams-flow-adapters:${Versions.reactiveStreams}"
    const val reactorCore = "io.projectreactor:reactor-core:${Versions.reactor}"
    const val reactorTest = "io.projectreactor:reactor-test:${Versions.reactor}"

    const val eclipseCollections =
        "org.eclipse.collections:eclipse-collections:${Versions.eclipseCollections}"
    const val eclipseCollectionsApi =
        "org.eclipse.collections:eclipse-collections-api:${Versions.eclipseCollections}"
    const val trov4j = "org.jetbrains.intellij.deps:trove4j:${Versions.trov4j}"
    const val ff4j = "org.ff4j:ff4j-core:${Versions.ff4j}"
    const val jmhCore = "org.openjdk.jmh:jmh-core:${Versions.jmh}"
    const val jmhGenAnnprocess = "org.openjdk.jmh:jmh-generator-annprocess:${Versions.jmh}"

    const val graalSdk = "org.graalvm.sdk:graal-sdk:${Versions.graal}"
    const val graalSvm = "org.graalvm.nativeimage:svm:${Versions.graal}"

    const val rsocketCore = "io.rsocket:rsocket-core:${Versions.rsocket}"
    const val rsocketNetty = "io.rsocket:rsocket-transport-netty:${Versions.rsocket}"

    const val openapiGen = "org.openapitools:openapi-generator:${Versions.openapiGen}"
    const val swaggerUI = "org.webjars:swagger-ui:${Versions.swaggerUI}"
    const val swaggerCodegenCli =
        "io.swagger.codegen.v3:swagger-codegen-cli:${Versions.swaggerCodegenCli}"
    const val junitJupiter = "org.junit.jupiter:junit-jupiter:${Versions.junit}"
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val junitJupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit}"
    const val shrinkwrap =
        "org.jboss.shrinkwrap.resolver:shrinkwrap-resolver-depchain:${Versions.shrinkwrap}"
    const val jgitver = "fr.brouillard.oss:jgitver:${Versions.jgitver}"

    const val assertjCore = "org.assertj:assertj-core:${Versions.assertj}"
    const val kotlinPowerAssert =
        "com.bnorm.power:kotlin-power-assert:${Versions.kotlinPowerAssert}"
    const val googleTruth = "com.google.truth:truth:${Versions.truth}"

    const val awaitility = "org.awaitility:awaitility:${Versions.awaitility}"
    const val awaitilityKotlin = "org.awaitility:awaitility-kotlin:${Versions.awaitility}"

    const val kotestAssertions = "io.kotlintest:kotlintest-assertions:${Versions.kotest}"
    const val kotestJUnit5Runner = "io.kotest:kotest-runner-junit5-jvm:${Versions.kotest}"

    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockserver = "org.mock-server:mockserver-netty:${Versions.mockserver}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    object Smile {
        const val version = "2.5.0"
        const val plot = "com.github.haifengl:smile-plot:$version"
        const val core = "com.github.haifengl:smile-core:$version"
        const val vega = "com.github.haifengl:smile-scala_2.13:$version"
    }

    object Dokka {
        const val version = "1.4.0-rc"
        val gradlePlugin = "org.jetbrains.dokka:dokka-gradle-plugin:$version"
        val javadocPlugin = "org.jetbrains.dokka:javadoc-plugin:$version"
        val kotlinAsJavaPlugin = "org.jetbrains.dokka:kotlin-as-java-plugin:$version"
        val gfmPlugin = "org.jetbrains.dokka:gfm-plugin:$version"
        val jekyllPlugin = "org.jetbrains.dokka:jekyll-plugin:$version"
        val mathjaxPlugin = "org.jetbrains.dokka:mathjax-plugin:$version"
    }
}

/**
 * Returns the system properties value of the given string.
 */
val String.systemProp: String get() = System.getProperty(this, "")

/**
 * PluginId Extensions
 */
inline val PluginDependenciesSpec.kotlinJvm get() = kotlin("jvm") version kotlinVersion
inline val PluginDependenciesSpec.kotlinxSerialization get() = kotlin("plugin.serialization") version kotlinVersion
inline val PluginDependenciesSpec.kotlinKapt get() = kotlin("kapt") version kotlinVersion
inline val PluginDependenciesSpec.kotlinSpring get() = kotlin("plugin.spring") version kotlinVersion
inline val PluginDependenciesSpec.kotlinAllOpen get() = kotlin("plugin.allopen") version kotlinVersion
inline val PluginDependenciesSpec.kotlinNoArg get() = kotlin("plugin.noarg") version kotlinVersion
inline val PluginDependenciesSpec.kotlinJpa get() = kotlin("plugin.jpa") version kotlinVersion
inline val PluginDependenciesSpec.kotlinScript get() = kotlin("plugin.scripting") version kotlinVersion
inline val PluginDependenciesSpec.dokka get() = id("org.jetbrains.dokka") version Deps.Dokka.version
inline val PluginDependenciesSpec.changelog get() = id("org.jetbrains.changelog") version Versions.changelog
inline val PluginDependenciesSpec.shadow get() = id("com.github.johnrengelman.shadow") version Versions.shadow
inline val PluginDependenciesSpec.protobuf get() = id("com.google.protobuf") version Versions.protobuf
inline val PluginDependenciesSpec.benmanesVersions get() = id("com.github.ben-manes.versions") version Versions.benmanesVersions
inline val PluginDependenciesSpec.gitProperties get() = id("com.gorylenko.gradle-git-properties") version Versions.gitProperties
inline val PluginDependenciesSpec.spotless get() = id("com.diffplug.spotless") version Versions.spotless
inline val PluginDependenciesSpec.spotlessChangelog get() = id("com.diffplug.spotless-changelog") version Versions.spotlessChangelog
inline val PluginDependenciesSpec.spotbugs get() = id("com.github.spotbugs") version Versions.spotbugs
inline val PluginDependenciesSpec.ktlint get() = id("com.eden.orchidPlugin") version Versions.ktlintPlugin
inline val PluginDependenciesSpec.detekt get() = id("io.gitlab.arturbosch.detekt") version Versions.detekt
inline val PluginDependenciesSpec.detektCompilerPlugin get() = id("io.github.detekt.gradle.compiler-plugin") version Versions.detektCompilerPlugin
inline val PluginDependenciesSpec.githubRelease get() = id("com.github.breadmoirai.github-release") version Versions.githubRelease
inline val PluginDependenciesSpec.gradleRelease get() = id("net.researchgate.release") version Versions.gradleRelease
inline val PluginDependenciesSpec.mavenPublishAuth get() = id("org.datlowe.maven-publish-auth") version Versions.mavenPublishAuth
inline val PluginDependenciesSpec.javafx get() = id("org.openjfx.javafxplugin") version Versions.javafxPlugin
inline val PluginDependenciesSpec.jmh get() = id("me.champeau.gradle.jmh") version Versions.jmhPlugin
inline val PluginDependenciesSpec.mrjar get() = id("com.lingocoder.mrjar") version Versions.mrjar
inline val PluginDependenciesSpec.googleJib get() = id("com.google.cloud.tools.jib") version Versions.googleJib
inline val PluginDependenciesSpec.springboot get() = id("org.springframework.boot") version Versions.springboot
inline val PluginDependenciesSpec.springDepMgmt get() = id("io.spring.dependency-management") version Versions.springDepMgmt
inline val PluginDependenciesSpec.micronautApplication get() = id("io.micronaut.application") version Versions.micronautPlugin
inline val PluginDependenciesSpec.micronautLibrary get() = id("io.micronaut.library") version Versions.micronautPlugin
inline val PluginDependenciesSpec.jgitPlugin get() = id("fr.brouillard.oss.gradle.jgitver") version Versions.jgitPlugin
inline val PluginDependenciesSpec.reckon get() = id("org.ajoberstar.reckon") version Versions.reckon
inline val PluginDependenciesSpec.mkdocs get() = id("ru.vyarus.mkdocs") version Versions.mkdocs
inline val PluginDependenciesSpec.orchid get() = id("com.eden.orchidPlugin") version Versions.orchid