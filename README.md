# SGV-Manicurista

Sistema de reservas, citas y fichas de servicio para **Marie Nails** (salón de uñas), desarrollado en **Java** con **Programación Orientada a Objetos**.

Proyecto de la UD _Algoritmos para la solución de problemas_ (Certus). Corresponde a la **Evidencia 3 (AA3)**.

- **Equipo:** Jean Paul Moncada
- **Docente:** Yenner Yerson Mendoza Vilchez

---

## Qué hace el programa

El `Main` crea los objetos con `new`, llama a sus métodos y muestra los resultados en consola (sin menús ni ingreso de datos por teclado). El flujo que se prueba es:

1. **Catálogo:** los servicios, efectos y otros servicios del salón se toman del `Catalogo`; los precios están ahí, no se escriben a mano.
2. **Clientas:** una clienta normal (`Cliente`) y una clienta VIP (`ClienteVip`) con su descuento.
3. **Cita:** une a una clienta con un servicio del catálogo, en una fecha y hora.
4. **Reserva:** el **precio base** es el precio del servicio principal de la cita. La clienta paga un **adelanto de mínimo 50 %** del precio base; un adelanto menor, o mayor al precio base, se rechaza. La reserva pasa de **Pendiente** a **Confirmada** cuando se registra un adelanto válido.
5. **Agenda:** guarda las reservas y lista las que siguen pendientes.
6. **Ficha de servicio (`Factura`):** al finalizar el servicio se agregan:
   - tamaño de uña (con recargo)
   - varios efectos
   - reconstrucción de manos o pies (precio por dedo)
   - descuento (en % o en S/., con motivo y quién lo autorizó)
7. **Cuenta final:** `saldo a pagar = total - adelanto`. Se registra el tipo de pago y la ficha pasa a **Pagado**.

### Reglas de negocio

| Regla                 | Detalle                                                            |
| --------------------- | ------------------------------------------------------------------ |
| Descuento por clienta | Nueva 10 %, Normal 0 %, VIP 15 %                                   |
| Adelanto mínimo       | 50 % del precio base (precio del servicio principal del catálogo)  |
| Recargo por tamaño    | Tamaños 1 a 4 sin recargo; desde el 5 suben S/ 10 por número       |
| Efectos por ficha     | Se pueden marcar varios (hasta 19)                                 |
| Saldo                 | Total de la ficha menos el adelanto de la reserva (nunca negativo) |

---

## Estructura del proyecto

```
SGV-Manicurista/
├── modelo/
│   ├── Agenda.java      → guarda las reservas y lista las pendientes
│   ├── Catalogo.java    → servicios, efectos y otros del salón, con búsqueda por nombre
│   ├── Cita.java        → cliente, servicio, fecha y hora
│   ├── Cliente.java     → clase padre: nombre, apellido, teléfono, tipo de clienta y descuento
│   ├── ClienteVip.java  → hija de Cliente: beneficio y descuento propio
│   ├── Efecto.java      → hija de Servicio: efectos de nail art
│   ├── Factura.java     → ficha de servicio: efectos, tamaño de uña, descuento, saldo y pago
│   ├── Otro.java        → hija de Servicio: reconstrucción de manos o pies
│   ├── Reserva.java     → precio base, adelanto, saldo y estado (Pendiente / Confirmada)
│   └── Servicio.java    → clase padre: nombre y precio
└── principal/
    └── Main.java        → crea los objetos, llama a sus métodos y muestra los resultados
```

### Herencia entre clases

```
Cliente  ──► ClienteVip
Servicio ──► Efecto
         └─► Otro
```

### Conceptos de POO aplicados (rúbrica AA3)

