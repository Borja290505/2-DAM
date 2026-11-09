/*
 * Simulacro - Ejercicio 4: Lista de tareas
 * Añadir con botón o Enter, clic = tachar (con this), doble clic = eliminar,
 * contador de pendientes y botón para borrar las completadas.
 */

const caja = document.getElementById("texto");
const lista = document.getElementById("lista");
const aviso = document.getElementById("aviso");
const contador = document.getElementById("contador");

// Al hacer doble clic saltan antes 2 clics: esperamos un poco antes de tachar
// y, si llega el doble clic, cancelamos el tachado
const ESPERA_DOBLE_CLIC = 250;   // milisegundos

// Actualiza "Pendientes: X de Y"
function actualizarContador() {
    let total = lista.getElementsByTagName("li").length;
    let hechas = lista.getElementsByClassName("hecha").length;
    contador.textContent = "Pendientes: " + (total - hechas) + " de " + total;
}

// true si ya hay una tarea con ese texto (sin distinguir mayúsculas)
function existeTarea(texto) {
    let tareas = lista.getElementsByTagName("li");
    for (let i = 0; i < tareas.length; i++) {
        if (tareas[i].textContent.toLowerCase() === texto.toLowerCase()) {
            return true;
        }
    }
    return false;
}

// CLIC en una tarea: "this" es el <li> pulsado
function tacharTarea() {
    let tarea = this;   // OJO: dentro del setTimeout "this" ya NO es el <li>, por eso lo guardamos
    clearTimeout(tarea.temporizador);
    tarea.temporizador = setTimeout(function () {
        tarea.classList.toggle("hecha");
        actualizarContador();
    }, ESPERA_DOBLE_CLIC);
}

// DOBLE CLIC en una tarea: la eliminamos
function eliminarTarea() {
    clearTimeout(this.temporizador);   // cancelamos el tachado pendiente
    this.remove();
    actualizarContador();
}

// Añade una tarea con el texto de la caja
function anadirTarea() {
    let texto = caja.value.trim();

    if (texto === "") {
        aviso.textContent = "No puedes añadir una tarea vacía.";
        return;
    }
    if (existeTarea(texto)) {
        aviso.textContent = "La tarea «" + texto + "» ya está en la lista.";
        return;
    }
    aviso.textContent = "";

    // Creamos el <li> con createElement (sin innerHTML)
    let tarea = document.createElement("li");
    tarea.textContent = texto;
    tarea.addEventListener("click", tacharTarea);
    tarea.addEventListener("dblclick", eliminarTarea);
    lista.appendChild(tarea);

    caja.value = "";
    caja.focus();
    actualizarContador();
}

// Borra todas las tareas tachadas
function borrarCompletadas() {
    // querySelectorAll devuelve una lista "fija": se puede borrar mientras se recorre
    let hechas = lista.querySelectorAll(".hecha");
    for (let i = 0; i < hechas.length; i++) {
        hechas[i].remove();
    }
    actualizarContador();
}

// ----- Eventos -----
document.getElementById("anadir").addEventListener("click", anadirTarea);
document.getElementById("borrarHechas").addEventListener("click", borrarCompletadas);

// Enter dentro de la caja también añade
caja.addEventListener("keydown", function (evento) {
    if (evento.key === "Enter") {
        anadirTarea();
    }
});

actualizarContador();