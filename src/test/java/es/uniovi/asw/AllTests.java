package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CheckerTest.class,
	CitizenTest.class, 
	EmailGeneratorTest.class, 
	MD5Test.class,
	ReadTest.class,
	BDTest.class})
public class AllTests {
}