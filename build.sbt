name := "checkoutLambda"

version := "0.1"

scalaVersion := "2.12.8"

chuckRegion := "us-east-2"

libraryDependencies ++= Seq(
  "com.itv.chuckwagon" %% "chuckwagon-jvm" % "0.1.4-SNAPSHOT",
  "com.github.seratch" %% "awscala-sqs" % "0.8.+"
)

chuckPublishConfig := chuckPublishConfigBuilder
  .withName("Checkout-Lambda")
  .withHandler("GetBasket::handleRequest")
  .withMemorySizeInMB(192)
  .withTimeout("5 seconds")
  .withStagingBucketName("checkout-lambda")
  .withCodeFile(assembly)

enablePlugins(ChuckwagonPublishPlugin)