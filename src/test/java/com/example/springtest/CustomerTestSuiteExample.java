package com.example.springtest;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@IncludeTags("testEnv")
@Suite
@SelectClasses( TestCustomerControllerSliced.class )
@SuiteDisplayName("Testing several tests at once")
public class CustomerTestSuiteExample {

}
