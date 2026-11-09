/*
 * Ejercicio 7 - UD4 DOM y eventos
 * Al pulsar una tecla, calcula cuántos DNIs de 4 cifras (0001 a 9999) tienen esa letra
 * y los muestra, con su letra, en un <p>.
 */

// Letras del DNI: la posición es el resto de dividir el número entre 23
const LETRAS_DNI = ["T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B",
                    "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"];

const titulo = document.getElementById("titulo");
const resultado = document.getElementById("resultado");

// Cada vez que se pulsa una tecla en la página...
document.addEventListener("keydown", function (evento) {
    // evento.key es el carácter de la tecla pulsada ("a", "B", "7"...).
    // Ignoramos las teclas especiales (Shift, Enter, flechas...), que tienen nombres largos,
    // y los atajos con Ctrl / Alt / Cmd (por ejemplo Ctrl+R para recargar)
    if (evento.key.length !== 1 || evento.ctrlKey || evento.altKey || evento.metaKey) {
        return;
    }

    let letra = evento.key.toUpperCase();

    // Si la letra no está en la lista, ningún DNI la tiene (la I, la Ñ, la O y la U no se usan)
    if (!LETRAS_DNI.includes(letra)) {
        titulo.textContent = "Ningún DNI tiene la letra «" + evento.key + "»";
        resultado.textContent = "Letras que se usan en el DNI: " + LETRAS_DNI.slice().sort().join(", ");
        return;
    }

    // Recorremos los DNI del 1 al 9999 y guardamos los que tienen esa letra
    let dnis = [];
    for (let numero = 1; numero <= 9999; numero++) {
        if (LETRAS_DNI[numero % 23] === letra) {
            // padStart rellena con ceros por la izquierda: 7 → "0007"
            dnis.push(String(numero).padStart(4, "0") + "-" + letra);
        }
    }

    titulo.textContent = dnis.length + " DNIs de 4 cifras tienen la letra " + letra;
    resultado.textContent = dnis.join(" ");
});
