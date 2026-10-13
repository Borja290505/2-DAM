function numeroAleatorio(min,max){
    return Math.round(Math.random()*(max-min)+min)
}
function cambiarColor(evento){
    document.body.bgColor="rgb("+numeroAleatorio(0,255)+","+numeroAleatorio(0,255)+","+numeroAleatorio(0,255)+")";
}

document.onclick=cambiarColor;