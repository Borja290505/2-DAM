/*
 * Ejercicio 2 - UD4 DOM y eventos
 * Crea dinámicamente una tabla de 100x100 con los números del 1 al 10000.
 * El botón "Calcular números casi primos" pone en amarillo las celdas con números casi primos.
 */

const TAMANO = 100;   // filas y columnas

const tabla = document.getElementById("tabla");
const mensaje = document.getElementById("mensaje");
const botonCalcular = document.getElementById("calcular");

// 1. Crea la tabla de 100 x 100. Cada celda lleva un número que empieza en 1 y sube de 1 en 1.
function crearTabla() {
    let cuerpo = document.createElement("tbody");
    let numero = 1;

    for (let f = 0; f < TAMANO; f++) {
        let fila = document.createElement("tr");
        for (let c = 0; c < TAMANO; c++) {
            let celda = document.createElement("td");
            celda.textContent = numero;
            fila.appendChild(celda);
            numero++;
        }
        cuerpo.appendChild(fila);
    }

    // Añadimos el cuerpo entero a la tabla al final, de una sola vez (es más rápido que celda a celda)
    tabla.appendChild(cuerpo);
}

// 2. Un número es casi primo si tiene UN SOLO divisor aparte de 1 y de él mismo.
//    (Curiosidad: son justo los cuadrados de los números primos: 4, 9, 25, 49...)
function esCasiPrimo(numero) {
    let divisores = 0;   // divisores distintos de 1 y del propio número

    // Basta con probar hasta la raíz cuadrada: si d divide al número, numero / d también lo divide
    for (let d = 2; d * d <= numero; d++) {
        if (numero % d === 0) {
            if (d * d === numero) {
                divisores += 1;   // d y numero / d son el mismo divisor (por ejemplo el 2 en el 4)
            } else {
                divisores += 2;   // d y numero / d son dos divisores distintos
            }
            if (divisores > 1) {
                return false;     // ya tiene más de uno: no hace falta seguir mirando
            }
        }
    }
    return divisores === 1;
}

// 3. Al pulsar el botón, recorremos todas las celdas y marcamos las de números casi primos
function marcarCasiPrimos() {
    let celdas = tabla.getElementsByTagName("td");
    let encontrados = [];

    for (let i = 0; i < celdas.length; i++) {
        let numero = Number(celdas[i].textContent);
        if (esCasiPrimo(numero)) {
            celdas[i].classList.add("casi-primo");   // la clase CSS pone el fondo amarillo
            encontrados.push(numero);
        }
    }

    mensaje.textContent = "Hay " + encontrados.length + " números casi primos: " + encontrados.join(", ");
}

botonCalcular.addEventListener("click", marcarCasiPrimos);

crearTabla();
