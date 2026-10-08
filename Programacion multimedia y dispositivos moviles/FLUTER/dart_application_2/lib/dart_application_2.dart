void main(){
  List<String> alumnos = [
    'Ana',
    'Luis',
    'Marta'
  ];

  alumnos.add('Pedro');

  print(alumnos);

  for(var alumno in alumnos){
    print(alumno);
  }
}