| Criterio                         | Dónde se ve                                                                                                                                                                                                                    |
| -------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Programación orientada a objetos | Las 10 clases del paquete `modelo` colaboran: `Factura` usa `Reserva`, `Reserva` usa `Cita`, `Cita` usa `Cliente` y `Servicio`, `Agenda` guarda `Reserva`                                                                      |
| Clase y objeto                   | `Main` crea objetos con `new Cliente(...)`, `new ClienteVip(...)`, `new Catalogo()`, `new Cita(...)`, `new Reserva(...)`, `new Agenda()`, `new Factura(...)`                                                                   |
| Constructores                    | Cada clase tiene su constructor; las hijas llaman a `super(...)` (por ejemplo `ClienteVip`, `Efecto` y `Otro`)                                                                                                                 |
| Encapsulamiento                  | Atributos `private` (o `protected` en las clases padre) con getters y setters, algunos con validación (`setTamanoUña`). `Reserva` no tiene `setAdelanto`: el adelanto solo entra por `registrarAdelanto()`, que valida el 50 % |
| Herencia                         | `ClienteVip extends Cliente`, `Efecto extends Servicio` y `Otro extends Servicio`                                                                                                                                              |
| Polimorfismo                     | `@Override` en `getDescuento()` y `mostrarInformacion()` (`ClienteVip`) y en `getTipo()` (`Efecto` y `Otro`); el `Catalogo` guarda efectos y otros en arreglos de `Servicio`                                                   |
| Paquetes                         | `modelo` (clases del negocio) y `principal` (ejecución), con `package` e `import`                                                                                                                                              |

---

## Cómo ejecutarlo

Requiere el **JDK** instalado. Desde la raíz del proyecto, en PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem modelo,principal -Filter *.java).FullName
java -cp out principal.Main
```

Si las tildes o la ñ se ven mal en la consola, ejecuta antes `chcp 65001`.

### Ejemplo de salida (ficha de servicio)

```
======== FICHA DE SERVICIO N.º 1 ========
MARIE NAILS
Fecha: 11/10/2026 10:00
Clienta: Lucía Torres - Normal
Teléfono: 987654321
----------------------------------------
Acrílicas: S/ 60.0
Espejo: S/ 10.0
Stickers: S/ 10.0
Pedrería: S/ 10.0
Reconstrucción de manos (2 dedos): S/ 10.0
Tamaño de uña 6 (recargo): S/ 20.0
----------------------------------------
SUBTOTAL: S/ 120.0
DESCUENTO: S/ 12.0
Motivo: Cumpleaños | Autorizó: Marie
TOTAL COBRADO: S/ 108.0
Adelanto pagado (mínimo 50% del servicio): S/ 30.0
SALDO A PAGAR: S/ 78.0
----------------------------------------
Estado: Pagado | Tipo de pago: Yape
```

---

## Avance de la Evidencia 3

| Etapa | Descripción                                                                       | Semana | Estado                                    |
| ----- | --------------------------------------------------------------------------------- | ------ | ----------------------------------------- |
| 1     | Agregar código fuente de POO al proyecto                                          | 5      | ✅ Hecho                                  |
| 2     | Revisar y corregir código fuente del software de otro equipo                      | 5      | ➖ No se realiza (indicación del docente) |
| 3     | Brindar sugerencias sobre el código del otro equipo                               | 6      | ➖ No se realiza (indicación del docente) |
| 4     | Explicar la complementación de funcionalidades, revisando el código y con pruebas | 6      | ⏳ Pendiente                              |

### Checklist del informe

- [x] Código fuente con programación orientada a objetos
- [x] Clases y objetos
- [x] Constructores
- [x] Encapsulamiento
- [x] Herencia y polimorfismo
- [x] Paquetes
- [x] Pruebas en el `Main` (adelanto válido e inválido, varios efectos, saldo)
- [ ] Referencias bibliográficas
- [ ] Informe con formato `JeanPaulMoncada_Evidencia3`
- [ ] Exposición (máximo 10 minutos, con apoyo visual)

---

## Limitaciones conocidas y mejoras futuras

- Los datos se crean dentro del `Main` y **solo existen mientras el programa está abierto**. A futuro se pueden guardar en archivo o base de datos.
- No hay menú ni ingreso de datos por teclado: el `Main` es una demostración con datos de ejemplo.
- La fecha y la hora se guardan como texto y **no se valida su formato**.
- Cada servicio tiene un **único precio de lista**; en la ficha real de Marie Nails algunos servicios tienen un rango de precio.
- El `Catalogo` usa arreglos de tamaño fijo, así que **no permite agregar servicios nuevos** mientras el programa corre.
- Una cita guarda un solo servicio; los efectos se agregan recién en la ficha, por lo que el adelanto se calcula solo sobre el servicio principal.
- Todavía **no existe la opción de cancelar una reserva** (ni la política sobre el adelanto).
- La carta de fidelización (5.ª visita con descuento) se aplica de forma manual mediante el descuento de la ficha.
