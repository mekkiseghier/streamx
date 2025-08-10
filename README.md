# Zipper

**Zipper** is a Java utility library that enables **type-safe, index-aware parallel iteration** over multiple lists — up to 20 in parallel — with clean syntax, powerful functional interfaces, and zero external dependencies.

> 🔧 Supports constructing and modifying multiple object instances in parallel  
>  No reflection. No unsafe casts. Just fast, readable logic.

---

##  Features

- Zipper of **1 to 20 lists** (type-safe)
- Lambda support with **element and index**
- Fallback to raw entry with index access for sizes greater than 20
- Fluent stream operations: `.forEach()`, `.map()`, `.filter()`, `.reduce()`, `.peek()`, `.anyMatch()`, `.allMatch()`,
  `.asTupleList()`, `.size()`
- Easy expansion via `.addElements(...)`, `.addList(...)`, `.addLists(...)`
- `Zipper.generateList(...)` factory method with index-based element creation

---

##  Example Usage

### Implicitly

```java
List < Button > buttons = Zipper.addElements( "OK", "Cancel", "Open", "Save", "Close", "Edit" )
        .addElements( Color.RED, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA )
        .map( ( i, text, color ) ->
            {
        Button b = new Button(text);
        b.setBackground(color);
        return b;
            //  Type-safe: values are checked at compile-time
            } );
Zipper.addElements("A","B","C" ).addElements(10,20,30 ).addElements(true,false,true )
    .forEach((i, str, num, flag) ->
        System.out.println(i + ": " + str + ", " + num + ", " + flag)
//  Type-checked, no casting required
    );
```


### Explicitly

```java
import com.github.mekkiseghier.zipper.Zipper;

List < Integer > numbers = List.of( 41, 40, 35 );
Zipper2 < String, Integer > zipper2 = Zipper.addElements( "Alice", "Bob", "Charlie" ).addList( numbers );
// Dynamic Expansion To Support New Type!! ♻
zipper2.filter((index, v1, v2 ) ->v1.contains("a" ) &&v2 < 40).
forEach((index, v1, v2 ) ->System.out.println("found: "+index +", name = "+v1+", age = "+v2 ));
```
---

## 🧪 Factory Methods

```java
// (1) Constructing from multiple lists
List<String> names = List.of("Jessica", "Bob", "Charlie");
List<Integer> ages = List.of(41, 40, 35);
List<Boolean> online = List.of(false, true, true);

Zipper.addLists( names, ages, online ).forEach((index, name, age, isOnline ) ->
        System.out.println((index +1 ) +": "+name +" is "+age +" years old, online: "+isOnline));
// (2) Combining varargs and a list
List<Double> nums = List.of(1.2, 3.2, 4.2);
Zipper.addElements("A","B","C" ).addElements(1,2,3 ).addList( nums )
.forEach((i, a, b, c ) ->System.out.println( i +": "+a+", "+b+", "+c ));
// (3) Using a supplier to generate 5 elements
ScrollPane scrollPane = new ScrollPane();
Zipper.generateList(5,index ->newButton("My button number "+index ))
        .forEach((index, button ) ->scrollPane.add( button ));
```
---

## 🧪 Constructor

// Constructing Via Lists

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
List<Integer> ages = List.of(30, 25, 28);
List<Boolean> active = List.of(true, false, true);
Zipper3 < String, Integer, Boolean > stream = new Zipper3 <>( names, ages, active );
stream.forEach((i, name, age, isActive ) ->System.out.println( i +": "+name+" ("+age+") - active: "+isActive ));
```

---

##  Custom Functional Interfaces

This library includes **parameterized, index-aware functional interfaces**  
to cover what Java’s standard `Function`, `Consumer`, and `Predicate` don’t —  
Also includes math/logic functions for int, double, and boolean types (1 to 8 arguments)

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

- `Consumer2` → `Consumer20`
- `Function2` → `Function20`
- `Predicate2` → `Predicate20`
- `Accumulator2` → `Accumulator20`
- `f.d1` → `f.d8`(for math functions)

```java
// With this structure, you can define an entire scientific library with reusable formulas:

public static final f.d2 kineticEnergy = (m, v) -> 0.5 * m * v * v;
public static final f.d3 quadraticRoot = (a, b, c) -> (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
public static final f.d4 dragForce = (rho, v, A, Cd) -> 0.5 * rho * v * v * A * Cd;
```

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
  <version>v1.0.2</version>
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
  implementation 'com.github.mekkiseghier:zipper:v1.0.2'
}
```
---

## 📝 License

MIT License. See [LICENSE](./LICENSE) for details.

---

##  Author

**[Mekki Seghier](https://github.com/mekkiseghier)**  
Bringing simplicity and power to Java iteration.
