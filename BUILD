load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name="java-maven-lib",
    srcs = glob(["src/main/java/com/example/demo/**/*.java"]),
    deps = [
        "@maven//:com_google_inject_guice",
        "@maven//:javax_inject_javax_inject",

        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_jersey",
        "@maven//:io_dropwizard_dropwizard_metrics_graphite",

        "@maven//:com_codahale_metrics_metrics_annotation",
        "@maven//:com_codahale_metrics_metrics_healthchecks",

        "@maven//:javax_ws_rs_javax_ws_rs_api"],
)

java_binary(
    name = "app",
    main_class = "com.example.demo.App",
    runtime_deps=[":java-maven-lib"]
)