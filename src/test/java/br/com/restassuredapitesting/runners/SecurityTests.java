package br.com.restassuredapitesting.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.SecurityTests.class)
@Suite.SuiteClasses({

})
public class SecurityTests {
}