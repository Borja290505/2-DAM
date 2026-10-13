void main() {
  //Los maps son pares de valores
  final Map<String, dynamic> pokemon ={
    'nombre':'Ditto',
    'hp'    : 100,
    'isAlive':true,
    'sprites':{
      1: 'ditto/front.png',
      2: 'ditto/back.png'
    }
  };
  
  print(pokemon);
  print('nombre: ${pokemon}');
  print('Back: ${pokemon['sprites']?[2]}'); 

}
