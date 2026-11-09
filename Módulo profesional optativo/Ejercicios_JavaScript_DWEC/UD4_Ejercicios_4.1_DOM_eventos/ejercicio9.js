/*
 * Ejercicio 9 - UD4 DOM y eventos
 * Arrastrar y soltar (drag & drop): al soltar la bola de papel sobre la papelera vacía,
 * la imagen cambia a una papelera llena.
 */

const IMAGEN_VACIA = "img/papelera_vacia.svg";
const IMAGEN_LLENA = "img/papelera_llena.svg";

const bola = document.getElementById("bola");
const papelera = document.getElementById("papelera");
const mensaje = document.getElementById("mensaje");

// 1. Empieza el arrastre de la bola: guardamos qué se está arrastrando
bola.addEventListener("dragstart", function (evento) {
    evento.dataTransfer.setData("text/plain", "bola");
});

// 2. La bola pasa por encima de la papelera.
//    Por defecto no se puede soltar nada sobre un elemento: con preventDefault() lo permitimos.
papelera.addEventListener("dragover", function (evento) {
    evento.preventDefault();
});

// Resaltamos la papelera mientras la bola está encima, y quitamos el resaltado al salir
papelera.addEventListener("dragenter", function () {
    papelera.classList.add("encima");
});
papelera.addEventListener("dragleave", function () {
    papelera.classList.remove("encima");
});

// 3. Se suelta la bola sobre la papelera
papelera.addEventListener("drop", function (evento) {
    evento.preventDefault();   // evita que el navegador intente abrir la imagen arrastrada
    papelera.classList.remove("encima");

    if (evento.dataTransfer.getData("text/plain") === "bola") {
        papelera.src = IMAGEN_LLENA;          // cambiamos la imagen: papelera llena
        papelera.alt = "Papelera llena";
        bola.style.visibility = "hidden";     // la bola ya está dentro de la papelera
        mensaje.textContent = "¡Bien! La bola de papel está en la papelera.";
    }
});

// Botón para volver a la situación inicial
document.getElementById("reiniciar").addEventListener("click", function () {
    papelera.src = IMAGEN_VACIA;
    papelera.alt = "Papelera vacía";
    bola.style.visibility = "visible";
    mensaje.textContent = "Arrastra la bola de papel hasta la papelera.";
});
