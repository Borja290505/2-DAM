
import 'package:api_rest_1/models/user.dart';
import 'package:dio/dio.dart';

class UserService {
  
  //Metodo para obtener la lista de usuarios usando DIO
  Future<List<dynamic>> obtenerUsuarioConDio() async{
    final dio = Dio();
    final response = await dio.get('https://jsonplaceholder.typicode.com/users');
    if(response.statusCode==200){
      final List<dynamic> data = response.data;
      return data.map((json) => User.fromJson(json)).toList();
    }else{
      throw Exception("Error al cargar los usuario con Dio");
    }
  }
}