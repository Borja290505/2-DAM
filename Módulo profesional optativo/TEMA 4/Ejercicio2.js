function crearTabla(){
    var tabla = document.createElement("table")
    var num = 1;

    for(var i=0; i<100; i++){
        var fila = document.createElement("tr")
        for(var j=0; j<100;j++){
            var celda = document.createElement("td")
            var texto = document.createTextNode(num)

            celda.appendChild(texto);
            fila.appendChild(celda);

            if(esCasiPrimo(num)){
                celda.style.backgroundColor="yellow";
            }

            num++;
        }
        tabla.appendChild(fila)
    }
    document.body.appendChild(tabla)
}

function esCasiPrimo(n){
    var divisores=0;
    for(var i=2;i<n;i++){
        if(n%i==0){
            divisores++;
            if(divisores>1){
                return false;
            }
        }
    }
    if(divisores==1){
        return true
    }else{
        return false
    }
}