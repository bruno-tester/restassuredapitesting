package br.com.restassuredapitesting.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses({
        AcceptanceCriticalTests.class,
        AcceptanceExceptionTests.class
})
public class AcceptanceTests {
}