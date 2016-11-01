package info.batey.djvm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;

@Path("/")
public class Service {

    @GET
    @Path("/count-prime/{num}")
    public String callout(@PathParam("num") long num) throws IOException {
        long primes = 0;
        for (int i = 0; i < num; i++) {
           if (isPrime(i)) primes++;
        }
        return String.valueOf(primes);
    }

    boolean isPrime(long n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
