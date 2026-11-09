/*
 * Ejercicio 8 - UD4 DOM y eventos
 * Al hacer doble clic en la ventana, el fondo cambia a un color aleatorio.
 */

const textoColor = document.getElementById("color");

// Devuelve un número entero aleatorio entre min y max (ambos incluidos)
function aleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Pasa un número de 0 a 255 a dos cifras hexadecimales: 10 → "0a", 255 → "ff"
function aHexadecimal(numero) {
    return numero.toString(16).padStart(2, "0");
}

// El evento "dblclick" en document salta hagas doble clic donde hagas doble clic
document.addEventListener("dblclick", function () {
    // Un color es una mezcla de rojo, verde y azul, cada uno de 0 a 255
    let rojo = aleatorio(0, 255);
    let verde = aleatorio(0, 255);
    let azul = aleatorio(0, 255);
    let color = "#" + aHexadecimal(rojo) + aHexadecimal(verde) + aHexadecimal(azul);

    document.body.style.backgroundColor = color;

    // Si el fondo es oscuro ponemos el texto en blanco, y si es claro en negro, para que se lea bien
    let brillo = 0.299 * rojo + 0.587 * verde + 0.114 * azul;
    document.body.style.color = (brillo < 140) ? "white" : "black";

    textoColor.textContent = "Color actual: " + color.toUpperCase() + " (rgb " + rojo + ", " + verde + ", " + azul + ")";
});
