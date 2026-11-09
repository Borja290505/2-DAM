/*
 * Ejercicio 6 - UD4 DOM y eventos
 * "Comenzar Saludos" lanza un setInterval que cada 5 segundos muestra un alert con "Hola".
 * "Parar Saludos" detiene esa secuencia con clearInterval.
 */

const INTERVALO = 5000;   // 5 segundos, en milisegundos

const estado = document.getElementById("estado");

// Aquí guardamos el identificador que devuelve setInterval (lo necesitamos para pararlo)
let idIntervalo = null;

document.getElementById("comenzar").addEventListener("click", function () {
    // Si ya está en marcha no lanzamos otro (si no, saldrían saludos repetidos)
    if (idIntervalo !== null) {
        return;
    }

    idIntervalo = setInterval(function () {
        alert("Hola");
    }, INTERVALO);

    estado.textContent = "Saludos en marcha: cada 5 segundos aparecerá un «Hola».";
});

document.getElementById("parar").addEventListener("click", function () {
    clearInterval(idIntervalo);   // detiene la secuencia
    idIntervalo = null;
    estado.textContent = "Saludos parados.";
});
