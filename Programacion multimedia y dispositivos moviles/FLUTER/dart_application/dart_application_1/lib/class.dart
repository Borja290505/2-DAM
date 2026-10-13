void main(){
  final heroe wolverine = heroe(nombre: "wolverine");

  print(wolverine.nombre);
  print(wolverine.toString());
}

class heroe{
  String nombre;
  String? poder;

  heroe({
    required this.nombre,
    this.poder = 'Sin poder'
  });

  String toString() {
    return 'Soy el metodo toString';
  }

}