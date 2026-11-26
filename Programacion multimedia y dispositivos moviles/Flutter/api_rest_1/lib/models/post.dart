//Este archivo contiene el modelo de datos Post
// y las funciones para convertir el JSON de la API y objetos de Dart.

import 'dart:convert';

List<Post> postFromJson(String str) => List<Post>.from(json.decode(str).map((x) => Post.fromJson(x)));

String postToJson(List<Post> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Post{
  String title;
  String? body; //Quire decir que puede ser nulo
  int id;
  int userId;

  Post({
    required this.id,
    required this.title, 
    required this.userId,
    this.body
  });

  //Constructor de fabrica
  factory Post.fromJson(Map<String, dynamic> json)=> Post(
    userId: json["userId"],
    id: json["id"],
    title: json["title"],
    body: json["body"]
  );

  //Devuelve un mapa con las propiedades del objeto, listo para codificar com Json
  Map<String, dynamic> toJson() => {
    "userId": userId,
    "id": id,
    "body": body,
    "title": title
  };
  
}