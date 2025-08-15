# Zipper

**Zipper** is a Java utility library that enables **type-safe, index-aware parallel iteration** over multiple lists — up
to 8 in parallel —
with clean syntax, powerful functional interfaces, and zero external dependencies.

> 🔧 Supports constructing and modifying multiple object instances in parallel  
>  No reflection. No unsafe casts. Just fast, readable logic.

---

##  Features

- Zipper of **1 to 8 lists** (type-safe)
- Lambda support with **element and index**
- Fallback to raw entry with index access for sizes greater than 8
- Fluent stream operations: `.forEach()`, `.map()`, `.filter()`, `.reduce()`, `.peek()`, `.anyMatch()`, `.allMatch()`,
  `.asTupleList()`, `.size()`
- Easy expansion via `.zip(...)`, `.zipList(...)`, `.zipper(...)`


---

##  Example Usage

### Implicitly

```java

List < Button > buttons = Zipper.zip1( "OK", "Cancel", "Open", "Save", "Close", "Edit" )
        .zip2( Color.RED, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA ).
                map2( ( i, text, color ) -> {
          Button b = new Button( text );
          b.setBackground( color );
          return b;
//  Type-safe: values are checked at compile-time
          } );
Zipper.zip1("A","B","C" ).zip2(10,20,30 ).zip3(true,false,true )
    .forEach((i, str, num, flag ) ->
        System.out.println( i +": "+str+", "+num+", "+flag )
//  Type-checked, no casting required
    );

```


### Explicitly

```java

List < Integer > numbers = List.of( 41, 40, 35 );
Zipper2 < String, Integer > zipper2 = Zipper.zip1( "Alice", "Bob", "Charlie" ).zipList2( numbers );
// Dynamic Expansion To Support New Type!! 
        zipper2.filter2( ( index, v1, v2 ) -> v1.contains( "a" ) && v2 < 40 )
        .forEach2( (index, v1, v2 ) ->
        System.out.println( "found: "+index +", name = "+v1+", age = "+v2 ) );
        
```
---

## 🧪 Factory Methods

```java
        // (1) Constructing from multiple lists

List < String > names = List.of( "Jessica", "Bob", "Charlie" );
List < Integer > ages = List.of( 41, 40, 35 );
List < Boolean > online = List.of( false, true, true );
        Zipper.zipper3( names, ages, online )
                .forEach3( (index, name, age, isOnline ) ->
        System.out.println( (index +1 ) +": "+name +" is "+age +" years old, online: "+isOnline ));
        
// (2) Combining varargs and a list
List < Double > nums = List.of( 1.2, 3.2, 4.2 );
        Zipper.zip1( "A","B","C" ).zip2( 1,2,3 ).zipList3( nums )
.forEach3( (i, a, b, c ) ->
        System.out.println( i +": "+a+", "+b+", "+c ) );
        

```
---

## 🧪 Constructor

// Constructing Via Lists

```java
        List<String> names = List.of("Alice", "Bob", "Charlie");
List<Integer> ages = List.of(30, 25, 28);
List<Boolean> active = List.of(true, false, true);
Zipper3 < String, Integer, Boolean > zipper3 = new Zipper3 <>( names, ages, active );
        zipper3.forEach3((i, name, age, isActive ) ->
        System.out.println( i +": "+name+" ("+age+") - active: "+isActive ));
```

---

##  Custom Functional Interfaces

This library includes **parameterized, index-aware functional interfaces**  
to cover what Java’s standard `Function`, `Consumer`,`Accumulator` and `Predicate` don’t 

###  Why?

Java lacks:

Functional interfaces with more than 2 parameters

Index-awareness in lambdas

This library solves both, with fully typed and reusable interfaces.

---

###  Examples

```java

@FunctionalInterface
public interface Consumer4<I, T1, T2, T3, T4> {
    void accept(I index, T1 v1, T2 v2, T3 v3, T4 v4);
}

@FunctionalInterface
public interface Function5<I, T1, T2, T3, T4, T5, R> {
    R apply(I index, T1 v1, T2 v2, T3 v3, T4 v4, T5 v5);
}

```

---

###  Available Variants

- `Consumer2` → `Consumer8`
- `Function2` → `Function8`
- `Predicate2` → `Predicate8`
- `Accumulator2` → `Accumulator8`


>  You can use these interfaces **independently**, even outside of `Zipper`.

---

##  Installation (via JitPack)

Add this to your `pom.xml` :

```xml

<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
<groupId>com.github.mekkiseghier</groupId>
<artifactId>zipper</artifactId>
<version>1.0.9</version>
</dependency>


```

Or for Gradle:

```groovy

groovy
Copy
Edit
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
  implementation 'com.github.mekkiseghier:zipper:1.0.9'
}

```
---

## 📝 License

MIT License. See [LICENSE](./LICENSE) for details.

---

##  Author

**[Mekki Seghier](https://github.com/mekkiseghier)**  
Bringing simplicity and power to Java iteration.
