package br.com.restassuredapitesting.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.AcceptanceTests.class)
@Suite.SuiteClasses({
        AcceptanceCriticalTests.class,
        AcceptanceExceptionTests.class,
        AcceptanceTests.class,
        E2ETests.class,
        SchemaCriticalTests.class,
        SchemaExceptionTests.class,
        SchemaTests.class,
        SecurityTests.class,
        SmokeTests.class
})
public class AllTests {
}