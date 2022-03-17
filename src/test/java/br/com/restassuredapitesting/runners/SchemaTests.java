package br.com.restassuredapitesting.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses({
        SchemaCriticalTests.class,
        SchemaExceptionTests.class
})
public class SchemaTests {
}