package com.quantumofvalue.java.agileguru.cucumber.features;


import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:com/quantumofvalue/java/agileguru/cucumber/features/WalkingSkeleton.feature",
				  glue="com.quantumofvalue.java.agileguru.cucumber.stepdefinitions")
public class WalkingSkeletonFeature {
}
