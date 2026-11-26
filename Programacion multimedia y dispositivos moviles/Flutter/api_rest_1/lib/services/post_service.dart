import 'package:api_rest_1/models/post.dart';
import 'package:http/http.dart' as http;

class PostsService {

  //Hacemos la peticion al API para solicitar la lista de Posts
  Future <List<Post>?> obtenerPosts() async {
    //Creamos un cliente HTTP que nos va ha permitir enviar la peticion
    var client = http.Client();

    //Convertimos la direccion o endPoint en un objeto Uri
    var uri = Uri.parse('https://jsonplaceholder.typicode.com/posts');
 
    //Enviamos la peticion de tipo get y esperamos la respuesta del servidor
    var response = await client.get(uri);

    //El codigo 200 indica que la peticion sea realizado correctamente
    if(response.statusCode == 200){
      var json = response.body;

      //Decodificamos ese texto y trasformamos cada elemento JSON en un objeto Post
      return postFromJson( json );
    }
    return null;

    //Si el codigo no es 200 no se devuelve ninguna lista (null)
  }

}