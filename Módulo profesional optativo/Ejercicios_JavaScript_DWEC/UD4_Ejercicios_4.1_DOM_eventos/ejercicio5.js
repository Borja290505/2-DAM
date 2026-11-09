/*
 * Ejercicio 5 - UD4 DOM y eventos
 * Muestra en todo momento la posición del ratón usando el evento "mousemove" y el objeto event.
 */

const posicion = document.getElementById("posicion");
const detalle = document.getElementById("detalle");

// Cada vez que el ratón se mueve, el navegador llama a esta función
// y le pasa el objeto event con la información del evento (entre otras cosas, las coordenadas).
document.addEventListener("mousemove", function (evento) {
    // clientX / clientY: posición respecto a la parte visible de la ventana
    posicion.textContent = "X: " + evento.clientX + " px  |  Y: " + evento.clientY + " px";

    // Otras coordenadas que también trae el objeto event
    detalle.innerHTML =
        "Respecto a la ventana (clientX, clientY): " + evento.clientX + ", " + evento.clientY + "<br>" +
        "Respecto a la página (pageX, pageY): " + evento.pageX + ", " + evento.pageY + "<br>" +
        "Respecto a la pantalla (screenX, screenY): " + evento.screenX + ", " + evento.screenY;
});
