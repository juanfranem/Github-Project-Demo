# Github Demo project

Esta app es una demostración de librerias que en su conjunto a nivel visual consiguen listar los repositorios de los usuarios previavemente buscados por medio de su buscador utilizando para ello el API Rest de Github.

## Desarrollo


### Configuración del entorno
En primer lugar, necesitas la última versión de Android Studio 4.1.0 (o más reciente) para poder crear la aplicación.

Es necesario el api key de github. Puedes encontrar información sobre cómo obtenerlo en el siguiente [enlace](https://docs.github.com/es/rest/guides/getting-started-with-the-rest-api).

Cuando obtengas las claves, debes crear un archivo a nivel root en el proyecto llamado api_keys.properties con los siguientes valores:
```properties
URL_BASE=api.github.com
API_KEY= [AQUI TU API KEY]
```
## Tecnologías utilizadas

### Dependencias

-   [Jetpack](https://developer.android.com/jetpack):
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html) - proporciona la base necesaria para el API de jetpack a la plataforma Android.
    -   [AndroidX](https://developer.android.com/jetpack/androidx).
    -   [View Binding](https://developer.android.com/topic/libraries/data-binding/) - La biblioteca de vinculación de datos es una biblioteca de compatibilidad que permite vincular los componentes de la IU de tus diseños a las fuentes de datos de tu app usando un formato declarativo en lugar de la programación.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Los componentes optimizados para ciclos de vida realizan acciones como respuesta a un cambio en el estado del ciclo de vida de otro componente, como actividades o fragmentos.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - consciente del ciclo de vida, lo que significa que respeta el ciclo de vida de otros componentes de la aplicación, como las actividades, los fragmentos o los servicios.
    -   [Navigation](https://developer.android.com/guide/navigation/) - le ayuda a implementar la navegación, desde simples clics de botones hasta patrones más complejos, como las barras de aplicaciones y el cajón de navegación.
    -   [Paging](https://developer.android.com/topic/libraries/architecture/paging/) - ayuda a cargar y mostrar pequeños trozos de datos a la vez. La carga de datos parciales bajo demanda reduce el uso del ancho de banda de la red y de los recursos del sistema.
    -   [Room](https://developer.android.com/topic/libraries/architecture/room) - La biblioteca de persistencia proporciona una capa de abstracción sobre SQLite para permitir un acceso más robusto a la base de datos mientras se aprovecha toda la potencia de SQLite.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - diseñado para almacenar y gestionar los datos relacionados con la interfaz de usuario de una manera consciente del ciclo de vida. La clase ViewModel permite que los datos sobrevivan a los cambios de configuración, como las rotaciones de pantalla.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - gestión de hilos en segundo plano con código simplificado y reducción de las necesidades de callbacks.
-   [Koin](https://insert-koin.io/) - Koin es un marco de inyección de dependencias pragmático y ligero para los desarrolladores de Kotlin.
-   [Ktor](https://ktor.io/) - type-safe HTTP client.
-   [Glide](https://github.com/bumptech/glide) - Glide es un marco de gestión de medios y carga de imágenes de código abierto, rápido y eficiente, para Android.

### Plugins
-   [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) - genera clases simples de objetos y constructores para una navegación segura y el acceso a cualquier argumento asociado.

## Arquitectura

### Módulos

#### application
El módulo `:application` es un [com.android.application](https://developer.android.com/studio/build/), que es necesario para crear el paquete de aplicaciones. También es responsable de iniciar el gráfico de dependencias, reproducir el núcleo y otras dependencias globales del proyecto, diferenciando especialmente entre los diferentes entornos de la app.

#### domain

El módulo `:domain` es una librería de java que tan solo contiene la lógica de negocio necesaria para hacer funcionar nuestra aplicación definiendo cómo va a funcionar a nivel de datos.

#### github-sdk

Este módulo `:github-sdk` al igual que  `:domain` es una librería java, pero es la encargada de hacer las peticiones http, no conoce otra cosa que no sea el dominio y no puede exponerse a si misma si no es por medio de la inyección de dependencias gracias a `koin`.

#### room

El módulo `:room` se encarga de guardar en base de datos las búsquedas anteriores para tener un histórico, es una [com.android.library](https://developer.android.com/studio/projects/android-library), por lo tanto, utiliza las librerias de android para poder funcionar. Al igual que `:github-sdk`, no se expone, solo lo hace con `koin.`



