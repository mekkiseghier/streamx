package com.github.mekkiseghier.streamx;

/**
 * The {@code F} class defines a comprehensive set of functional interfaces for
 * working with stateless computations of varying arities (1 to 8) over four common data types:
 * {@code double}, {@code int}, {@code String}, and {@code boolean}.
 *
 * <p>Each interface (e.g., {@code f3d}, {@code f2s}, {@code f5b}) represents a functional contract
 * that takes a fixed number of arguments of a specific type and returns a result of the same type.
 * These interfaces are useful for high-arity functional programming, DSL design,
 * functional evaluation engines, or any scenario where Java's standard functional interfaces are insufficient.
 *
 * <p>Example usage:
 * <pre>{@code
 *     F.f3d average = (v1, v2, v3) -> (v1 + v2 + v3) / 3;
 *     double result = average.apply(2.0, 4.0, 6.0); // 4.0
 * }</pre>
 *
 * <p>This design avoids boxing overhead for primitives and enables more expressive and type-safe lambda usage.
 */

public class f {
    // Doubles: d1 to d8
    public interface d1 {
        double apply( double v1 );
    }
    public interface d2 {
        double apply( double v1, double v2 );
    }
    public interface d3 {
        double apply( double v1, double v2, double v3 );
    }
    public interface d4 {
        double apply( double v1, double v2, double v3, double v4 );
    }
    public interface d5 {
        double apply( double v1, double v2, double v3, double v4, double v5 );
    }
    public interface d6 {
        double apply( double v1, double v2, double v3, double v4, double v5, double v6 );
    }
    public interface d7 {
        double apply( double v1, double v2, double v3, double v4, double v5, double v6, double v7 );
    }
    public interface d8 {
        double apply( double v1, double v2, double v3, double v4, double v5, double v6, double v7, double v8 );
    }
    // Integers: i1 to i8
    public interface i1 {
        int apply( int v1 );
    }
    public interface i2 {
        int apply( int v1, int v2 );
    }
    public interface i3 {
        int apply( int v1, int v2, int v3 );
    }
    public interface i4 {
        int apply( int v1, int v2, int v3, int v4 );
    }
    public interface i5 {
        int apply( int v1, int v2, int v3, int v4, int v5 );
    }
    public interface i6 {
        int apply( int v1, int v2, int v3, int v4, int v5, int v6 );
    }
    public interface i7 {
        int apply( int v1, int v2, int v3, int v4, int v5, int v6, int v7 );
    }
    public interface i8 {
        int apply( int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8 );
    }
    // Strings: s1 to s2
    public interface s1 {
        String apply( String v1 );
    }
    public interface s2 {
        String apply( String v1, String v2 );
    }
    public interface s3 {
        String apply( String v1, String v2, String v3 );
    }
    public interface s4 {
        String apply( String v1, String v2, String v3, String v4 );
    }
    public interface s5 {
        String apply( String v1, String v2, String v3, String v4, String v5 );
    }
    public interface s6 {
        String apply( String v1, String v2, String v3, String v4, String v5, String v6 );
    }
    public interface s7 {
        String apply( String v1, String v2, String v3, String v4, String v5, String v6, String v7 );
    }
    public interface s8 {
        String apply( String v1, String v2, String v3, String v4, String v5, String v6, String v7, String v8 );
    }
    // Booleans: b1 to b8
    public interface b1 {
        boolean apply( boolean v1 );
    }
    public interface b2 {
        boolean apply( boolean v1, boolean v2 );
    }
    public interface b3 {
        boolean apply( boolean v1, boolean v2, boolean v3 );
    }
    public interface b4 {
        boolean apply( boolean v1, boolean v2, boolean v3, boolean v4 );
    }
    public interface b5 {
        boolean apply( boolean v1, boolean v2, boolean v3, boolean v4, boolean v5 );
    }
    public interface b6 {
        boolean apply( boolean v1, boolean v2, boolean v3, boolean v4, boolean v5, boolean v6 );
    }
    public interface b7 {
        boolean apply( boolean v1, boolean v2, boolean v3, boolean v4, boolean v5, boolean v6, boolean v7 );
    }
    public interface b8 {
        boolean apply( boolean v1, boolean v2, boolean v3, boolean v4, boolean v5, boolean v6, boolean v7, boolean v8 );
    }
}


