package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import contrato.Contrato;
import test.DBCTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	DBCTest.class,
	Contrato.class
})

public class Suite {
}
