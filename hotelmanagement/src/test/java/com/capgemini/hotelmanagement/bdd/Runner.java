package com.capgemini.hotelmanagement.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue = {"com.capgemini.hotelmanagement"},tags= {"@Feature7"})
public class Runner  {

}
