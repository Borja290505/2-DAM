function mostrarPosicion(evento){
    document.getElementById("p1").innerHTML="Posicion X"+evento.clientX+"Posicion Y"+evento.clientY;
}
document.onmousemove=mostrarPosicion
