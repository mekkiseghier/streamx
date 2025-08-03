# StreamX

**StreamX** is a Java utility library that enables **type-safe, index-aware parallel iteration** over multiple lists — up to 20 in parallel — with clean syntax, powerful functional interfaces, and zero external dependencies.

> 🔧 Supports constructing and modifying multiple object instances in parallel  
> ✅ No reflection. No unsafe casts. Just fast, readable logic.

---

## 🚀 Features

- Parallel streaming from **1 to 20 lists** (type-safe).
- ***Lambda support*** with **element and index**.
- Fallback to raw entry with index access for sizes greater than 20.
- *****Fluent Stream Processing Operations Via:***** `.forEach()`,`.map()`,`.filter()`,`.reduce()`,`.peek()`,`.anyMatch()`,`.allMatch()`,`.asTupleList()`and`.size()`.
- *****Easy expansion via***** `.and(...)`, `.with(...)`
- `StreamX.times(n)` factory method with index-based iteration.

---

## 🔍 Example Usage
#### Impllicitly:

```java
List < Button > buttons = StreamX.of( "OK", "Cancel", "Open", "Save", "Close", "Edit" )
        .and( Color.RED, Color.BLUE, Color.RED,Color.GREEN,Color.YELLOW,Color.MAGENTA)
                .map((i, text, color ) ->{
             Button b = new Button( text );
             b.setBackground( color );
             return b;
         // 🔒  Type-safe: all values are guaranteed to match types at compile-time 🔒
             });
```
```java
StreamX.of( "A", "B", "C" ).and( 10, 20, 30 ).and( true, false, true )
              .forEach( ( i, str, num, flag ) ->
                  System.out.println( i + ": " + str + ", " +num + ", " + flag )  
             //  ✅  Type-checked: no casting needed, fully generic  ✅ 
                );
```
#### Explicitly:

```java
List<Integer> numbers= List.of( 41, 40, 35);
StreamX2 <String,Integer> streamX2 = StreamX.of( "Alice", "Bob", "Charlie" ).with( numbers ); 
   //♻️ Dynamic Expansion To Support New Type!!♻️
streamX2.filter( (index, v1, v2 ) -> v1.contains( "a" ) && v2 < 40)
        .forEach( (index, v1, v2 ) ->System.out.println( "found :"+ index +", name = "+v1
        +", age = "+ v2 ));
```


---

## 🧪 Factory Methods

```java
//(1)Constructing From Lists

List<String> names= List.of("Jessica", "Bob", "Charlie");
List<Integer> ages = List.of( 41, 40, 35);
List<Boolean> Online= List.of(false, true, true);
        StreamX.from(names,ages ,Online).forEach( ( index, v1, v2, v3 ) ->
        System.out.println( (index+1) + ": " + v1 + " is " + v2 +
        " years old, with an online status " + v3 +".") );
 
// (2)Constructing Via Adding Varargs Or Adding A List

List < Double > nums = List.of( 1.2, 3.2, 4.2);
        StreamX.of( "A", "B", "C" ).and( 1, 2, 3 ).with( nums ).forEach(
                ( i, a, b, c ) -> System.out.println( i + ": " + a + ", " + b + ", " + c ) );

//(3) Initializing With A Supplier To Create 5 Copies!!

ScrollPane scrollPane=new ScrollPane();
StreamX.generateStartingListBasedOnIndex( 5,index -> new Button("My button number "+index) )
        .forEach( ( index, button ) -> scrollPane.add( button ) );
```
## 🧪 Constructor 

```java
//Constructing Via Lists
List<String> names = List.of("Alice", "Bob", "Charlie");
List<Integer> ages = List.of(30, 25, 28);
List<Boolean> active = List.of(true, false, true);

StreamX3<String, Integer, Boolean> streamX3 = new StreamX3<>(names, ages, active);
streamX3.forEach((i, name, age, isActive) -> {
    System.out.println(i + ": " + name + " (" + age + ") - active: " + isActive);});
```
---

## 🧠 Custom Functional Interfaces

This library includes **parameterized, index-aware functional interfaces**  
to cover what Java’s standard `Function`, `Consumer`, and `Predicate` don’t.
in addition to Math/logic Functions for intgers, double,booleans from 1 to 8 

### ✅ Why?

Java doesn’t support:

- Functional interfaces with more than 2 arguments
- Index-awareness

We solve that with ready-to-use, fully typed interfaces.

### ✨ Examples

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

### 📚 Available Variants

- `Consumer2` → `Consumer20`
- `Function2` → `Function20`
- `Predicate2` → `Predicate20`
- `Reducer2` → `Reducer20` 
- `f.d1` → `f.d8..etc` 

```java
//With this structure, you can define an entire scientific library with hundreds of reusable formulas like:
public static final f.d2 kineticEnergy = (m, v) -> 0.5 * m * v * v;
public static final f.d3 quadraticRoot = (a, b, c) -> (-b + Math.sqrt(b*b - 4*a*c)) / (2*a);
public static final f.d4 dragForce = (rho, v, A, Cd) -> 0.5 * rho * v * v * A * Cd;
```
> ✅ You can use these interfaces **independently**, even outside of `StreamX`.

---

## 📦 Installation (via JitPack)

To be published soon. Add this to your `pom.xml` when ready:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.mekkiseghier</groupId>
  <artifactId>streamx</artifactId>
  <version>1.0.0</version>
</dependency>
```

---

## 📝 License

MIT License. See [LICENSE](./LICENSE) for details.

---

## 👤 Author

**[Mekki Seghier](https://github.com/mekkiseghier)**  
Bringing simplicity and power to Java iteration.
