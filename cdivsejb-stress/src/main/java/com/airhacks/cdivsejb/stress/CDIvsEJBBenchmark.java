package com.airhacks.cdivsejb.stress;

import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 *
 * @author airhacks.com
 */
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
public class CDIvsEJBBenchmark {

    @State(Scope.Benchmark)
    public static class ClientContext {

        @Param({"cdi", "ejb"})
        String tech;
        WebTarget tut;

        @Setup(Level.Trial)
        public void init() {
            Client client = ClientBuilder.newClient();
            this.tut = client.target("http://localhost:8080/cdivsejb/resources/{tech}");
        }
    }

    @Benchmark
    public void request(ClientContext context) {
        context.tut.resolveTemplate("tech", context.tech).
                request().get(String.class);
    }

}
