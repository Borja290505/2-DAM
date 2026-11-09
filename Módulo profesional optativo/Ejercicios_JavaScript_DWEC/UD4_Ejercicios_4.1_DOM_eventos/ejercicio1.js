/*
 * Ejercicio 1 - UD4 DOM y eventos
 * Al pulsar "Nuevo número" se añade un <li> con un número aleatorio (del 1 al 100) a la lista <ul>.
 */

// Elementos de la página que vamos a usar
const boton = document.getElementById("nuevo");
const lista = document.getElementById("lista");

// Devuelve un número entero aleatorio entre min y max (ambos incluidos)
function aleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Crea un <li> con un número aleatorio y lo añade al final de la lista
function anadirNumero() {
    let elemento = document.createElement("li");   // 1. creamos el nodo <li>
    elemento.textContent = aleatorio(1, 100);       // 2. le ponemos el número como texto
    lista.appendChild(elemento);                    // 3. lo añadimos como hijo de la <ul>
}

// Asociamos la función al evento "click" del botón
boton.addEventListener("click", anadirNumero);
