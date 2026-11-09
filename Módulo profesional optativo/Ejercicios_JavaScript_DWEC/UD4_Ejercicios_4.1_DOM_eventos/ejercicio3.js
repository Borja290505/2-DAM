/*
 * Ejercicio 3 - UD4 DOM y eventos
 * Crea 100 checkbox con números aleatorios y dos botones: "Marcar todos" y "Desmarcar todos".
 */

const CANTIDAD = 100;

const contenedor = document.getElementById("casillas");
const contador = document.getElementById("contador");

// Devuelve un número entero aleatorio entre min y max (ambos incluidos)
function aleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// 1. Creamos los 100 checkbox. Cada uno va dentro de un <label> con su número,
//    así también se puede marcar pulsando sobre el número.
for (let i = 0; i < CANTIDAD; i++) {
    let numero = aleatorio(1, 1000);

    let etiqueta = document.createElement("label");
    let casilla = document.createElement("input");
    casilla.type = "checkbox";
    casilla.value = numero;

    etiqueta.appendChild(casilla);
    etiqueta.appendChild(document.createTextNode(" " + numero));
    contenedor.appendChild(etiqueta);
}

// Muestra cuántas casillas hay marcadas
function actualizarContador() {
    let marcadas = contenedor.querySelectorAll("input[type=checkbox]:checked").length;
    contador.textContent = "Marcadas: " + marcadas + " de " + CANTIDAD;
}

// 2. Marca (true) o desmarca (false) todas las casillas
function cambiarTodas(marcar) {
    let casillas = contenedor.querySelectorAll("input[type=checkbox]");
    for (let i = 0; i < casillas.length; i++) {
        casillas[i].checked = marcar;
    }
    actualizarContador();
}

// 3. Eventos de los botones
document.getElementById("marcar").addEventListener("click", function () {
    cambiarTodas(true);
});
document.getElementById("desmarcar").addEventListener("click", function () {
    cambiarTodas(false);
});

// Si se marca o desmarca una casilla a mano, también actualizamos el contador
// (el evento "change" de cada casilla "sube" hasta el contenedor)
contenedor.addEventListener("change", actualizarContador);

actualizarContador();
