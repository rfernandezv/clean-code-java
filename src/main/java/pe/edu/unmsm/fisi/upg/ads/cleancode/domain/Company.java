package pe.edu.unmsm.fisi.upg.ads.cleancode.domain;

import java.util.Arrays;
import java.util.List;

public class Company {
    public final static List<String> companies = Arrays.asList("Pluralsight", "Microsoft", "Google", "Fog Creek Software", "37Signals", "Telerik");
    
    public static boolean containsCompany(String company){
        return companies.contains(company);
    }
}
