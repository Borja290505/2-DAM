var estado=-1;

function comenzar(){
    if(estado!=-1){
        console.log("Ya estamos saludando");
    }else{
        estado=setInterval(()=>{
            alert("Hola")
        },5000);
    }
}

function parar(){
    if(estado!=-1){
        clearInterval(estado);
        estado=-1;
    }else{
        console.log("No hay saludo a pasar");
    }
}