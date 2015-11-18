package com.airhacks.logging;

import java.util.logging.Logger;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 *
 * @author airhacks.com
 */
@BenchmarkMode(Mode.Throughput)
public class LoggerBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkContext {

        Logger LOG;

        @Setup(Level.Trial)
        public void initialize() {
            this.LOG = Logger.getLogger(LoggerBenchmark.class.getName());
        }

    }

    @Benchmark
    public void info(BenchmarkContext ctx) {
        ctx.LOG.info("+");
    }
}
