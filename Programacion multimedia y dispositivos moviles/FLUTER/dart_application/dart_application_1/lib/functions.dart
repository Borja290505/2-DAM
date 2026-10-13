import 'dart:convert';
import 'dart:math';

void main(){
  print(saludar());
  print(saludoCompleto(nombre: "Borja",mensaje: "Hola"));
}

String saludar() => ('Hola Borja');
int sumar(int a, int b) => ( a+b);

int sumarOpcional(int a, [int b = 0]){
  return a + b;
}

String saludoCompleto({required String nombre, String? mensaje}){
  return '$mensaje $nombre';
}