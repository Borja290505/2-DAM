import 'package:api_rest_1/models/post.dart';
import 'package:api_rest_1/services/post_service.dart';
import 'package:flutter/material.dart';

class PostsScreen extends StatefulWidget {
   
  const PostsScreen({super.key});

  @override
  State<PostsScreen> createState() => _PostsScreenState();
}

class _PostsScreenState extends State<PostsScreen> {
  //La inicializo a null mientras no haya datos disponibles
  List<Post>? listPosts;
  //Indicador para decir si esta cargando o ha termindado la carga
  bool isLoading = false;

  @override
  void initState(){
    super.initState();
    //Aqui iniciaare la carga de los Posts de la API
    obtenerPost();
  }

  //Obtener las publicaciones
  void obtenerPost() async{
    listPosts = await PostsService().obtenerPosts();
    //Solo marcaremos la carga como completada si se recibio una respuesta valida
    if(listPosts != null){
      setState(() {
        isLoading = true;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Posts'),),
      body: Visibility(
        visible: isLoading,
        replacement: Center(child: CircularProgressIndicator.adaptive(),),
        child: ListView.builder(
          itemCount: listPosts?.length,
          itemBuilder: (context, index){
            return Row(
              children: [
                Container(
                  height:50,
                  width: 50,
                  decoration: BoxDecoration(
                    borderRadius: .circular(12),
                    color: Colors.lightBlue
                  ),
                ),
                SizedBox(width: 16),
                Expanded(
                  child:  Column(
                    crossAxisAlignment: .start,
                    children: [
                    Text(listPosts![index].title ?? '',maxLines: 3,overflow: .ellipsis,style: TextStyle(fontSize: 20,fontWeight: FontWeight.bold),),
                    Text(listPosts![index].body ?? '',maxLines: 3,overflow: .ellipsis,)
                    ],
                  )
                )  
              ],
            );
          }
        ),
      ),
    );
  }

  
}