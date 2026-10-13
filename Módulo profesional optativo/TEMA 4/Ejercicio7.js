function letraDNI(numeroDNI){
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    return letras[numeroDNI%23];
}

function calcularDNI(evento){
    var letra = evento.key.toUpperCase();
    var resultadoContendor = document.getElementById("resultado");
    resultadoContendor.innerHTML="DNIs con letra "+letra+ " ";

	for(i=0;i<=9999;i++){
        if(letraDNI(i)===letra){
            document.getElementById("resultado").innerHTML+=i+" ; ";
        }
    }
}

document.onkeydown=calcularDNI;