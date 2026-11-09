/*
 * Ejercicio 4 - UD4 DOM y eventos
 * Clic en un párrafo → se oculta. Doble clic → se elimina del documento.
 * El botón "Reaparecer" vuelve a mostrar los ocultos (los eliminados ya no existen).
 */

// Al hacer doble clic, el navegador lanza antes DOS eventos "click".
// Si ocultáramos el párrafo en el primer clic, desaparecería y nunca llegaría el "dblclick".
// Por eso, tras un clic esperamos un poco: si en ese tiempo llega el doble clic, cancelamos el ocultar.
const ESPERA_DOBLE_CLIC = 300;   // milisegundos

const parrafos = document.querySelectorAll(".parrafo");

parrafos.forEach(function (parrafo) {
    let temporizador = null;   // cada párrafo tiene su propio temporizador

    // CLIC: ocultar (con un pequeño retraso, por si es un doble clic)
    parrafo.addEventListener("click", function () {
        clearTimeout(temporizador);
        temporizador = setTimeout(function () {
            parrafo.classList.add("oculto");   // la clase .oculto tiene display: none
        }, ESPERA_DOBLE_CLIC);
    });

    // DOBLE CLIC: eliminar el elemento del documento
    parrafo.addEventListener("dblclick", function () {
        clearTimeout(temporizador);   // cancelamos el "ocultar" que dejaron programado los clics
        parrafo.remove();
    });
});

// Botón "Reaparecer": quita la clase .oculto a los párrafos que siguen en la página
document.getElementById("reaparecer").addEventListener("click", function () {
    let ocultos = document.querySelectorAll(".parrafo.oculto");
    ocultos.forEach(function (parrafo) {
        parrafo.classList.remove("oculto");
    });
});
