# Primeros Pasos
`SergioMod.java`
En este archivo se encuentra la lógica principal del programa. Aquí llamaremos a los eventos para enviarlos directamente al cliente. 
Cosas a tener en cuenta : 
- Cambiar el nombre del paquete `package net.sergio.sergiomod`
- Cambiar la ID del mod
  
  ```java
  public class SergioMod
  {
    public static final String MOD_ID = "sergiomod";
    ...
  }
  ```
- Eliminar el interior de los métodos `public void commonSetup()` `public void addCreative()`, `public void onServerStarting()`, `public void onClientSetup()`

---

# Creación de un Item Personalizado
### Estructura del proyecto

- sergio
  - sergiomod
    - item

Para ello, click derecho en _sergiomod_ y creamos un paquete llamado `item`. Dentro de ese paquete creamos una nueva clase de Java y la renombramos como `ModItems.java`.

---

### `ModItems.java`
Dentro de la clase `public class ModItems {...}` registramos una nueva lista de ITEMS en nuestro mod.


```java
    // crear una nueva lista de ITEMS en SergioMod
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SergioMod.MOD_ID);
```

.

Al final de la declaración de la clase, creamos un método `public static void register(IEventBus eventBus)` para registrar la clase en la versión de Forge especificada.


```java
    // Registrar esta lista en Forge
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
```

.


Para crear un nuevo item, debemos declarar un `RegistryObject` de tipo `ITEM`, a continuación, ponemos el nombre del item, y le asignamos el siguiente valor : `ITEMS.register("nombre del item", () -> new Item(new Item.Properties()));`. 

Con esta declaración lo que hacemos es crear un nuevo objeto de tipo ITEM, al cual le asignamos un nombre (nombre de la variable) y le damos un valor de ITEMS.register donde tenemos que especificar el nombre que se mostrará en la interfaz `"nombre del item"` y luego
un método donde le asignamos las propiedades por defecto del objeto tipo ITEM `new Item(new Item.Properties());`



```java
    // Registrar un nuevo item LITIO en la lista ITEMS, con el nombre "litio" y las propiedades por defecto Item.Properties()
    public static final RegistryObject<Item> LITIO = ITEMS.register("litio", () ->
            new Item(new Item.Properties()));

```

.


Lo realizamos de nuevo para el item de `bateria`


```java
    public static final RegistryObject<Item> BATERIA = ITEMS.register("bateria", () ->
            new Item(new Item.Properties()));
```
