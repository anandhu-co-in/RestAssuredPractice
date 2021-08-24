import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RA_004_ParametersThroughTestNGXML {

    //Run from testng.xml to run with the passed paramenter, If ran from here it will take the default value

    @Parameters({"name"})
    @Test
    public void show(@Optional("defaultname") String name){

        System.out.println(name);
        //Now you can incorporate the rest assured code in this, I am skipping that for now, as it is self explanatory

    }
}

